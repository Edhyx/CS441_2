package fr.esisar.cs441.groupe2.base.BDDs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.esisar.cs441.groupe2.base.entity.Album;
import fr.esisar.cs441.groupe2.base.entity.Contient;
import fr.esisar.cs441.groupe2.base.entity.FichierImage;

public class ContientDAO {
	private Statement stmt;

	public ContientDAO (Statement stmt) {
		super();
		this.stmt = stmt;
	}
	
	public boolean add(Contient contient) {
	    String sql_element = "INSERT INTO Contient " +
	            "VALUES ("+contient.getNumOrdre()+", '"+contient.getTitre()+"', '"+contient.getCommentaire()+
	            "', "+contient.getAlbum().getIdAlbum()+ ", '"+contient.getFichierImages().getCheminAcces()+"')";
	    try{
	    	stmt.executeUpdate(sql_element);
	    	return true;
	    } catch (SQLException e){
	    	return false;
	    }
	}
	
	//identifier le contient avec deux éléments
	public boolean delete(Contient contient){
	    String sql_delete = "DELETE FROM Contient " +
	            "WHERE idAlbum = "+contient.getAlbum().getIdAlbum()+" and cheminAcces = '"+contient.getFichierImages().getCheminAcces()+"'";
	    try{
	    	stmt.executeUpdate(sql_delete);
	    	return true;
	    } catch (SQLException e){
	    	return false;
	    }
	}
	
	public Contient getById(int idAlbum, String cheminAcces){
		String sql_aff = "SELECT * FROM Contient " +
				"WHERE idAlbum = "+idAlbum+" and cheminAcces = '"+cheminAcces+"'";
		Contient contient = null;
		boolean a;
		try{
			ResultSet rs = this.stmt.executeQuery(sql_aff);
			a = rs.next();
			if (a==false){
				return null;
		    }
		    else {
			    int numOrdre  = rs.getInt("numOrdre");
			    String titre = rs.getString("titre");
			    String commentaire = rs.getString("commentaire");
			    cheminAcces = rs.getString("cheminAcces");
			    idAlbum = rs.getInt("idAlbum");
			    FichierImageDAO tableFichierImage = new FichierImageDAO(stmt);
			    FichierImage f = tableFichierImage.getById(cheminAcces);
			    AlbumDAO tableAlbum = new AlbumDAO(stmt);
			    Album album = tableAlbum.getById(idAlbum);
			    
			    contient = new Contient(numOrdre,titre,commentaire,f,album);
		    }		
			rs.close();
		}
		catch (SQLException e) {
			return null;
		}
	    return contient;
	}
	
	public ArrayList<Contient> getAll() {
		String sql_aff = "SELECT * FROM Contient ";
		ArrayList<Contient> contient = new ArrayList<Contient>();
	    try {
	    	ResultSet rs = this.stmt.executeQuery(sql_aff);
			while(rs.next()) {
				int numOrdre  = rs.getInt("numOrdre");
			    String titre = rs.getString("titre");
			    String commentaire = rs.getString("commentaire");
			    String cheminAcces = rs.getString("cheminAcces");
			    int idAlbum = rs.getInt("idAlbum");
			    
			    FichierImageDAO tableFichierImage = new FichierImageDAO(stmt);
			    FichierImage fichier = tableFichierImage.getById(cheminAcces);
			    AlbumDAO tableAlbum = new AlbumDAO(stmt);
			    Album album = tableAlbum.getById(idAlbum);
			   
			    contient.add(new Contient(numOrdre,titre,commentaire, fichier, album)); 
			}
			rs.close();
			return contient;
		} catch (SQLException e) {
			return null;
		}
	}

	
	public void affiche(){
		try{
			String sql_aff = "SELECT * FROM Contient ";
		    ResultSet rs = stmt.executeQuery(sql_aff);
		    boolean a=rs.next();
		    if (a==false){
		    	System.out.println("La table Contient est vide"); 
		    }
		    while(a){
		       int numOrdre  = rs.getInt("numOrdre");
		       String titre = rs.getString("titre");
		       String commentaire = rs.getString("commentaire");
		       String cheminAcces = rs.getString("cheminAcces");
		       int idAlbum = rs.getInt("idAlbum");
		       System.out.print("numOrdre: " + numOrdre);
		       System.out.print(", titre: " + titre);
		       System.out.print(", commentaire: " + commentaire);
		       System.out.print(", idAlbum: " + idAlbum);
		       System.out.println(", cheminAcces: " + cheminAcces);
		       a=rs.next();
		    }
		    rs.close();
		} catch (SQLException e){
	    	System.out.println("Table Contient non existante");
	    }
	}
}
