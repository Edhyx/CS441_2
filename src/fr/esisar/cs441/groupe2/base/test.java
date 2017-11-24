package fr.esisar.cs441.groupe2.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.esisar.cs441.groupe2.base.entity.Adresse;
import fr.esisar.cs441.groupe2.base.entity.Client;

public class test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String server = "tp-oracle.esisar.grenoble-inp.fr";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@//"+server+"/xe";
		String login = "malossep";
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url,login,login);
	    Statement stmt = connection.createStatement();
	    
	    /*String sql_delete_tab =  "DROP TABLE Client ";
	    ResultSet rs = stmt.executeQuery(sql_delete_tab);
	    System.out.println("Table supprimee");*/
	    
	    /*String sql_create = "CREATE TABLE Client" +
	            "(adresseMail VARCHAR(255), " +
	            " nom VARCHAR(255), " + 
	            " prenom VARCHAR(255), " + 
	            " password VARCHAR(255), " + 
	            " PRIMARY KEY ( adresseMail ))";
	    stmt.executeUpdate(sql_create);
	    System.out.println("Table creee"); */
	    
		Adresse AdresseA = new Adresse(30,"t","r","s");
		Client clientA = new Client("hnfjydt","nom","prenom","xxx",AdresseA,AdresseA);
		clientA.add(stmt);
		clientA.affiche(stmt);
		
		Client clientB = new Client("aas","nom","prenom","xxx",AdresseA,AdresseA);
		clientB.add(stmt);
		clientB.affiche(stmt);
	}

}
