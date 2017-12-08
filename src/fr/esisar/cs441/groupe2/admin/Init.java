package fr.esisar.cs441.groupe2.admin;

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
		String url = "jdbc:oracle:thin:@//" + server + "/xe";
		String login = "malossep";
		String pass = "malossep";

			Class.forName(driver);	
			Connection connexion = DriverManager.getConnection(url,login,pass);	
			System.out.println("Connection OK!"); 
			Statement stmt = connexion.createStatement();
			
/////////Creer table AdressF
		String sql_adresseF = "CREATE TABLE AdresseF " + 
	            "(idAdresseF INTEGER, " +
	            " rue VARCHAR(255), " + 
	            " codePostal VARCHAR(255), " + 
	            " ville VARCHAR(255), " + 
	            " PRIMARY KEY ( idAdresseF ))";
	    stmt.executeUpdate(sql_adresseF);
	    System.out.println("Table AdresseF cree");

	    
/////////Creer table AdressL
	    String sql_adresseL = "CREATE TABLE AdresseL " +
	            "(idAdresseL INTEGER, " +
	            " rue VARCHAR(255), " + 
	            " codePostal VARCHAR(255), " + 
	            " ville VARCHAR(255), " + 
	            " PRIMARY KEY ( idAdresseL ))";
	    stmt.executeUpdate(sql_adresseL);
	    System.out.println("Table AdresseL cree");

/////////Creer table client
	    String sql_client = "CREATE TABLE Client " +
	            "(adresseMail VARCHAR(255), " +
	            " nom VARCHAR(255), " + 
	            " prenom VARCHAR(255), " + 
	            " password VARCHAR(255), " + 
	            " idAdresseF INTEGER, " +
	            " idAdresseL INTEGER, " +
	            " PRIMARY KEY ( adresseMail ), " +
	            " FOREIGN KEY (idAdresseF) REFERENCES AdresseF(idAdresseF), " +
	            " FOREIGN KEY (idAdresseL) REFERENCES AdresseL(idAdresseL))";
	    stmt.executeUpdate(sql_client);
	    System.out.println("Table Client cree"); 
	    
/////////Creer table Commande
			String sql_commande = "CREATE TABLE Commande " +
		            "(idCommande INTEGER, " +
		            " dates VARCHAR(255), " + 
		            " prixTotal INTEGER, " + 
		            " adresseMail VARCHAR(255), " +  
		            " PRIMARY KEY ( idCommande ), " +
		            " FOREIGN KEY (adresseMail) REFERENCES Client(adresseMail))";
		    stmt.executeUpdate(sql_commande);
		    System.out.println("Table Commande cree");
		    
/////////Creer table Format
	    String sql_format = "CREATE TABLE Format " +
	            "(idFormat INTEGER, " +
	            "prixUnitaire INTEGER, " +
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
	    System.out.println("Table Album cree"); 
	    
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
	    }
}
