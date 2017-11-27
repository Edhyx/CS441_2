/*
CS441 Equipe N°2

Album.java
*/

package fr.esisar.cs441.groupe2.base.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/*
 * classe Album
 * Association : verifier pour ligneCommande cas ou c'est 0
 * 
 */
public class Album {


    private int idAlbum;
    private String titre;
    private String sousTitre;
    private Client creeParClient;
    private ArrayList<Contient>	fichierImages;
    private ArrayList<LigneCommande> ligneCommandes;
	
    public Album(int idAlbum, String titre, String sousTitre, Client creeParClient) {
		super();
		this.idAlbum = idAlbum;
		this.titre = titre;
		this.sousTitre = sousTitre;
		this.creeParClient = creeParClient;
		this.fichierImages = new ArrayList<Contient>();
		this.ligneCommandes = new ArrayList<LigneCommande>();
	}
    
    public Album(int idAlbum, String titre, String sousTitre, Client creeParClient,
			ArrayList<Contient> fichierImages, ArrayList<LigneCommande> ligneCommandes) {
		super();
		this.idAlbum = idAlbum;
		this.titre = titre;
		this.sousTitre = sousTitre;
		this.creeParClient = creeParClient;
		this.fichierImages = fichierImages;
		this.ligneCommandes = ligneCommandes;
	}

	public Album(int idAlbum, String titre, String sousTitre, Client creeParClient,
			ArrayList<Contient> fichierImages) {
		super();
		this.idAlbum = idAlbum;
		this.titre = titre;
		this.sousTitre = sousTitre;
		this.creeParClient = creeParClient;
		this.fichierImages = fichierImages;
		this.ligneCommandes = new ArrayList<LigneCommande>();
	}

	public int getIdAlbum() {
		return idAlbum;
	}

	public String getTitre() {
		return titre;
	}

	public String getSousTitre() {
		return sousTitre;
	}

	public Client getCreeParClient() {
		return creeParClient;
	}

	public ArrayList<Contient> getFichierImages() {
		return fichierImages;
	}

	public ArrayList<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setIdAlbum(int idAlbum) {
		this.idAlbum = idAlbum;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public void setSousTitre(String sousTitre) {
		this.sousTitre = sousTitre;
	}

	public void setCreeParClient(Client creeParClient) {
		this.creeParClient = creeParClient;
	}

	public void setFichierImages(ArrayList<Contient> fichierImages) {
		this.fichierImages = fichierImages;
	}

	public void setLigneCommandes(ArrayList<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	} 
    
	public void add(Statement stmt) throws SQLException{
	    String sql_element = "INSERT INTO Album " +
	            "VALUES ("+idAlbum+", '"+titre+"', '"+sousTitre+"', '"+creeParClient.getAdresseMail()+"')";
	    try{
	    stmt.executeUpdate(sql_element);
	    System.out.println("Album '"+idAlbum+"' cree");
	    } catch (SQLException e){
	    	System.out.println("idAlbum '"+idAlbum+"' existant");
	    }
	}
	
	public void delete(Statement stmt) throws SQLException{
	    String sql_delete = "DELETE FROM Album " +
	            "WHERE idAlbum = "+idAlbum+"";
	    try{
	    stmt.executeUpdate(sql_delete);
	    System.out.println("Album '"+idAlbum+"' supprime");
		} catch (SQLException e){
	    	System.out.println("Table  Album non existant");
	    }
	}
	
	
	public void affiche(Statement stmt) throws SQLException{
		try{
		String sql_aff = "SELECT idAlbum, titre, sousTitre, adresseMail FROM Album ";
	    ResultSet rs = stmt.executeQuery(sql_aff);
	    
	    boolean a=rs.next();
	    if (a==false){
	    	System.out.println("La table LigneCommande est vide"); 
	    }
	    while(a){
	       //Retrieve by column name
	       String id  = rs.getString("idAlbum");
	       String titre = rs.getString("titre");
	       String sousTitre = rs.getString("sousTitre");
	       String adresseMail = rs.getString("adresseMail");
	       //Display values
	       System.out.print("idAlbum: " + id);
	       System.out.print(", titre: " + titre);
	       System.out.print(", sousTitre: " + sousTitre);
	       System.out.println(", adresseMail: " + adresseMail);
	       a=rs.next();
	    }
	    rs.close();
		} catch (SQLException e){
	    	System.out.println("Table Album non existante");
	    }
	}
}