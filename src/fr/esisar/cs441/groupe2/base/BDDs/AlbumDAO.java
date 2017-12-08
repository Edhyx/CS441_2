package fr.esisar.cs441.groupe2.base.BDDs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.esisar.cs441.groupe2.base.entity.Album;
import fr.esisar.cs441.groupe2.base.entity.Client;

public class AlbumDAO {
	private Statement stmt;

	public AlbumDAO (Statement stmt) {
		super();
		this.stmt = stmt;
	}
	
	//retourne vrai quand un album a ete ajoute avec succee 
	public boolean add(Album album) {
	    String sql_element = "INSERT INTO Album " +
	            "VALUES ("+album.getIdAlbum()+", '"+album.getTitre()+"', '"+album.getSousTitre()+"', '"+album.getCreeParClient().getAdresseMail()+"')";
	    try{
	    	stmt.executeUpdate(sql_element);
	    } catch (SQLException e){
	    	return false;
	    }
	    return true;
	}
	
	//retourne vrai quand un album a ete supprime avec succee 
	public boolean delete(Album album) {
	    String sql_delete = "DELETE FROM Album " +
	            "WHERE idAlbum = "+album.getIdAlbum()+"";
	    try{
	    	stmt.executeUpdate(sql_delete);
	    	
		} catch (SQLException e){
	    	return false;
	    }
	    return true;
	}
	
	//retourne l'album qui correspond a l'id entre en parametre 
	public Album getById(int id) {
		String sql_aff = "SELECT * FROM Album " + "WHERE idAlbum = " + id +"";
		Album album = null;
		boolean a;
		try{
			ResultSet rs = this.stmt.executeQuery(sql_aff);
			a = rs.next();
			if (a==false){
		    	return null;
		    }
		    else {
		    	id  = rs.getInt("idAlbum");
			    String titre = rs.getString("titre");
			    String sousTitre = rs.getString("sousTitre");
			    String adresseMail = rs.getString("adresseMail");
			    ClientDAO tableClient = new ClientDAO(stmt);
				Client client = tableClient.getById(adresseMail);
			    
				album = new Album(id,titre,sousTitre,client);
			}		
			rs.close();
		}
		catch (SQLException e) {
			return null;
		}
	    return album;
	}
	
	// retourne dans une arrayList tous les albums
	public ArrayList<Album> getAll() {
		String sql_aff = "SELECT * FROM Album ";
		ArrayList<Album> album = new ArrayList<Album>();
	    try {
	    	ResultSet rs = this.stmt.executeQuery(sql_aff);
			while(rs.next()) {
				int id  = rs.getInt("idAlbum");
			    String titre = rs.getString("titre");
			    String sousTitre = rs.getString("sousTitre");
			    
				album.add(new Album(id,titre,sousTitre));
			}
			rs.close();
		} catch (SQLException e) {
			return null;
		}
	    return album;
	}
	
	// retourne dans une arrayList tous les albums
	public ArrayList<Album> getAllById(String idClient) {
		String sql_aff = "SELECT * FROM Album " + "WHERE adresseMail = '" + idClient +"'";
		ArrayList<Album> album = new ArrayList<Album>();
		try{
			ResultSet rs = this.stmt.executeQuery(sql_aff);
			while(rs.next()) {
				int id  = rs.getInt("idAlbum");
			    String titre = rs.getString("titre");
			    String sousTitre = rs.getString("sousTitre");
			    
				album.add(new Album(id,titre,sousTitre));
			}		
			rs.close();
		} catch (SQLException e) {
			return null;
		}
	    return album;
	}
	
	// affiche tout les elements de la table album.Methode reservee a l'admin 
	public void affiche(){
		try{
			String sql_aff = "SELECT * FROM Album ";
		    ResultSet rs = stmt.executeQuery(sql_aff);
		    boolean a=rs.next();
		    if (a==false){
		    	System.out.println("La table Album est vide"); 
		    }
		    while(a){
		       String id  = rs.getString("idAlbum");
		       String titre = rs.getString("titre");
		       String sousTitre = rs.getString("sousTitre");
		       String adresseMail = rs.getString("adresseMail");
		       System.out.print("idAlbum: " + id);
		       System.out.print(", titre: " + titre);
		       System.out.print(", sousTitre: " + sousTitre);
		       System.out.println(", adresseMail: " + adresseMail);
		       a=rs.next();
		    }
		    rs.close();
		} catch (SQLException e){
	    	System.out.println("Table Album non existante");
	    }
	}
}
