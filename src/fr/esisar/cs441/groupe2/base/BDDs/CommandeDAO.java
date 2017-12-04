package fr.esisar.cs441.groupe2.base.BDDs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.esisar.cs441.groupe2.base.entity.Client;
import fr.esisar.cs441.groupe2.base.entity.Commande;

public class CommandeDAO {
	private Statement stmt;

	public CommandeDAO (Statement stmt) {
		super();
		this.stmt = stmt;
	}
	
	public void add(Commande commande) throws SQLException{
	    String sql_element = "INSERT INTO Commande " +
	            "VALUES ("+commande.getIdCommande()+", '"+commande.getDate()+"', "+commande.getPrixTotal()+", '"+commande.getClient().getAdresseMail()+"')";
	    try{
	    stmt.executeUpdate(sql_element);
	    System.out.println("Commande '"+commande.getIdCommande()+"' cree");
	    } catch (SQLException e){
	    	System.out.println("Commande '"+commande.getIdCommande()+"' existant");
	    }
	}
	
	public void delete(Commande commande) throws SQLException{
	    String sql_delete = "DELETE FROM Commande " +
	            "WHERE idCommande = "+commande.getIdCommande()+"";
	    try{
	    stmt.executeUpdate(sql_delete);
	    System.out.println("Commande '"+commande.getIdCommande()+"' supprime");
		} catch (SQLException e){
	    	System.out.println("Table Commande non existant");
	    }
	}
	
	public Commande getById(int id) throws SQLException{
		String sql_aff = "SELECT * FROM Commande " + "WHERE idCommande = " + id +"";
		Commande commande = null;
		boolean a;
		try{
			ResultSet rs = this.stmt.executeQuery(sql_aff);
			a = rs.next();
				//Retrieve by column name
			if (a==false){
		    	System.out.println("Impossible de trouver la commande : " + id); 
		    }
		    else {
		    	id  = rs.getInt("idCommande");
			    String date = rs.getString("dates");
			    int prixTotal = rs.getInt("prixTotal");
			    String adresseMail = rs.getString("adresseMail");
			    ClientDAO tableClient = new ClientDAO(stmt);
			    Client client = tableClient.getById(adresseMail);
			    
				commande = new Commande(id,date,prixTotal,client);
		    }		
		rs.close();
		}
		catch (SQLException e) {
			System.out.println("Impossible de trouver la commande : " + id);
		}
	    return commande;
	}
	
	public ArrayList<Commande> getAll() {
		String sql_aff = "SELECT * FROM Commande ";
		ArrayList<Commande> commande = new ArrayList<Commande>();
	    try {
	    	ResultSet rs = this.stmt.executeQuery(sql_aff);
			while(rs.next()) {
		    	int id  = rs.getInt("idCommande");
			    String date = rs.getString("dates");
			    int prixTotal = rs.getInt("prixTotal");
			    /*
			    String adresseMail = rs.getString("adresseMail");
			    ClientDAO tableClient = new ClientDAO(stmt);
			    Client client = tableClient.getById(adresseMail);
			    */
			    
				commande.add(new Commande(id,date,prixTotal));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("Impossible de trouver d'elements dans la table");
		}
	    return commande;
	}

	
	public void affiche() throws SQLException{
		try{
		String sql_aff = "SELECT * FROM Commande ";
	    ResultSet rs = stmt.executeQuery(sql_aff);
	    
	    boolean a=rs.next();
	    if (a==false){
	    	System.out.println("La table Commande est vide"); 
	    }
	    while(a){
	       //Retrieve by column name
	       int id  = rs.getInt("idCommande");
	       String date = rs.getString("dates");
	       int prixTotal = rs.getInt("prixTotal");
	       String adresseMail = rs.getString("adresseMail");
	       //Display values
	       System.out.print("idCommande: " + id);
	       System.out.print(", date: " + date);
	       System.out.print(", prixTotal: " + prixTotal);
	       System.out.println(", adresseMail: " + adresseMail);
	       a=rs.next();
	    }
	    rs.close();
		} catch (SQLException e){
	    	System.out.println("Table Commande non existante");
	    }
	}

}
