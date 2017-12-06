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

	public void add(Format format) {
	    String sql_element = "INSERT INTO Format " +
	            "VALUES ("+format.getIdFormat()+", "+format.getPrixUnitaire()+")";
	    try{
		    stmt.executeUpdate(sql_element);
	    } catch (SQLException e){
	    }
	}
	
	public void delete(Format format) throws SQLException{
	    String sql_delete = "DELETE FROM Format " +
	            "WHERE idFormat = "+format.getIdFormat()+"";
	    try{
		    stmt.executeUpdate(sql_delete);
		} catch (SQLException e){
	    }
	}
	
	public Format getById(int id) throws SQLException{
		String sql_aff = "SELECT * FROM Format " + "WHERE idFormat = " + id +"";
		Format f = null;
		boolean a;
		try{
			ResultSet rs = this.stmt.executeQuery(sql_aff);
			a = rs.next();
			if (a==false){
				return null;
		    }
		    else {
		    	id  = rs.getInt("idFormat");
				int prixUnitaire = rs.getInt("prixUnitaire");
				f = new Format(id,prixUnitaire);
		    }		
			rs.close();
		}
		catch (SQLException e) {
			return null;
		}
	    return f;
	}
	
	public ArrayList<Format> getAll() {
		String sql_aff = "SELECT * FROM Format ";
		ArrayList<Format> f = new ArrayList<Format>();
	    try {
	    	ResultSet rs = this.stmt.executeQuery(sql_aff);
			while(rs.next()) {
		    	int idFormat  = rs.getInt("idFormat");
		    	int prixUnitaire = rs.getInt("prixUnitaire");

			    f.add(new Format(idFormat,prixUnitaire));	       
			}
			rs.close();
		} catch (SQLException e) {
			return null;
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
		    	int id  = rs.getInt("idFormat");
				int prixUnitaire = rs.getInt("prixUnitaire");
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
