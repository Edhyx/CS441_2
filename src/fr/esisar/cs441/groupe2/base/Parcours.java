package fr.esisar.cs441.groupe2.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.esisar.cs441.groupe2.base.BDDs.ClientDAO;
import fr.esisar.cs441.groupe2.base.entity.Adresse;
import fr.esisar.cs441.groupe2.base.entity.Client;

public class Parcours {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/test?useSSL=false";
		String login = "root";
		String pass = "Pauline02";
			Class.forName(driver);	
			Connection connexion = DriverManager.getConnection(url,login,pass);	
			System.out.println("Connection OK!");
			Statement stmt = connexion.createStatement();
	    		    
	    ClientDAO tableClient = new ClientDAO(stmt);
	    
		Adresse AdresseA = new Adresse(30,"t","r","s");
		Client clientA = new Client("hnfjydt","Van Damme","Jean-Claude","DoubleImpact",AdresseA,AdresseA);
		Client clientB = new Client("aas","nom","prenom","xxx",AdresseA,AdresseA);
	
		
		tableClient.add(clientA);
		tableClient.add(clientB);
		
		tableClient.getById();
		//System.out.println(tableClient.getById(clientA).toString());
		
		
		tableClient.delete(clientA);
		tableClient.delete(clientB);
	}
}
