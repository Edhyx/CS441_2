/*
CS441 Equipe N°2

LigneCommande.java
*/

package fr.esisar.cs441.groupe2.base;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LigneCommande {

    private int quantite;
    private Album album;
    private Commande commande;
    private Format format;
	
    public LigneCommande(int quantite, Album album, Commande commande, Format format) {
		super();
		this.quantite = quantite;
		this.album = album;
		this.commande = commande;
		this.format = format;
	}

	public int getQuantite() {
		return quantite;
	}

	public Album getAlbum() {
		return album;
	}

	public Commande getCommande() {
		return commande;
	}

	public Format getFormat() {
		return format;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public void setFormat(Format format) {
		this.format = format;
	}
	
	public void add(Statement stmt) throws SQLException{
	    String sql_element = "INSERT INTO LigneCommande " +
	            "VALUES ("+quantite+", '"+commande.getIdCommande()+"', '"+format.getIdFormat()
	            +"', '"+album.getIdAlbum()+"')";
	    try{
	    stmt.executeUpdate(sql_element);
	    System.out.println("LigneCommande '"+quantite+"' cree");
	    } catch (SQLException e){
	    	System.out.println("LigneCommande '"+quantite+"' existant");
	    }
	}	
	
	public void affiche(Statement stmt) throws SQLException{
		try{
		String sql_aff = "SELECT quantite, idCommande, idFormat, idAlbum FROM LigneCommande ";
	    ResultSet rs = stmt.executeQuery(sql_aff);
	    
	    boolean a;
	    while(a=rs.next())
	    if (a==false){
	    	System.out.println("La table LigneCommande est vide"); 
	    }
	    else{
	       //Retrieve by column name
	       int quantite = rs.getInt("quantite");
	       String idCommande = rs.getString("idCommande");
	       String idFormat = rs.getString("idFormat");
	       String idAlbum = rs.getString("idAlbum");

	       //Display values
	       System.out.print("quantite: " + quantite);
	       System.out.print(", idCommande: " + idCommande);
	       System.out.print(", idFormat: " + idFormat);
	       System.out.print(", idAlbum: " + idAlbum);
	    }
	    rs.close();
		} catch (SQLException e){
	    	System.out.println("Table LigneCommande non existante");
	    }
	}
    
}