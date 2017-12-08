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
	
	//retourne vrai quand un fichier image a ete ajoute avec succee 
	public boolean add(FichierImage f) {
	    String sql_element = "INSERT INTO FichierImage " +
	            "VALUES ('"+f.getCheminAcces()+"', '"+f.getAppareilPhoto()+"', '"+f.getObjectif()+"', "+f.getDistanceFocale()+", "+f.getSensibiliteISO()+
	            			", "+f.getOuverture()+", "+f.getVitesseObturation()+", '"+f.getClient().getAdresseMail()+"')";
	    try{	    	
	    	stmt.executeUpdate(sql_element);
	    } catch (SQLException e){
	    	return false;
	    }
    	return true;
	}
	
	//retourne vrai quand un fichier image a ete supprime avec succee 
	public boolean delete(FichierImage f) {
	    String sql_delete = "DELETE FROM FichierImage " +
	            "WHERE cheminAcces = '"+f.getCheminAcces()+"'";
	    try{
		    stmt.executeUpdate(sql_delete);
		} catch (SQLException e){
	    	return false;
	    }
    	return true;
	}
	
	//retourne le fichier image qui correspond au chemin d'acces entre en parametre 
	public FichierImage getById(String id) {
		String sql_aff = "SELECT * FROM FichierImage " + "WHERE cheminAcces = '" + id +"'";
		FichierImage f = null;
		boolean a;
		try{
			ResultSet rs = this.stmt.executeQuery(sql_aff);
			a = rs.next();
			if (a==false){
				return null;
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
		    return f;
		}
		catch (SQLException e) {
			return null;
		}
	}
	
	// retourne dans une arrayList tous les fichiers images 
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
			    
				f.add(new FichierImage(id,appareilPhoto,objectif,distanceFocale,sensibiliteISO,ouverture,vitesseObturation));
			}
			rs.close();
		} catch (SQLException e) {
			return null;
		}
	    return f;
	}
	
	// affiche tout les elements de la table FichierImage.Methode reservee a l'admin 
	public void affiche() {
		try{
			String sql_aff = "SELECT * FROM FichierImage ";
		    ResultSet rs = stmt.executeQuery(sql_aff);
		    boolean a=rs.next();
		    if (a==false){
		    	System.out.println("La table FichierImage est vide"); 
		    }
		    while(a){
		       String id  = rs.getString("cheminAcces");
		       String appareilPhoto = rs.getString("appareilPhoto");
		       String objectif = rs.getString("objectif");
		       int distanceFocale = rs.getInt("distanceFocale");
		       int sensibiliteISO = rs.getInt("sensibiliteISO");
		       int ouverture = rs.getInt("ouverture");
		       int vitesseObturation = rs.getInt("vitesseObturation");
		       String adresseMail = rs.getString("adresseMail");
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
