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
	//retourne vrai quand une commande a ete ajoute avec succee 
	public boolean add(Commande commande) {
	    String sql_element = "INSERT INTO Commande " +
	            "VALUES ("+commande.getIdCommande()+", '"+commande.getDate()+"', "+commande.getPrixTotal()+", '"+commande.getClient().getAdresseMail()+"')";
	    try{
	    	stmt.executeUpdate(sql_element);
	    } catch (SQLException e){
	    	return false;
	    }
    	return true;
	}
	//retourne vrai quand une commande a ete supprime avec succee 
	public boolean delete(Commande commande){
	    String sql_delete = "DELETE FROM Commande " +
	            "WHERE idCommande = "+commande.getIdCommande()+"";
	    try{
	    	stmt.executeUpdate(sql_delete);
		} catch (SQLException e){
	    	return false;
	    }
    	return true;
	}
	//retourne la commande qui correspond a l'id entre en parametre 
	public Commande getById(int id){
		String sql_aff = "SELECT * FROM Commande " + "WHERE idCommande = " + id +"";
		Commande commande = null;
		boolean a;
		try{
			ResultSet rs = this.stmt.executeQuery(sql_aff);
			a = rs.next();
			if (a==false){
				return null; 
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
			return null;
		}
	    return commande;
	}
	
	// retourne dans une arrayList toutes les commandes
	public ArrayList<Commande> getAllById(String idClient) {
		String sql_aff = "SELECT * FROM Commande " + "WHERE adresseMail = '" + idClient +"'";
		ArrayList<Commande> commande = new ArrayList<Commande>();
		boolean a;
		try{
			ResultSet rs = this.stmt.executeQuery(sql_aff);
			a = rs.next();
			if (a==false){
				return new ArrayList<Commande>(); 
		    }
		    else {
		    	int id  = rs.getInt("idCommande");
			    String date = rs.getString("dates");
			    int prixTotal = rs.getInt("prixTotal");
			    String adresseMail = rs.getString("adresseMail");
			    ClientDAO tableClient = new ClientDAO(stmt);
			    Client client = tableClient.getById(adresseMail);
			    
			    commande.add(new Commande(id,date,prixTotal,client));
		    }		
			rs.close();
		} catch (SQLException e) {
			return null;
		}
	    return commande;
	}
	
	// retourne dans une arrayList toutes les commandes
	public ArrayList<Commande> getAll() {
		String sql_aff = "SELECT * FROM Commande ";
		ArrayList<Commande> commande = new ArrayList<Commande>();
	    try {
	    	ResultSet rs = this.stmt.executeQuery(sql_aff);
			while(rs.next()) {
		    	int id  = rs.getInt("idCommande");
			    String date = rs.getString("dates");
			    int prixTotal = rs.getInt("prixTotal");
			    
			    String adresseMail = rs.getString("adresseMail");
			    
			    /*ClientDAO tableClient = new ClientDAO(stmt);
				Client client = tableClient.getById(adresseMail);*/
			    
				commande.add(new Commande(id,date,prixTotal));
			}
			rs.close();
		} catch (SQLException e) {
			return null;
		}
	    return commande;
	}

	// affiche tout les elements de la table commande.Methode reservee a l'admin  
	public void affiche() throws SQLException{
		try{
			String sql_aff = "SELECT * FROM Commande ";
		    ResultSet rs = stmt.executeQuery(sql_aff);
		    boolean a=rs.next();
		    if (a==false){
		    	System.out.println("La table Commande est vide"); 
		    }
		    while(a){
		       int id  = rs.getInt("idCommande");
		       String date = rs.getString("dates");
		       int prixTotal = rs.getInt("prixTotal");
		       String adresseMail = rs.getString("adresseMail");
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
