package fr.esisar.cs441.groupe2.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BDD {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/test";
		String login = "root";
		String pass = "Pauline02";
		try{
			Class.forName(driver);			
			Connection connexion = DriverManager.getConnection(url,login,pass);	 
			Statement stmt = connexion.createStatement();
	 
			ResultSet rs = stmt.executeQuery("SELECT * FROM Client");
			boolean a;
			while(a=rs.next())
			if (a==false){
			  	System.out.println("La table CLient est vide"); 
			}
			else{
			  //Retrieve by column name
			   String id  = rs.getString("adresseMail");
			   String nom = rs.getString("nom");
			   String prenom = rs.getString("prenom");
			   String password = rs.getString("password");
			  //Display values
			   System.out.print("adresseMail: " + id);
			   System.out.print(", nom: " + nom);
			   System.out.print(", prenom: " + prenom);
			   System.out.println(", password: " + password);
			}
			rs.close();
		}
		catch (Exception e){
	
			System.out.println("echec pilote : "+e);
		}
	}
}
