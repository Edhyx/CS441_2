package fr.esisar.cs441.groupe2.base.BDDs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.esisar.cs441.groupe2.base.entity.Client;

public class ClientDAO {
	
	private Statement stmt;

	public ClientDAO(Statement stmt) {
		super();
		this.stmt = stmt;
	}
	
	public void add(Client client) {
		
		// elements de base
	    String sql_element = "INSERT INTO Client "
	    				  	+ "VALUES ('" 
	    				  	+ client.getAdresseMail()
	    				  	+ "', '"
	    				  	+ client.getNom()
	    				  	+ "', '"
	    				  	+ client.getPrenom()
	    				  	+ "', '"
	    				  	+ client.getPassword()
	    				  	+ "')";
	    
	    try{
		    this.stmt.executeUpdate(sql_element);
		    System.out.println("Client '" + client.getAdresseMail() + "' cree");
	    } catch (SQLException e){
	    	System.out.println("Client '" + client.getAdresseMail() + "' existante");
	    }
	}
	
	public void delete(Client client) {
	    String sql_delete = "DELETE FROM Client " 
	    					+ "WHERE adresseMail = '"
	    					+ client.getAdresseMail() 
	    					+ "'";
	    try{
		    this.stmt.executeUpdate(sql_delete);
		    System.out.println("Client '" + client.getAdresseMail() + "' supprime");
		} catch (SQLException e){
	    	System.out.println("Table Client non existant");
	    }
	}
	
	public Client getById(String id) {
		
		String sql_aff = "SELECT * FROM Client ";
		boolean notFound = true;
		Client client = null;
		
	    try {
	    	
	    	String adresseMail;
			ResultSet rs = this.stmt.executeQuery(sql_aff);
			
			while(rs.next() && notFound) {
				//Retrieve by column name
			       adresseMail  = rs.getString("adresseMail");
			       
			       if(adresseMail.equals(id)) {
			    	   String nom = rs.getString("nom");
				       String prenom = rs.getString("prenom");
				       String password = rs.getString("password");
				       
				       client = new Client( adresseMail, nom, prenom, password);
				       
				       notFound = false;
			       }		       
			}
			
			rs.close();
			
			if(notFound) {
				throw new SQLException();
			}
			
		} catch (SQLException e) {
			System.out.println("Impossible de trouver le client associe a l'adresse : " + id);
		}
	    
	    return client;
	}
	
	public ArrayList<Client> getAll() {
		
		String sql_aff = "SELECT * FROM Client ";
		ArrayList<Client> client = new ArrayList<Client>();
		
	    try {
	    	
	    	String adresseMail;
	    	String nom;
		    String prenom;
		    String password;
		    
			ResultSet rs = this.stmt.executeQuery(sql_aff);
			
			while(rs.next()) {
				
				//Retrieve by column name
		       adresseMail  = rs.getString("adresseMail");
		       nom = rs.getString("nom");
			   prenom = rs.getString("prenom");
			   password = rs.getString("password");
			       
			   client.add(new Client( adresseMail, nom, prenom, password));	       
			}
			
			rs.close();
		} catch (SQLException e) {
			System.out.println("Impossible de trouver d'elements dans la table");
		}
	    
	    return client;
	}
	
}
