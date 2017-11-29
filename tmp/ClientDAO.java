

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.esisar.cs441.groupe2.base.entity.Adresse;
import fr.esisar.cs441.groupe2.base.entity.Client;

public class ClientDAO {
	
	private Statement stmt;

	public ClientDAO(Statement stmt) {
		super();
		this.stmt = stmt;
	}
	
	public void add(Client client) throws SQLException {
		
		// elements de base
		
	    String sql_element = "INSERT INTO Client " + 
	    		 "VALUES ('"+client.getAdresseMail()+"', '"+client.getNom()+"', '"+client.getPrenom()+"','"+client.getPassword()+"', null, null)";
			

	    
	   
		    this.stmt.executeUpdate(sql_element);
		    System.out.println("Client '" + client.getAdresseMail() + "' cree");
	   
	    	//System.out.println("Client '" + client.getAdresseMail() + "' existant");
	    
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
	
	public Client getById(String id) throws SQLException {
		
		String sql_find = "SELECT * FROM Client " 
						  + "WHERE adresseMail = '"
				          + id
				          + "'";
		ResultSet rss = this.stmt.executeQuery(sql_find);

		//boolean notFound = true;
		Client client = null;
		boolean a;
	   // try {
			
			while(a=rss.next()) {
				 if (a==false){
				    	System.out.println("Impossible de trouver le client associe a l'adresse : " + id); 
				    }
				 else {
				//Retrieve by column name
			         id  = rss.getString("adresseMail");
			    	String nom = rss.getString("nom");
				    String prenom = rss.getString("prenom");
				    String password = rss.getString("password");
				    //int idAdresseF = rss.getInt("idAdresseF");
				    //int idAdresseL = rss.getInt("idAdresseL");
				    //optionnel   
				    System.out.print("adresseMail: " + id);
				    System.out.print(", nom: " + nom);
				    System.out.print(", prenom: " + prenom);
				    System.out.println(", password: " + password);
				    //client = new Client( id, nom, prenom, password);
				    client = new Client( id, nom, prenom, password,null,null);
				     
				   // notFound = false;
			     }	}	       
					
			rss.close();
			
			/*if(notFound) {
				throw new SQLException();
			}*/
			
		//} catch (SQLException e) {
		//	System.out.println("Impossible de trouver le client associe a l'adresse : " + id);
		//}
	   
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
