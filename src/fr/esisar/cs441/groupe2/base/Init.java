package fr.esisar.cs441.groupe2.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Init {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String server = "tp-oracle.esisar.grenoble-inp.fr";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@//"+server+"/xe";
		String login = "malossep";
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url,login,login);
			
	    Statement stmt = connection.createStatement();
	    /////////Creer table client
	    String sql_client = "CREATE TABLE Client " +
	            "(adresseMail VARCHAR(255), " +
	            " nom VARCHAR(255), " + 
	            " prénom VARCHAR(255), " + 
	            " password VARCHAR(255), " + 
	            " idAdressF INTEGER, " +
	            " idAdressL INTEGER, " +
	            " PRIMARY KEY ( adresseMail ), " +
	            " FOREIGN KEY (idAdressF) REFERENCES AdressF(idAdressF), " +
	            " FOREIGN KEY (idAdressL) REFERENCES AdressL(idAdressL))";
	    
	    stmt.executeUpdate(sql_client);
	    System.out.println("Table client cree"); 
/////////Creer table AdressF
	    String sql_adressF = "CREATE TABLE AdressF " +
	            "(idAdressF INTEGER, " +
	            " rue VARCHAR(255), " + 
	            " codePostal VARCHAR(255), " + 
	            " ville VARCHAR(255), " + 
	            " PRIMARY KEY ( idAdressF ))";
	    stmt.executeUpdate(sql_adressF);
	    System.out.println("Table adressF cree"); 
/////////Creer table AdressL
	    String sql_adressL = "CREATE TABLE AdressL " +
	            "(idAdressL INTEGER, " +
	            " rue VARCHAR(255), " + 
	            " codePostal VARCHAR(255), " + 
	            " ville VARCHAR(255), " + 
	            " PRIMARY KEY ( idAdressL ))";
	    
	    stmt.executeUpdate(sql_adressL);
	    System.out.println("Table adressL cree"); 
	    /////////Creer table commande
	    String sql_commande = "CREATE TABLE Commande " +
	            "(idCommande INTEGER, " +
	            " date VARCHAR(255), " + 
	            " prixTotal INTEGER, " + 
	            " adresseMail VARCHAR(255), " + 
	            " PRIMARY KEY ( idCommande ), " +
	            " FOREIGN KEY (adresseMail) REFERENCES Client(adresseMail))";
	    
	    stmt.executeUpdate(sql_commande);
	    System.out.println("Table commande cree"); 
/////////Creer table LigneCommande
	    String sql_ligneC = "CREATE TABLE LigneCommande " +
	            "(quantite INTEGER, " +
	            " idCommande INTEGER, " + 
	            " idFormat INTEGER, " + 
	            " idAlbum INTEGER, " + 
	            " FOREIGN KEY (idCommande) REFERENCES Commande(idCommande), " +
	            " FOREIGN KEY (idFormat) REFERENCES Format(idFormat), " +
	            " FOREIGN KEY (idAlbum) REFERENCES Album(idAlbum))";
	    
	    stmt.executeUpdate(sql_ligneC);
	    System.out.println("Table LigneCommande cree"); 
/////////Creer table Format
	    String sql_format = "CREATE TABLE Format " +
	            "(idFormat INTEGER, " +
	            " PRIMARY KEY ( idFormat ))";
	    
	    stmt.executeUpdate(sql_format);
	    System.out.println("Table Format cree"); 
	    /////////Creer table Album
	    String sql_album = "CREATE TABLE Album " +
	            "(idAlbum INTEGER, " +
	            " titre VARCHAR(255), " + 
	            " sousTitre VARCHAR(255), " + 
	            " adresseMail VARCHAR(255), " + 
	            " PRIMARY KEY ( idAlbum ), " +
	            " FOREIGN KEY (adresseMail) REFERENCES Client(adresseMail))";
	    
	    stmt.executeUpdate(sql_album);
	    System.out.println("Table album cree"); 
/////////Creer table Contient
	    String sql_contient = "CREATE TABLE Contient " +
	            "(numOrdre INTEGER, " +
	            " titre VARCHAR(255), " + 
	            " commentaire VARCHAR(255), " + 
	            " idAlbum INTEGER, " + 
	            " cheminAcces VARCHAR(255), " + 
	            " PRIMARY KEY ( idAlbum , cheminAcces ), " +
	            " FOREIGN KEY (cheminAcces) REFERENCES FichierImage(cheminAcces), " +
	            " FOREIGN KEY (idAlbum) REFERENCES Album(idAlbum))";
	    
	    stmt.executeUpdate(sql_contient);
	    System.out.println("Table Contient cree"); 
	    /////////Creer table FichierImage
	    String sql_fichierIm = "CREATE TABLE FichierImage " +
	            "(cheminAcces VARCHAR(255), " +
	            " appareilPhoto VARCHAR(255), " + 
	            " objectif VARCHAR(255), " + 
	            " distanceFocale INTEGER, " + 
	            " sensibiliteISO INTEGER, " + 
	            " ouverture INTEGER, " + 
	            " vitesseObturation INTEGER, " + 
	            " adresseMail VARCHAR(255), " + 
	            " PRIMARY KEY ( cheminAcces ), " +
	            " FOREIGN KEY (adresseMail) REFERENCES Client(adresseMail))";
	    
	    stmt.executeUpdate(sql_fichierIm);
	    System.out.println("Table FichierImage cree"); 

	}
	

}
