package fr.esisar.cs441.groupe2.base.BDDs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.esisar.cs441.groupe2.base.entity.Format;

public class FormatDAO {
	private Statement stmt;

	public FormatDAO (Statement stmt) {
		super();
		this.stmt = stmt;
	}

	public void add(Format format) throws SQLException{
	    String sql_element = "INSERT INTO Format " +
	            "VALUES ("+format.getIdFormat()+", "+format.getPrixUnitaire()+")";
	    try{
	    stmt.executeUpdate(sql_element);
	    System.out.println("Format '"+format.getIdFormat()+"' cree");
	    } catch (SQLException e){
	    	System.out.println("Format '"+format.getIdFormat()+"' existant");
	    }
	}
	
	public void delete(Format format) throws SQLException{
	    String sql_delete = "DELETE FROM Format " +
	            "WHERE idFormat = "+format.getIdFormat()+"";
	    try{
	    stmt.executeUpdate(sql_delete);
	    System.out.println("Format '"+format.getIdFormat()+"' supprime");
		} catch (SQLException e){
	    	System.out.println("Table  Format non existant");
	    }
	}
	
	public Format getById(int id) throws SQLException{
		String sql_aff = "SELECT * FROM Format " + "WHERE idFormat = " + id +"";
		Format f = null;
		boolean a;
		try{
			ResultSet rs = this.stmt.executeQuery(sql_aff);
			a = rs.next();
				//Retrieve by column name
			if (a==false){
		    	System.out.println("Impossible de trouver le Format : " + id); 
		    }
		    else {
		    	id  = rs.getInt("idFormat");
				int prixUnitaire = rs.getInt("prixUnitaire");
				f = new Format(id,prixUnitaire);
		    }		
		rs.close();
		}
		catch (SQLException e) {
			System.out.println("Impossible de trouver le format : " + id);
		}
	    return f;
	}
	
public ArrayList<Format> getAll() {
		String sql_aff = "SELECT * FROM Format ";
		ArrayList<Format> f = new ArrayList<Format>();
	    try {
	    	ResultSet rs = this.stmt.executeQuery(sql_aff);
			while(rs.next()) {
				
				//Retrieve by column name
		    	int idFormat  = rs.getInt("idFormat");
		    	int prixUnitaire = rs.getInt("prixUnitaire");

			    f.add(new Format(idFormat,prixUnitaire));	       
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("Impossible de trouver d'elements dans la table");
		}
	    return f;
	}


public void affiche() throws SQLException{
	try{
	String sql_aff = "SELECT * FROM Format ";
    ResultSet rs = stmt.executeQuery(sql_aff);
    
    boolean a=rs.next();
    if (a==false){
    	System.out.println("La table Format est vide"); 
    }
    while(a){
    	//Retrieve by column name
    	int id  = rs.getInt("idFormat");
		int prixUnitaire = rs.getInt("prixUnitaire");
	    //Display values
	    System.out.print("idFormat: " + id);
	    System.out.println(", prixUnitaire: " + prixUnitaire);
	    a=rs.next();
    }
    rs.close();
	} catch (SQLException e){
    	System.out.println("Table Format non existante");
    }
}
}
