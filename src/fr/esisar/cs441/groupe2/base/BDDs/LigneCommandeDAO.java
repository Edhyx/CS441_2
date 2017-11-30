package fr.esisar.cs441.groupe2.base.BDDs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.esisar.cs441.groupe2.base.entity.Adresse;
import fr.esisar.cs441.groupe2.base.entity.Client;
import fr.esisar.cs441.groupe2.base.entity.Format;

import fr.esisar.cs441.groupe2.base.entity.Adresse;
import fr.esisar.cs441.groupe2.base.entity.LigneCommande;
import fr.esisar.cs441.groupe2.base.entity.Commande;


public class LigneCommandeDAO {
	private Statement stmt;

	public LigneCommandeDAO (Statement stmt) {
		super();
		this.stmt = stmt;
	}

	public void add(LigneCommande ligneCommande) throws SQLException{
	    String sql_element = "INSERT INTO LigneCommande " +
	            "VALUES ("+ligneCommande.getQuantite()+", "+ligneCommande.getCommande().getIdCommande()+", "+ligneCommande.getFormat().getIdFormat()+", "+ligneCommande.getAlbum().getIdAlbum()+")";
	    try{
	    stmt.executeUpdate(sql_element);
	    System.out.println("LigneCommande qui correspond a l'idCommande '"+ligneCommande.getCommande().getIdCommande()+"' cree");
	    } catch (SQLException e){
	    	System.out.println("LigneCommande qui correspond a l'idCommande '"+ligneCommande.getCommande().getIdCommande()+"' existant");
	    }
	}
	
	public void delete(LigneCommande ligneCommande) throws SQLException{
	    String sql_delete = "DELETE FROM LigneCommande " +
	            "WHERE idCommande = "+ligneCommande.getCommande().getIdCommande()+"";
	    try{
	    stmt.executeUpdate(sql_delete);
	    System.out.println("LigneCommande qui correspond a l'idCommande '"+ligneCommande.getCommande().getIdCommande()+"' supprime");
		} catch (SQLException e){
	    	System.out.println("Table  LigneCommande non existant");
	    }
	}
	
	public LigneCommande getById(int id) throws SQLException{
		String sql_aff = "SELECT * FROM LigneCommande " + "WHERE idCommande = " + id +"";
		LigneCommande adL = null;
		boolean a;
		try{
			ResultSet rs = this.stmt.executeQuery(sql_aff);
			a = rs.next();
				//Retrieve by column name
			if (a==false){
		    	System.out.println("Impossible de trouver le LigneCommande pour l'idCommande : " + id); 
		    }
		    else {
		    	id  = rs.getInt("idCommande");
		    	int quantite = rs.getInt("quantite");
				int idFormat = rs.getInt("idFormat");
				int idAlbum = rs.getInt("idAlbum");
				CommandeDAO tableCommande = new CommandeDAO(stmt);
				Commande cmd = tableCommande.getById(id);
				FormatDAO tableFormat = new FormatDAO(stmt);
				Format frm = tableFormat.getById(idFormat);
				AlbumDAO tableAlbum = new AlbumDAO(stmt);
				Album alb = tableAlbum.getById(idAlbum);
				
				adL = new LigneCommande(quantite,cmd,frm,alb);
		    }		
		rs.close();
		}
		catch (SQLException e) {
			System.out.println("Impossible de trouver le LigneCommande de idCommande : " + id);
		}
	    return adL;
	}
	
public ArrayList<LigneCommande> getAll() {
		String sql_aff = "SELECT * FROM LigneCommande ";
		ArrayList<LigneCommande> adF = new ArrayList<LigneCommande>();
	    try {
	    	ResultSet rs = this.stmt.executeQuery(sql_aff);
			while(rs.next()) {
				
				//Retrieve by column name
			
		    	int idCommande  = rs.getInt("idCommande");
		    	int quantite = rs.getInt("quantite");
				int idFormat = rs.getInt("idFormat");
				int idAlbum = rs.getInt("idAlbum");
				CommandeDAO tableCommande = new CommandeDAO(stmt);
				Commande cmd = tableCommande.getById(id);
				FormatDAO tableFormat = new FormatDAO(stmt);
				Format frm = tableFormat.getById(idFormat);
				AlbumDAO tableAlbum = new AlbumDAO(stmt);
				Album alb = tableAlbum.getById(idAlbum);
				
			    adF.add(new LigneCommande(quantite,cmd,frm,alb));	       
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("Impossible de trouver d'elements dans la table");
		}
	    return adF;
	}


public void affiche() throws SQLException{
	try{
	String sql_aff = "SELECT quantite, idCommande, idFormat, idAlbum FROM LigneCommande ";
    ResultSet rs = stmt.executeQuery(sql_aff);
    
    boolean a=rs.next();
    if (a==false){
    	System.out.println("La table LigneCommande est vide"); 
    }
    while(a){
    	//Retrieve by column name
    	int id  = rs.getInt("idCommande");
    	int quantite = rs.getInt("quantite");
		int idFormat = rs.getInt("idFormat");
		int idAlbum = rs.getInt("idAlbum");
	    //Display values
	    System.out.print("quantite: " + quantite);
	    System.out.print(", idCommande: " + id);
	    System.out.print(", idFormat: " + idFormat);
	    System.out.print(", idAlbum: " + idAlbum);

	    a=rs.next();
    }
    rs.close();
	} catch (SQLException e){
    	System.out.println("Table LigneCommande non existante");
    }
}
}