package fr.esisar.cs441.groupe2.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Suppression {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String server = "tp-oracle.esisar.grenoble-inp.fr";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@//" + server + "/xe";
		String login = "malossep";
		String pass = "malossep";

		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url,login,pass);
	    Statement stmt = connection.createStatement();
	    
	    //suppression LigneCommande
	    String sql_delete_tabLc =  "DROP TABLE LigneCommande ";
	    stmt.executeQuery(sql_delete_tabLc);
	    System.out.println("Table LigneCommande supprimee");
	
	    //suppression Commande
	    String sql_delete_tabCo =  "DROP TABLE Commande ";
	    stmt.executeQuery(sql_delete_tabCo);
	    System.out.println("Table Commande supprimee");
	  
	    //suppression Format
	    String sql_delete_tabF =  "DROP TABLE Format ";
	    stmt.executeQuery(sql_delete_tabF);
	    System.out.println("Table Format supprimee");
	    
	    //suppression Contient
	    String sql_delete_tabCt =  "DROP TABLE Contient ";
	    stmt.executeQuery(sql_delete_tabCt);
	    System.out.println("Table FichierImage supprimee");
	    
	    //suppression Album
	    String sql_delete_tabAlb =  "DROP TABLE Album ";
	    stmt.executeQuery(sql_delete_tabAlb);
	    System.out.println("Table Album supprimee");
	   
	    //suppression FichierImage
	    String sql_delete_tabFi =  "DROP TABLE FichierImage ";
	    stmt.executeQuery(sql_delete_tabFi);
	    System.out.println("Table FichierImage supprimee");
	    
	    //suppression client
	    String sql_delete_tabC =  "DROP TABLE Client ";
	    stmt.executeQuery(sql_delete_tabC);
	    System.out.println("Table Client supprimee");
	     
	    //suppression adressF
	    String sql_delete_tabAdF =  "DROP TABLE AdresseF ";
	    stmt.executeQuery(sql_delete_tabAdF);
	    System.out.println("Table AdresseF supprimee");

	    //suppression adressL
	    String sql_delete_tabAdL =  "DROP TABLE AdresseL ";
	    stmt.executeQuery(sql_delete_tabAdL);
	    System.out.println("Table AdresseL supprimee");
	}

}
