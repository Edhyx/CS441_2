/*
CS441 Equipe N°2

Commande.java
*/

package fr.esisar.cs441.groupe2.base;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Commande {

	private int idCommande;
    private String date;
    private int prixTotal;
    private Client client;
    ArrayList<LigneCommande> ligneCommandes;
	
    public Commande(int idCommande, String date, int prixTotal, Client client,
			ArrayList<LigneCommande> ligneCommandes) {
		super();
		this.idCommande = idCommande;
		this.date = date;
		this.prixTotal = prixTotal;
		this.client = client;
		this.ligneCommandes = ligneCommandes;
	}

	public Commande(int idCommande, String date, int prixTotal, Client client) {
		super();
		this.idCommande = idCommande;
		this.date = date;
		this.prixTotal = prixTotal;
		this.client = client;
		this.ligneCommandes = new ArrayList<LigneCommande>();
	}

	public int getIdCommande() {
		return idCommande;
	}

	public String getDate() {
		return date;
	}

	public int getPrixTotal() {
		return prixTotal;
	}

	public Client getClient() {
		return client;
	}

	public ArrayList<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setPrixTotal(int prixTotal) {
		this.prixTotal = prixTotal;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setLigneCommandes(ArrayList<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}
	
	public void add(Statement stmt) throws SQLException{
	    String sql_element = "INSERT INTO Commmande " +
	            "VALUES ("+idCommande+", '"+date+"', "+prixTotal+", '"+client.getAdresseMail()+"')";
	    try{
	    stmt.executeUpdate(sql_element);
	    System.out.println("Commande '"+idCommande+"' cree");
	    } catch (SQLException e){
	    	System.out.println("Commande '"+idCommande+"' existant");
	    }
	}
	
	public void delete(Statement stmt) throws SQLException{
	    String sql_delete = "DELETE FROM Commande " +
	            "WHERE idCommande = "+idCommande+"";
	    try{
	    stmt.executeUpdate(sql_delete);
	    System.out.println("Commande '"+idCommande+"' supprime");
		} catch (SQLException e){
	    	System.out.println("Table Commande non existant");
	    }
	}
	
	
	public void affiche(Statement stmt) throws SQLException{
		try{
		String sql_aff = "SELECT idCommande, date, prixTotal, adresseMail FROM Album ";
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