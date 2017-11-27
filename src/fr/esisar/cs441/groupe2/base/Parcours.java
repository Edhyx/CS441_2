package fr.esisar.cs441.groupe2.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import fr.esisar.cs441.groupe2.base.BDDs.ClientDAO;
import fr.esisar.cs441.groupe2.base.entity.Adresse;
import fr.esisar.cs441.groupe2.base.entity.Client;

public class Parcours {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String server = "tp-oracle.esisar.grenoble-inp.fr";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@//"+server+"/xe";
		String login = "malossep";
		
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url,login,login);
	    Statement stmt = connection.createStatement();
	     
	    ClientDAO tableClient = new ClientDAO(stmt);
	    
		Adresse AdresseA = new Adresse(30,"t","r","s");
		Client clientA = new Client("hnfjydt","Van Damme","Jean-Claude","DoubleImpact",AdresseA,AdresseA);
		Client clientB = new Client("aas","nom","prenom","xxx",AdresseA,AdresseA);
	
		
		tableClient.add(clientA);
		tableClient.add(clientB);
		
		System.out.println(tableClient.getById(clientA.getAdresseMail()).toString());
		//System.out.println(tableClient.getById(clientA).toString());
		
		
		tableClient.delete(clientA);
		tableClient.delete(clientB);
	}
}
