package fr.esisar.cs441.groupe2.base.BDDs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.esisar.cs441.groupe2.base.entity.Adresse;
import fr.esisar.cs441.groupe2.base.entity.Client;

public class AdresseDAO {
	private Statement stmt;

	public AdresseDAO (Statement stmt) {
		super();
		this.stmt = stmt;
	}
	
	public void add_F(Adresse adF) throws SQLException{
	    String sql_element = "INSERT INTO AdresseF " +
	            "VALUES ("+adF.getIdAdresse()+", '"+adF.getRue()+"', '"+adF.getCodePostal()+"', '"+adF.getVille()+"')";
	    try{
	    stmt.executeUpdate(sql_element);
	    System.out.println("AdresseF '"+adF.getIdAdresse()+"' cree");
	    } catch (SQLException e){
	    	System.out.println("idAdresseF '"+adF.getIdAdresse()+"' existant");
	    }
	}
	
	public void add_L(Adresse adL) throws SQLException{
	    String sql_element = "INSERT INTO AdresseL " +
	            "VALUES ("+adL.getIdAdresse()+", '"+adL.getRue()+"', '"+adL.getCodePostal()+"', '"+adL.getVille()+"')";
	    try{
	    stmt.executeUpdate(sql_element);
	    System.out.println("AdresseL '"+adL.getIdAdresse()+"' cree");
	    } catch (SQLException e){
	    	System.out.println("idAdresseL '"+adL.getIdAdresse()+"' existant");
	    }
	}

	public void delete_F(Adresse adF) throws SQLException{
	    String sql_delete = "DELETE FROM AdresseF " +
	            "WHERE idAdresseF = "+adF.getIdAdresse()+"";
	    try{
	    stmt.executeUpdate(sql_delete);
	    System.out.println("AdresseF '"+adF.getIdAdresse()+"' supprime");
		} catch (SQLException e){
	    	System.out.println("Table AdresseF non existant" +e);
	    }
	}
	
	public void delete_L(Adresse adL) throws SQLException{
	    String sql_delete = "DELETE FROM AdresseL " +
	            "WHERE idAdresseL = "+adL.getIdAdresse()+"";
	    try{
	    stmt.executeUpdate(sql_delete);
	    System.out.println("AdresseL '"+adL.getIdAdresse()+"' supprime");
		} catch (SQLException e){
	    	System.out.println("Table AdresseL non existant");
	    }
	}
	
	public Adresse getById_F(int id) throws SQLException{
		String sql_aff = "SELECT * FROM AdresseF ";
		boolean notFound = true;
		Adresse adF = null;
		try{
			int idAdresseF;
			ResultSet rs = this.stmt.executeQuery(sql_aff);
			while(rs.next() && notFound) {
				//Retrieve by column name
				idAdresseF  = rs.getInt("idAdresseF");
			       
			    if(idAdresseF==id) {
			    	idAdresseF  = rs.getInt("idAdresseF");
					 String rue = rs.getString("rue");
					 String codePostal = rs.getString("codePostal");
					 String ville = rs.getString("ville");

				    adF = new Adresse(idAdresseF,rue,codePostal,ville);
				    notFound = false;
			     }		       
			}			
			rs.close();
			if(notFound) {
				throw new SQLException();
			}
		} catch (SQLException e) {
			System.out.println("Impossible de trouver le client associe a l'adresse : " + id);
		}
	    return adF;
	}
	
	public Adresse getById_L(int id) throws SQLException{
		String sql_aff = "SELECT * FROM AdresseL ";
		boolean notFound = true;
		Adresse adL = null;
		try{
			int idAdresseL;
			ResultSet rs = this.stmt.executeQuery(sql_aff);
			while(rs.next() && notFound) {
				//Retrieve by column name
				idAdresseL  = rs.getInt("idAdresseL");
			       
			    if(idAdresseL==id) {
			    	idAdresseL  = rs.getInt("idAdresseL");
					 String rue = rs.getString("rue");
					 String codePostal = rs.getString("codePostal");
					 String ville = rs.getString("ville");

				    adL = new Adresse(idAdresseL,rue,codePostal,ville);
				    notFound = false;
			     }		       
			}			
			rs.close();
			if(notFound) {
				throw new SQLException();
			}
		} catch (SQLException e) {
			System.out.println("Impossible de trouver le client associe a l'adresse : " + id);
		}
	    return adL;
	}
	
public ArrayList<Adresse> getAll_F() {
		String sql_aff = "SELECT * FROM AdresseF ";
		ArrayList<Adresse> adF = new ArrayList<Adresse>();
	    try {
	    	ResultSet rs = this.stmt.executeQuery(sql_aff);
			while(rs.next()) {
				
				//Retrieve by column name
		    	int idAdresseF  = rs.getInt("idAdresseF");
				String rue = rs.getString("rue");
				String codePostal = rs.getString("codePostal");
				String ville = rs.getString("ville");

			    adF.add(new Adresse(idAdresseF,rue,codePostal,ville));	       
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("Impossible de trouver d'elements dans la table");
		}
	    return adF;
	}

public ArrayList<Adresse> getAll_L() {
	String sql_aff = "SELECT * FROM AdresseL ";
	ArrayList<Adresse> adL = new ArrayList<Adresse>();
    try {
    	ResultSet rs = this.stmt.executeQuery(sql_aff);
		while(rs.next()) {
			
			//Retrieve by column name
	    	int idAdresseL  = rs.getInt("idAdresseL");
			String rue = rs.getString("rue");
			String codePostal = rs.getString("codePostal");
			String ville = rs.getString("ville");

		    adL.add(new Adresse(idAdresseL,rue,codePostal,ville));	       
		}
		rs.close();
	} catch (SQLException e) {
		System.out.println("Impossible de trouver d'elements dans la table");
	}
    return adL;
}

public void affiche_F() throws SQLException{
	try{
	String sql_aff = "SELECT * FROM AdresseF ";
    ResultSet rs = stmt.executeQuery(sql_aff);
    
    boolean a=rs.next();
    if (a==false){
    	System.out.println("La table AdresseF est vide"); 
    }
    while(a){
    	//Retrieve by column name
	    int id  = rs.getInt("idAdresseF");
	    String rue = rs.getString("rue");
	    String codePostal = rs.getString("codePostal");
	    String ville = rs.getString("ville");
        //Display values
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

public void affiche_L() throws SQLException{
	try{
	String sql_aff = "SELECT idAdresseL, rue, codePostal, ville FROM AdresseL ";
    ResultSet rs = stmt.executeQuery(sql_aff);
    
    boolean a=rs.next();
    if (a==false){
    	System.out.println("La table AdresseL est vide"); 
    }
    while(a){
    	//Retrieve by column name
	    int id  = rs.getInt("idAdresseL");
	    String rue = rs.getString("rue");
	    String codePostal = rs.getString("codePostal");
        String ville = rs.getString("ville");
	    //Display values
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
