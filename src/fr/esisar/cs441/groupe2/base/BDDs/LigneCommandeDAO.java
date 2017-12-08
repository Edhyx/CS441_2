package fr.esisar.cs441.groupe2.base.BDDs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.esisar.cs441.groupe2.base.entity.Album;
import fr.esisar.cs441.groupe2.base.entity.Format;
import fr.esisar.cs441.groupe2.base.entity.LigneCommande;
import fr.esisar.cs441.groupe2.base.entity.Commande;


public class LigneCommandeDAO {
	private Statement stmt;

	public LigneCommandeDAO (Statement stmt) {
		super();
		this.stmt = stmt;
	}
	//retourne vrai quand une ligne de commande a ete ajoute avec succee 
	public boolean add(LigneCommande ligneCommande) {
	    String sql_element = "INSERT INTO LigneCommande " +
	            "VALUES ("+ligneCommande.getQuantite()+", "+ligneCommande.getCommande().getIdCommande()+", "+ligneCommande.getFormat().getIdFormat()+", "+ligneCommande.getAlbum().getIdAlbum()+")";
	    try{
	    	stmt.executeUpdate(sql_element);
	    	return true;
	    } catch (SQLException e){
	    	return false;
	    }
	}
	//retourne vrai quand une ligne de commande a ete supprime avec succee 
	public boolean delete(LigneCommande ligneCommande) {
	    String sql_delete = "DELETE FROM LigneCommande " +
	            "WHERE idCommande = "+ligneCommande.getCommande().getIdCommande()+"";
	    try{
	    	stmt.executeUpdate(sql_delete);
	    	return true;
		} catch (SQLException e){
			return false;
	    }
	}
	//retourne la ligne de commande qui correspond a l'id de la commande entre en parametre 
	public LigneCommande getById(int idCommande) {
		String sql_aff = "SELECT * FROM LigneCommande " + "WHERE idCommande = " + idCommande +"";
		LigneCommande adL = null;
		boolean a;
		try{
			ResultSet rs = this.stmt.executeQuery(sql_aff);
			a = rs.next();
			if (a==false){
				return null;
		    }
		    else {
		    	idCommande  = rs.getInt("idCommande");
		    	int quantite = rs.getInt("quantite");
				int idFormat = rs.getInt("idFormat");
				int idAlbum = rs.getInt("idAlbum");
				CommandeDAO tableCommande = new CommandeDAO(stmt);
				Commande cmd = tableCommande.getById(idCommande);
				FormatDAO tableFormat = new FormatDAO(stmt);
				Format frm = tableFormat.getById(idFormat);
				AlbumDAO tableAlbum = new AlbumDAO(stmt);
				Album alb = tableAlbum.getById(idAlbum);
				
				adL = new LigneCommande(quantite,cmd,frm,alb);
		    }		
			rs.close();
		}
		catch (SQLException e) {
			return null;
		}
	return adL;
	}
	// retourne dans une arrayList toutes les lignes de commandes
	public ArrayList<LigneCommande> getAll() {
		String sql_aff = "SELECT * FROM LigneCommande ";
		ArrayList<LigneCommande> adF = new ArrayList<LigneCommande>();
	    try {
	    	ResultSet rs = this.stmt.executeQuery(sql_aff);
			while(rs.next()) {
		    	int idCommande  = rs.getInt("idCommande");
		    	int idAlbum  = rs.getInt("idAlbum");
		    	int idFormat = rs.getInt("idFormat");
		    	int quantite = rs.getInt("quantite");
				
			    adF.add(new LigneCommande(quantite,idCommande,idFormat,idAlbum));	       
			}
			rs.close();
		} catch (SQLException e) {
			return null;
		}
	return adF;
	}

	// affiche tout les elements de la table ligneCommande.Methode reservee a l'admin 
	public void affiche() throws SQLException{
		try{
			String sql_aff = "SELECT quantite, idCommande, idFormat, idAlbum FROM LigneCommande ";
		    ResultSet rs = stmt.executeQuery(sql_aff);
		    
		    boolean a=rs.next();
		    if (a==false){
		    	System.out.println("La table LigneCommande est vide"); 
		    }
		    while(a){
		    	int id  = rs.getInt("idCommande");
		    	int quantite = rs.getInt("quantite");
				int idFormat = rs.getInt("idFormat");
				int idAlbum = rs.getInt("idAlbum");
			    System.out.print("quantite: " + quantite);
			    System.out.print(", idCommande: " + id);
			    System.out.print(", idFormat: " + idFormat);
			    System.out.println(", idAlbum: " + idAlbum);
		
			    a=rs.next();
		    }
		    rs.close();
		} catch (SQLException e){
	    	System.out.println("Table LigneCommande non existante");
	    }
	}
}
