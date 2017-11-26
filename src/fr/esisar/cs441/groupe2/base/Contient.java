/*
CS441 Equipe N°2

Contient.java
*/

package fr.esisar.cs441.groupe2.base;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * il faut gerer l'association
 */
public class Contient {

	private int numOrdre;
    private String titre;
    private String commentaire;
    private FichierImage fichierImages;
    private ArrayList<Album> albums;
    
    public Contient(int numOrdre, String titre, String commentaire, ArrayList<Album> albums, FichierImage fichierImages){
    	this.numOrdre = numOrdre;
    	this.titre = titre;
    	this.commentaire = commentaire;
    	this.albums = albums;
    	this.fichierImages = fichierImages;
    }
    
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getNumOrdre() {
		return numOrdre;
	}
	public void setNumOrdre(int numOrdre) {
		this.numOrdre = numOrdre;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	public void add(Statement stmt) throws SQLException{
	    String sql_element = "INSERT INTO Contient " +
	            "VALUES ("+numOrdre+", '"+titre+"', "+commentaire+", '"+fichierImages.getCheminAcces()+"')";
	    try{
	    stmt.executeUpdate(sql_element);
	    System.out.println("Contient '"+ fichierImages.getCheminAcces() +"' cree");
	    } catch (SQLException e){
	    	System.out.println("Contient '"+numOrdre+"' existant");
	    }
	}
	
	public void delete(Statement stmt) throws SQLException{
	    String sql_delete = "DELETE FROM Contient " +
	            "WHERE cheminAcces = "+numOrdre+"";
	    try{
	    stmt.executeUpdate(sql_delete);
	    System.out.println("Contient '"+numOrdre+"' supprime");
		} catch (SQLException e){
	    	System.out.println("Table Contient non existant");
	    }
	}
	
	public void affiche(Statement stmt) throws SQLException{
		try{
		String sql_aff = "SELECT idCommande, titre, commentaire, adresseMail FROM Contient ";
	    ResultSet rs = stmt.executeQuery(sql_aff);
	    
	    boolean a;
	    while(a=rs.next())
	    if (a==false){
	    	System.out.println("La table Commande est vide"); 
	    }
	    else{
	       //Retrieve by column name
	       int id  = rs.getInt("idCommande");
	       String date = rs.getString("date");
	       int prixTotal = rs.getInt("prixTotal");
	       String adresseMail = rs.getString("adresseMail");

	       //Display values
	       System.out.print("idCommande: " + id);
	       System.out.print(", date: " + date);
	       System.out.print(", prixTotal: " + prixTotal);
	       System.out.println(", adresseMail: " + adresseMail);
	    }
	    rs.close();
		} catch (SQLException e){
	    	System.out.println("Table Commande non existante");
	    }
	}
}