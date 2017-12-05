package fr.esisar.cs441.groupe2.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Suppression {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/test?useSSL=false";
		String login = "root";
		String pass = "Pauline02";

		
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url,login,pass);
	    Statement stmt = connection.createStatement();

	    String slq_show =  "SHOW TABLES FROM test";
	    ResultSet rs_show = stmt.executeQuery(slq_show);
	    System.out.println("SHOW: "+rs_show.getRow());
	    

	    ResultSet rs1=stmt.executeQuery("SELECT tablespace_name, table_name from all_tables");
	    while(rs1.next()) {
	    	System.out.println("Table " + rs1.getString("table_name"));
	    	rs1.next();
	    }

	    //suppression LigneCommande
	    String sql_delete_tabLc =  "DROP TABLE LigneCommande ";
	    ResultSet rsLc = stmt.executeQuery(sql_delete_tabLc);
	    System.out.println("Table LigneCommande supprimee");
	
	    //suppression Commande
	    String sql_delete_tabCo =  "DROP TABLE Commande ";
	    ResultSet rsCo = stmt.executeQuery(sql_delete_tabCo);
	    System.out.println("Table Commande supprimee");
	  
	    //suppression Format
	    String sql_delete_tabF =  "DROP TABLE Format ";
	    ResultSet rsF = stmt.executeQuery(sql_delete_tabF);
	    System.out.println("Table Format supprimee");
	    
	    //suppression Contient
	    String sql_delete_tabCt =  "DROP TABLE Contient ";
	    ResultSet rsCt = stmt.executeQuery(sql_delete_tabCt);
	    System.out.println("Table FichierImage supprimee");
	    
	    //suppression Album
	    String sql_delete_tabAlb =  "DROP TABLE Album ";
	    ResultSet rsAlb = stmt.executeQuery(sql_delete_tabAlb);
	    System.out.println("Table Album supprimee");
	   
	    //suppression FichierImage
	    String sql_delete_tabFi =  "DROP TABLE FichierImage ";
	    ResultSet rsFi = stmt.executeQuery(sql_delete_tabFi);
	    System.out.println("Table FichierImage supprimee");
	    
	    //suppression client
	    String sql_delete_tabC =  "DROP TABLE Client ";
	    ResultSet rsClient = stmt.executeQuery(sql_delete_tabC);
	    System.out.println("Table Client supprimee");
	     
	    //suppression adressF
	    String sql_delete_tabAdF =  "DROP TABLE AdresseF ";
	    ResultSet rsAF = stmt.executeQuery(sql_delete_tabAdF);
	    System.out.println("Table AdresseF supprimee");

	    //suppression adressL
	    String sql_delete_tabAdL =  "DROP TABLE AdresseL ";
	    ResultSet rsAL = stmt.executeQuery(sql_delete_tabAdL);
	    System.out.println("Table AdresseL supprimee");
	}

}
