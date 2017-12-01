package fr.esisar.cs441.groupe2.base.BDDs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.esisar.cs441.groupe2.base.entity.Client;
import fr.esisar.cs441.groupe2.base.entity.FichierImage;

public class FichierImageDAO {
	private Statement stmt;

	public FichierImageDAO (Statement stmt) {
		super();
		this.stmt = stmt;
	}
	
	public void add(FichierImage f) throws SQLException{
	    String sql_element = "INSERT INTO FichierImage " +
	            "VALUES ('"+f.getCheminAcces()+"', '"+f.getAppareilPhoto()+"', '"+f.getObjectif()+"', "+f.getDistanceFocale()+", "+f.getSensibiliteISO()+
	            			", "+f.getOuverture()+", "+f.getVitesseObturation()+", '"+f.getClient().getAdresseMail()+"')";
	    try{
	    stmt.executeUpdate(sql_element);
	    System.out.println("FichierImage '"+f.getCheminAcces()+"' cree");
	    } catch (SQLException e){
	    	System.out.println("FichierImage '"+f.getCheminAcces()+"' existant");
	    }
	}
	
	public void delete(FichierImage f) throws SQLException{
	    String sql_delete = "DELETE FROM FichierImage " +
	            "WHERE cheminAcces = '"+f.getCheminAcces()+"'";
	    try{
	    stmt.executeUpdate(sql_delete);
	    System.out.println("FichierImage '"+f.getCheminAcces()+"' supprime");
		} catch (SQLException e){
	    	System.out.println("Table FichierImage non existant");
	    }
	}
	
	public FichierImage getById(String id) throws SQLException{
		String sql_aff = "SELECT * FROM FichierImage " + "WHERE cheminAcces = '" + id +"'";
		FichierImage f = null;
		boolean a;
		try{
			ResultSet rs = this.stmt.executeQuery(sql_aff);
			a = rs.next();
				//Retrieve by column name
			if (a==false){
		    	System.out.println("Impossible de trouver le fichier image : " + id); 
		    }
		    else{
		    	id  = rs.getString("cheminAcces");
			    String appareilPhoto = rs.getString("appareilPhoto");
			    String objectif = rs.getString("objectif");
			    int distanceFocale = rs.getInt("distanceFocale");
			    int sensibiliteISO = rs.getInt("sensibiliteISO");
			    int ouverture = rs.getInt("ouverture");
			    int vitesseObturation = rs.getInt("vitesseObturation");
			    String adresseMail = rs.getString("adresseMail");
			    ClientDAO tableClient = new ClientDAO(stmt);
			    Client client = tableClient.getById(adresseMail);
			    
				f = new FichierImage(id,appareilPhoto,objectif,distanceFocale,sensibiliteISO,ouverture,vitesseObturation,client);
		    }		
		rs.close();
		}
		catch (SQLException e) {
			System.out.println("Impossible de trouver l'adresseL : " + id);
		}
	    return f;
	}
	
	public ArrayList<FichierImage> getAll() {
		String sql_aff = "SELECT * FROM FichierImage ";
		ArrayList<FichierImage> f = new ArrayList<FichierImage>();
	    try {
	    	ResultSet rs = this.stmt.executeQuery(sql_aff);
			while(rs.next()) {
				String id  = rs.getString("cheminAcces");
			    String appareilPhoto = rs.getString("appareilPhoto");
			    String objectif = rs.getString("objectif");
			    int distanceFocale = rs.getInt("distanceFocale");
			    int sensibiliteISO = rs.getInt("sensibiliteISO");
			    int ouverture = rs.getInt("ouverture");
			    int vitesseObturation = rs.getInt("vitesseObturation");
			    /*
			    String adresseMail = rs.getString("adresseMail");
			    ClientDAO tableClient = new ClientDAO(stmt);
			    Client client = tableClient.getById(adresseMail);
			    */
			    
				f.add(new FichierImage(id,appareilPhoto,objectif,distanceFocale,sensibiliteISO,ouverture,vitesseObturation,null));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("Impossible de trouver d'elements dans la table");
		}
	    return f;
	}
	
	public void affiche() throws SQLException{
		try{
		String sql_aff = "SELECT * FROM FichierImage ";
	    ResultSet rs = stmt.executeQuery(sql_aff);
	    
	    boolean a=rs.next();
	    if (a==false){
	    	System.out.println("La table FichierImage est vide"); 
	    }
	    while(a){
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
	       System.out.print(", distanceFocale: " + distanceFocale);
	       System.out.print(", sensibiliteISO: " + sensibiliteISO);
	       System.out.print(", ouverture: " + ouverture);
	       System.out.print(", vitesseObturation: " + vitesseObturation);
	       System.out.println(", adresseMail: " + adresseMail);
	       a=rs.next();
	    }
	    rs.close();
		} catch (SQLException e){
	    	System.out.println("Table FichierImage non existante");
	    }
	}
}
