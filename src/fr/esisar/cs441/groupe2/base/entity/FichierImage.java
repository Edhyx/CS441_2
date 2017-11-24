/*
CS441 Equipe N°2

FichierImage.java
*/

package fr.esisar.cs441.groupe2.base.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FichierImage {

	private String cheminAcces;
    private String appareilPhoto;
    private String objectif;
    private int distanceFocale;
    private int sensibiliteISO;
    private int ouverture;
    private int vitesseObturation;
    private Client client;
	
    public FichierImage(String cheminAcces, String appareilPhoto, String objectif, int distanceFocale,
			int sensibiliteISO, int ouverture, int vitesseObturation, Client client) {
		super();
		this.cheminAcces = cheminAcces;
		this.appareilPhoto = appareilPhoto;
		this.objectif = objectif;
		this.distanceFocale = distanceFocale;
		this.sensibiliteISO = sensibiliteISO;
		this.ouverture = ouverture;
		this.vitesseObturation = vitesseObturation;
		this.client = client;
	}
    
	public String getCheminAcces() {
		return cheminAcces;
	}
	public String getAppareilPhoto() {
		return appareilPhoto;
	}
	public String getObjectif() {
		return objectif;
	}
	public int getDistanceFocale() {
		return distanceFocale;
	}
	public int getSensibiliteISO() {
		return sensibiliteISO;
	}
	public int getOuverture() {
		return ouverture;
	}
	public int getVitesseObturation() {
		return vitesseObturation;
	}
	public Client getClient() {
		return client;
	}
	public void setCheminAcces(String cheminAcces) {
		this.cheminAcces = cheminAcces;
	}
	public void setAppareilPhoto(String appareilPhoto) {
		this.appareilPhoto = appareilPhoto;
	}
	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}
	public void setDistanceFocale(int distanceFocale) {
		this.distanceFocale = distanceFocale;
	}
	public void setSensibiliteISO(int sensibiliteISO) {
		this.sensibiliteISO = sensibiliteISO;
	}
	public void setOuverture(int ouverture) {
		this.ouverture = ouverture;
	}
	public void setVitesseObturation(int vitesseObturation) {
		this.vitesseObturation = vitesseObturation;
	}
	public void setClient(Client client) {
		this.client = client;
	}
    
	public void add(Statement stmt) throws SQLException{
	    String sql_element = "INSERT INTO FichierImage " +
	            "VALUES ("+cheminAcces+", '"+appareilPhoto+"', '"+objectif+"', "+distanceFocale+", "+sensibiliteISO+
	            			", "+ouverture+", "+vitesseObturation+", '"+client.getAdresseMail()+"')";
	    try{
	    stmt.executeUpdate(sql_element);
	    System.out.println("FichierImage '"+cheminAcces+"' cree");
	    } catch (SQLException e){
	    	System.out.println("FichierImage '"+cheminAcces+"' existant");
	    }
	}
	
	public void delete(Statement stmt) throws SQLException{
	    String sql_delete = "DELETE FROM FichierImage " +
	            "WHERE cheminAcces = "+cheminAcces+"";
	    try{
	    stmt.executeUpdate(sql_delete);
	    System.out.println("FichierImage '"+cheminAcces+"' supprime");
		} catch (SQLException e){
	    	System.out.println("Table  FichierImage non existant");
	    }
	}
	
	
	public void affiche(Statement stmt) throws SQLException{
		try{
		String sql_aff = "SELECT cheminAcces, appareilPhoto, objectif, distanceFocale, sensibiliteISO, ouverture, vitesseObturation, adresseMail FROM FichierImage ";
	    ResultSet rs = stmt.executeQuery(sql_aff);
	    
	    boolean a;
	    while(a=rs.next())
	    if (a==false){
	    	System.out.println("La table FichierImage est vide"); 
	    }
	    else{
	       //Retrieve by column name
	       String id  = rs.getString("cheminAcces");
	       String appareilPhoto = rs.getString("appareilPhoto");
	       String objectif = rs.getString("objectif");
	       int distanceFocale = rs.getInt("distanceFocale");
	       int sensibiliteISO = rs.getInt("sensibiliteISO");
	       int ouverture = rs.getInt("ouverture");
	       int vitesseObturation = rs.getInt("vitesseObturation");
	       String adresseMail = rs.getString("adresseMail");

	       //Display values
	       System.out.print("cheminAcces: " + id);
	       System.out.print(", appareilPhoto: " + appareilPhoto);
	       System.out.print(", objectif: " + objectif);
	       System.out.println(", distanceFocale: " + distanceFocale);
	       System.out.println(", sensibiliteISO: " + sensibiliteISO);
	       System.out.println(", ouverture: " + ouverture);
	       System.out.println(", vitesseObturation: " + vitesseObturation);
	       System.out.println(", adresseMail: " + adresseMail);
	    }
	    rs.close();
		} catch (SQLException e){
	    	System.out.println("Table FichierImage non existante");
	    }
	}
	
}