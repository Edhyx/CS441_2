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
	
	public void add(Contient contient) throws SQLException{
	    String sql_element = "INSERT INTO Contient " +
	            "VALUES ("+contient.getNumOrdre()+", '"+contient.getTitre()+"', "+contient.getCommentaire()+
	            ", '"+contient.getFichierImages().getCheminAcces()+"', "+contient.getAlbum().getIdAlbum()+")";
	    try{
	    stmt.executeUpdate(sql_element);
	    System.out.println("Contient '"+ contient.getFichierImages().getCheminAcces() + "' et '" +contient.getAlbum().getIdAlbum() +"' cree");
	    } catch (SQLException e){
	    	System.out.println("Contient '"+ contient.getFichierImages().getCheminAcces() + "' et '" +contient.getAlbum().getIdAlbum() +"' existant");
	    }
	}
	
	//identifier le contient avec deux éléments
	public void delete(Contient contient) throws SQLException{
	    String sql_delete = "DELETE FROM Contient " +
	            "WHERE (idAlbum, cheminAcces) = ("+contient.getAlbum().getIdAlbum()+" , '"+contient.getFichierImages().getCheminAcces()+"'";
	    try{
	    stmt.executeUpdate(sql_delete);
	    System.out.println("Contient '"+ contient.getFichierImages().getCheminAcces() + "' et '" +contient.getAlbum().getIdAlbum() +"' supprime");
		} catch (SQLException e){
	    	System.out.println("Table Contient non existant");
	    }
	}
	
	//identifier le contient avec deux éléments
	public Contient getById(int id) throws SQLException{
		String sql_aff = "SELECT * FROM Contient " + "WHERE idCommande = " + id +"";
		Contient contient = null;
		boolean a;
		try{
			ResultSet rs = this.stmt.executeQuery(sql_aff);
			a = rs.next();
				//Retrieve by column name
			if (a==false){
		    	System.out.println("Impossible de trouver la commande : " + id); 
		    }
		    else {
			    int numOrdre  = rs.getInt("numOrdre");
			    String titre = rs.getString("titre");
			    String commentaire = rs.getString("commentaire");
			    String cheminAcces = rs.getString("cheminAcces");
			    int idAlbum = rs.getInt("idAlbum");
			    FichierImageDAO tableFichierImage = new FichierImageDAO(stmt);
			    FichierImage f = tableFichierImage.getById(cheminAcces);
			    AlbumDAO tableAlbum = new AlbumDAO(stmt);
			    Album album = tableAlbum.getById_L(idAlbum);
			    contient = new Contient(numOrdre,titre,commentaire,f,album);
		    }		
		rs.close();
		}
		catch (SQLException e) {
			System.out.println("Impossible de trouver le contient : " + id);
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
			    FichierImage f = tableFichierImage.getById(cheminAcces);
			    AlbumDAO tableAlbum = new AlbumDAO(stmt);
			    Album album = tableAlbum.getById_L(idAlbum);
			    contient.add(new Contient(numOrdre,titre,commentaire,f,album));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("Impossible de trouver d'elements dans la table");
		}
	    return contient;
	}

	
	public void affiche() throws SQLException{
		try{
		String sql_aff = "SELECT * FROM Contient ";
	    ResultSet rs = stmt.executeQuery(sql_aff);
	    
	    boolean a=rs.next();
	    if (a==false){
	    	System.out.println("La table Contient est vide"); 
	    }
	    while(a){
	       //Retrieve by column name
	       int numOrdre  = rs.getInt("numOrdre");
	       String titre = rs.getString("titre");
	       String commentaire = rs.getString("commentaire");
	       String cheminAcces = rs.getString("cheminAcces");
	       int idAlbum = rs.getInt("idAlbum");

	       //Display values
	       System.out.print("numOrdre: " + numOrdre);
	       System.out.print(", titre: " + titre);
	       System.out.print(", commentaire: " + commentaire);
	       System.out.print(", cheminAcces: " + cheminAcces);
	       System.out.println(", idAlbum: " + idAlbum);
	       a=rs.next();
	    }
	    rs.close();
		} catch (SQLException e){
	    	System.out.println("Table Contient non existante");
	    }
	}
}
