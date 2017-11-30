package fr.esisar.cs441.groupe2.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Suppression {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String server = "tp-oracle.esisar.grenoble-inp.fr";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@//"+server+"/xe";
		String login = "malossep";
		String pass ="malossep";
		
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url,login,pass);
	    Statement stmt = connection.createStatement();
	    
	    String sql_delete_tab =  "DROP TABLE Client ";
	    ResultSet rs = stmt.executeQuery(sql_delete_tab);
	    System.out.println("Table supprimee");
	}

}
