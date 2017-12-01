package fr.esisar.cs441.groupe2.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import fr.esisar.cs441.groupe2.base.entity.*;
import fr.esisar.cs441.groupe2.base.BDDs.*;
public class Model {

	private String idClient;
	private Statement stmt;

	public Model() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/test?useSSL=false";
		String login = "root";
		String pass = "Pauline02";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
		Connection connexion = null;
		try {
			connexion = DriverManager.getConnection(url,login,pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}	

		Statement stmts = null;
		try {
			stmts = connexion.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.stmt = stmts;
	}
	
	public void setClient(String id) {
		this.idClient = id;
	}
	
	public String getClientPassword(String id) {
		ClientDAO tableClient = new ClientDAO(stmt);
		Client client = tableClient.getById(id);
		if (client ==null) {return null;}
		else
		return client.getPassword();
		
	}
	
	private Adresse createAdressF(int idAdresseF, String rue, String codePostal, String ville) {
		Adresse newAdressF = new Adresse(idAdresseF,rue,codePostal,ville);
		AdresseDAO tableAdressF = new AdresseDAO(stmt);
		try {
			tableAdressF.add_F(newAdressF);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return newAdressF;
	}
	public Adresse createAdressL(int idAdresseL, String rue, String codePostal, String ville) {
		Adresse newAdressL = new Adresse(idAdresseL,rue,codePostal,ville);
		AdresseDAO tableAdressL = new AdresseDAO(stmt);
		try {
			tableAdressL.add_F(newAdressL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newAdressL;
	}
	public boolean createClient(String adresseMail, String nom, String prenom, String password) {
		Client newClient = new Client(adresseMail, nom, prenom, password, createAdressF(0, null, null, null), createAdressL(0, null, null, null));
		ClientDAO tableClient = new ClientDAO(stmt);
		try {
			tableClient.add(newClient);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean addFile(String appareilPhoto, String objectif, String distance, String sensibilte, String ouverture, String vitesse) {
		
		String url = new String(""+ThreadLocalRandom.current().nextInt(0, 1000 + 1));
		
		// completer

		return true;
	}
	
	public boolean addFolder( String titre, String sousTitre) {
		
		String id = new String(""+ThreadLocalRandom.current().nextInt(0, 1000 + 1));
		
		// completer
		
		return true;
		
	}
	
	public ArrayList<String> getFolderList() {
		ArrayList<String> returns = new ArrayList<String>();
		
		returns.add("blabla");
		returns.add("poloplop");
		
		return returns;
	}
	
}
