/*
CS441 Equipe N°2

Format.java
*/

package fr.esisar.cs441.groupe2.base;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Format {

	private int idFormat;
    private int prixUnitaire;
    private ArrayList<LigneCommande> ligneCommande;
	
    public Format(int idFormat, int prixUnitaire, ArrayList<LigneCommande> ligneCommande) {
		super();
		this.idFormat = idFormat;
		this.prixUnitaire = prixUnitaire;
		this.ligneCommande = ligneCommande;
	}
      
	public Format(int idFormat, int prixUnitaire) {
		super();
		this.idFormat = idFormat;
		this.prixUnitaire = prixUnitaire;
		this.ligneCommande = new ArrayList<LigneCommande>();
	}

	public int getIdFormat() {
		return idFormat;
	}

	public int getPrixUnitaire() {
		return prixUnitaire;
	}

	public ArrayList<LigneCommande> getLigneCommande() {
		return ligneCommande;
	}

	public void setIdFormat(int idFormat) {
		this.idFormat = idFormat;
	}

	public void setPrixUnitaire(int prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public void setLigneCommande(ArrayList<LigneCommande> ligneCommande) {
		this.ligneCommande = ligneCommande;
	}

	public void add(Statement stmt) throws SQLException{
	    String sql_element = "INSERT INTO Format " +
	            "VALUES ("+idFormat+", "+prixUnitaire+")";
	    try{
	    stmt.executeUpdate(sql_element);
	    System.out.println("Format '"+idFormat+"' cree");
	    } catch (SQLException e){
	    	System.out.println("Format '"+idFormat+"' existant");
	    }
	}
	
	public void delete(Statement stmt) throws SQLException{
	    String sql_delete = "DELETE FROM Format " +
	            "WHERE idFormat = "+idFormat+"";
	    try{
	    stmt.executeUpdate(sql_delete);
	    System.out.println("Format '"+idFormat+"' supprime");
		} catch (SQLException e){
	    	System.out.println("Table  Format non existant");
	    }
	}
	
	
	public void affiche(Statement stmt) throws SQLException{
		try{
		String sql_aff = "SELECT idFormat, prixUnitaire FROM Format ";
	    ResultSet rs = stmt.executeQuery(sql_aff);
	    
	    boolean a=rs.next();
	    if (a==false){
	    	System.out.println("La table LigneCommande est vide"); 
	    }
	    while(a){
	       //Retrieve by column name
	       int idFormat = rs.getInt("idFormat");
	       int prixUnitaire = rs.getInt("prixUnitaire");
	       //Display values
	       System.out.print("idFormat: " + idFormat);
	       System.out.println(", prixUnitaire: " + prixUnitaire);
	       a=rs.next();
	    }
	    rs.close();
		} catch (SQLException e){
	    	System.out.println("Table Format non existante");
	    }
	}
}