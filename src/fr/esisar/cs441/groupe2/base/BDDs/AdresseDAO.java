package fr.esisar.cs441.groupe2.base.BDDs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.esisar.cs441.groupe2.base.entity.Adresse;

public class AdresseDAO {
	private Statement stmt;

	public AdresseDAO (Statement stmt) {
		super();
		this.stmt = stmt;
	}
	
	//retourne vrai quand une adresse de facturation a ete ajoutee avec succee  
	public boolean add_F(Adresse adF){
	    String sql_element = "INSERT INTO AdresseF " +
	            "VALUES ("+adF.getIdAdresse()+", '"+adF.getRue()+"', '"+adF.getCodePostal()+"', '"+adF.getVille()+"')";
	    try{
	    	stmt.executeUpdate(sql_element);
	    
	    } catch (SQLException e){
	    	return false;
	    }
	    return true;
	}
	
	//retourne vrai quand une adresse de livraison a ete ajoutee avec succee  
	public boolean add_L(Adresse adL){
	    String sql_element = "INSERT INTO AdresseL " +
	            "VALUES ("+adL.getIdAdresse()+", '"+adL.getRue()+"', '"+adL.getCodePostal()+"', '"+adL.getVille()+"')";
	    try{
	    	stmt.executeUpdate(sql_element);
	    
	    } catch (SQLException e){
	    	return false;
	    }
	    return true;
	}
	
	//retourne vrai quand une adresse de facturation a ete supprimee avec succee  
	public boolean delete_F(Adresse adF){
	    String sql_delete = "DELETE FROM AdresseF " +
	            "WHERE idAdresseF = "+adF.getIdAdresse()+"";
	    try{
	    	stmt.executeUpdate(sql_delete);
		} catch (SQLException e){
			return false;
	    }
	    return true;
	}
	
	//retourne vrai quand une adresse de livraison a ete supprimee avec succee  
	public boolean delete_L(Adresse adL){
	    String sql_delete = "DELETE FROM AdresseL " +
	            "WHERE idAdresseL = "+adL.getIdAdresse()+"";
	    try{
	    	stmt.executeUpdate(sql_delete);
		} catch (SQLException e){
			return false;
	    }
	    return true;
	}
	
	//retourne l'adresse de facturation qui correspond a l'id entre en parametre 
	public Adresse getById_F(int id){
		String sql_aff = "SELECT * FROM AdresseF " + "WHERE idAdresseF = " + id +"";
		Adresse adF = null;
		boolean a;
		try{
			ResultSet rs = this.stmt.executeQuery(sql_aff);
			a = rs.next();
			if (a==false){
		    	return null; 
		    }
		    else {
		    	id  = rs.getInt("idAdresseF");
				String rue = rs.getString("rue");
				String codePostal = rs.getString("codePostal");
				String ville = rs.getString("ville");

				adF = new Adresse(id,rue,codePostal,ville);
		    }		
			rs.close();
		}
		catch (SQLException e) {
			return null; 
		}
	    return adF;
	}
	
	//retourne l'adresse de livraison qui correspond a l'id entre en parametre 
	public Adresse getById_L(int id) {
		String sql_aff = "SELECT * FROM AdresseL " + "WHERE idAdresseL = " + id +"";
		Adresse adL = null;
		boolean a;
		try{
			ResultSet rs = this.stmt.executeQuery(sql_aff);
			a = rs.next();
			if (a==false){
				return null; 
		    }
		    else {
		    	id  = rs.getInt("idAdresseL");
				String rue = rs.getString("rue");
				String codePostal = rs.getString("codePostal");
				String ville = rs.getString("ville");

				adL = new Adresse(id,rue,codePostal,ville);
		    }		
			rs.close();
		}
		catch (SQLException e) {
			return null; 
		}
	    return adL;
	}
	
	// retourne dans une arrayList toutes les adresses de facturation
	public ArrayList<Adresse> getAll_F() {
		String sql_aff = "SELECT * FROM AdresseF ";
		ArrayList<Adresse> adF = new ArrayList<Adresse>();
	    try {
	    	ResultSet rs = this.stmt.executeQuery(sql_aff);
			while(rs.next()) {
		    	int idAdresseF  = rs.getInt("idAdresseF");
				String rue = rs.getString("rue");
				String codePostal = rs.getString("codePostal");
				String ville = rs.getString("ville");

			    adF.add(new Adresse(idAdresseF,rue,codePostal,ville));	       
			}
			rs.close();
		} catch (SQLException e) {
			return null;
		}
	    return adF;
	}
	
	// retourne dans une arrayList toutes les adresses de livraison
	public ArrayList<Adresse> getAll_L() {
		String sql_aff = "SELECT * FROM AdresseL ";
		ArrayList<Adresse> adL = new ArrayList<Adresse>();
	    try {
	    	ResultSet rs = this.stmt.executeQuery(sql_aff);
			while(rs.next()) {
		    	int idAdresseL  = rs.getInt("idAdresseL");
				String rue = rs.getString("rue");
				String codePostal = rs.getString("codePostal");
				String ville = rs.getString("ville");
	
			    adL.add(new Adresse(idAdresseL,rue,codePostal,ville));	       
			}
			rs.close();
		} catch (SQLException e) {
			return null;
		}
	    return adL;
	}
	
	// affiche tout les elements de la table adresseF(L).Methode reservee a l'admin 
	public void affiche_F(){
		try{
			String sql_aff = "SELECT * FROM AdresseF ";
		    ResultSet rs = stmt.executeQuery(sql_aff);
		    boolean a=rs.next();
		    if (a==false){
		    	System.out.println("La table AdresseF est vide"); 
		    }
		    while(a){
			    int id  = rs.getInt("idAdresseF");
			    String rue = rs.getString("rue");
			    String codePostal = rs.getString("codePostal");
			    String ville = rs.getString("ville");
			    System.out.print("idAdresseF: " + id);
			    System.out.print(", rue: " + rue);
			    System.out.print(", codePostal: " + codePostal);
			    System.out.println(", ville: " + ville);
			    a=rs.next();
		    }
		    rs.close();
		} catch (SQLException e){
	    	System.out.println("Table AdresseF non existante");
	    }
	}

	public void affiche_L(){
		try{
			String sql_aff = "SELECT idAdresseL, rue, codePostal, ville FROM AdresseL ";
		    ResultSet rs = stmt.executeQuery(sql_aff);
		    boolean a=rs.next();
		    if (a==false){
		    	System.out.println("La table AdresseL est vide"); 
		    }
		    while(a){
			    int id  = rs.getInt("idAdresseL");
			    String rue = rs.getString("rue");
			    String codePostal = rs.getString("codePostal");
		        String ville = rs.getString("ville");
			    System.out.print("idAdresseL: " + id);
			    System.out.print(", rue: " + rue);
			    System.out.print(", codePostal: " + codePostal);
			    System.out.println(", ville: " + ville);
			    a=rs.next();
		    }
		    rs.close();
		} catch (SQLException e){
	    	System.out.println("Table AdresseL non existante");
	    }
	}
}
