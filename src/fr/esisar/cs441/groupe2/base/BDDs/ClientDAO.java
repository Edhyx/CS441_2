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
	
	//retourne vrai quand un client a ete ajoute avec succee 
	public boolean add(Client client){
	    String sql_element = "INSERT INTO Client " +
	            "VALUES ('"+client.getAdresseMail()+"', '"+client.getNom()+"', '"+client.getPrenom()+"', '"+client.getPassword()+"', "+client.getAdresseDeFacturation().getIdAdresse()+", "+client.getAdresseDeLivraison().getIdAdresse()+")";
	    try{
	    	stmt.executeUpdate(sql_element);
	    } catch (SQLException e){
	    	return false;
	    }
	    return true;
	}
	
	//retourne vrai quand un client a ete supprime avec succee 
	public boolean delete(Client client) {
	    String sql_delete = "DELETE FROM Client " 
	    					+ "WHERE adresseMail = '"
	    					+ client.getAdresseMail() 
	    					+ "'";
	    try{
		    this.stmt.executeUpdate(sql_delete);
		} catch (SQLException e){
	    	return false;
	    }
    	return true;
	}
	
	//retourne le client qui correspond a l'id (mail) entre en parametre 
	public Client getById(String id) {		
		String sql_aff = "SELECT * FROM Client " + "WHERE adresseMail = '" + id +"'";
		Client client = null;
	    boolean a;
		try{
		    ResultSet rs = stmt.executeQuery(sql_aff);
		    a = rs.next();
			if (a==false){
				return null; 
			}
			else {
				id = rs.getString("adresseMail");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String password = rs.getString("password");
				int idAdresseF = rs.getInt("idAdresseF");
				int idAdresseL = rs.getInt("idAdresseL");
				AdresseDAO tableAdresse = new AdresseDAO(stmt);
				Adresse adF = tableAdresse.getById_F(idAdresseF);
				Adresse adL = tableAdresse.getById_L(idAdresseL);

				client = new Client(id, nom, prenom, password,adF,adL);
			}
			rs.close();
		}
		catch (SQLException e) {
			return null;
		}
	    return client;
	}
	
	// retourne dans une arrayList tous les clients
	public ArrayList<Client> getAll() {
		String sql_aff = "SELECT * FROM Client ";
		ArrayList<Client> client = new ArrayList<Client>();
	    try {
	    	ResultSet rs = this.stmt.executeQuery(sql_aff);
			while(rs.next()) {
				String adresseMail  = rs.getString("adresseMail");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String password = rs.getString("password");
				
			    client.add(new Client(adresseMail, nom, prenom, password));	       
			}
			rs.close();
		} catch (SQLException e) {
			return null;
		}
	    return client;
	}
	
	// affiche tout les elements de la table client.Methode reservee a l'admin 
	public void affiche(){
		String sql_aff = "SELECT * FROM Client ";
		try{
		    ResultSet rs = stmt.executeQuery(sql_aff);
		    boolean a=rs.next();
		    if (a==false){
		    	System.out.println("La table Client est vide"); 
		    }
		    while(a){
			    String id  = rs.getString("adresseMail");
			    String nom = rs.getString("nom");
			    String prenom = rs.getString("prenom");
			    String password = rs.getString("password");
			    String idAdresseF = rs.getString("idAdresseF");
			    String idAdresseL = rs.getString("idAdresseL");
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
