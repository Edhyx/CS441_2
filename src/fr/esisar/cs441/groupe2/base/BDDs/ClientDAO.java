package fr.esisar.cs441.groupe2.base.BDDs;

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
	
	public void add(Client client) throws SQLException{
	    String sql_element = "INSERT INTO Client " +
	            "VALUES ('"+client.getAdresseMail()+"', '"+client.getNom()+"', '"+client.getPrenom()+"', '"+client.getPassword()+"', "+client.getAdresseDeFacturation().getIdAdresse()+", "+client.getAdresseDeLivraison().getIdAdresse()+")";
	    try{
	    stmt.executeUpdate(sql_element);
	    System.out.println("Client '"+client.getAdresseMail()+"' cree");
	    } catch (SQLException e){
	    	System.out.println("Client '"+client.getAdresseMail()+"' existant");
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
		Client client = null;
		try{
		    ResultSet rs = stmt.executeQuery(sql_aff);
		    
		    boolean a=rs.next();
		    if (a==false){
		    	System.out.println("La table Client est vide"); 
		    }
		    while(a){
		    	
		    	//Retrieve by column name
			    String adresseMail  = rs.getString("adresseMail");
				if (adresseMail.equals(id)) {
					String nom = rs.getString("nom");
				    String prenom = rs.getString("prenom");
				    String password = rs.getString("password");
				    int idAdresseF = rs.getInt("idAdresseF");
				    int idAdresseL = rs.getInt("idAdresseL");
				    AdresseDAO tableAdresse = new AdresseDAO(stmt);
				    Adresse adF = tableAdresse.getById_F(idAdresseF);
				    Adresse adL = tableAdresse.getById_L(idAdresseL);

				    client = new Client(adresseMail, nom, prenom, password,adF,adL);
				    break;
				}
				a=rs.next();
		    }
			rs.close();			
		} catch (SQLException e) {
			System.out.println("Impossible de trouver le client associe a l'adresse : " + id +e);
		}
	    return client;
	}
	
	public ArrayList<Client> getAll() {
		
		String sql_aff = "SELECT * FROM Client ";
		ArrayList<Client> client = new ArrayList<Client>();
		
	    try {
	    	ResultSet rs = this.stmt.executeQuery(sql_aff);
			while(rs.next()) {
				//Retrieve by column name
				String adresseMail  = rs.getString("adresseMail");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String password = rs.getString("password");
			    int idAdresseF = rs.getInt("idAdresseF");
			    int idAdresseL = rs.getInt("idAdresseL");
			    AdresseDAO tableAdresse = new AdresseDAO(stmt);
			    Adresse adF = tableAdresse.getById_F(idAdresseF);
			    Adresse adL = tableAdresse.getById_L(idAdresseL);
			    
			    client.add(new Client(adresseMail, nom, prenom, password,adF,adL));	       
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("Impossible de trouver d'elements dans la table");
		}
	    
	    return client;
	}
	
	public void affiche() throws SQLException{
		String sql_aff = "SELECT * FROM Client ";
		try{
	    ResultSet rs = stmt.executeQuery(sql_aff);
	    
	    boolean a=rs.next();
	    if (a==false){
	    	System.out.println("La table Client est vide"); 
	    }
	    while(a){
	    	
	    	//Retrieve by column name
		    String id  = rs.getString("adresseMail");
		    String nom = rs.getString("nom");
		    String prenom = rs.getString("prenom");
		    String password = rs.getString("password");
		    String idAdresseF = rs.getString("idAdresseF");
		    String idAdresseL = rs.getString("idAdresseL");
	        //Display values
	        System.out.print("adresseMail: " + id);
		    System.out.print(", nom: " + nom);
	        System.out.print(", prenom: " + prenom);
	        System.out.print(", password: " + password);
	        System.out.print(", idAdresseF: " + idAdresseF);
	        System.out.println(", idAdresseL: " + idAdresseL);
	        a=rs.next();
	    }
	    rs.close();
		} catch (SQLException e){
	    	System.out.println("Table Client non existante");
	    }
	}
}
