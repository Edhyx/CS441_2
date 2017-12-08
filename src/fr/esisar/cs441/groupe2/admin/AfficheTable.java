package fr.esisar.cs441.groupe2.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import fr.esisar.cs441.groupe2.base.BDDs.AdresseDAO;
import fr.esisar.cs441.groupe2.base.BDDs.AlbumDAO;
import fr.esisar.cs441.groupe2.base.BDDs.ClientDAO;
import fr.esisar.cs441.groupe2.base.BDDs.CommandeDAO;
import fr.esisar.cs441.groupe2.base.BDDs.ContientDAO;
import fr.esisar.cs441.groupe2.base.BDDs.FichierImageDAO;
import fr.esisar.cs441.groupe2.base.BDDs.FormatDAO;
import fr.esisar.cs441.groupe2.base.BDDs.LigneCommandeDAO;

public class AfficheTable {

	public static void main(String[] args) {
		String server = "tp-oracle.esisar.grenoble-inp.fr";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@//" + server + "/xe";
		String login = "malossep";
		String pass = "malossep";
		try{
			Class.forName(driver);
			Connection connexion = DriverManager.getConnection(url,login,pass);
			System.out.println("Connection OK!");
			Statement stmt = connexion.createStatement();
			
			//Creation des tables		    
		    AdresseDAO tableAdresse = new AdresseDAO(stmt);
			ClientDAO tableClient = new ClientDAO(stmt);
		    CommandeDAO tableCommande = new CommandeDAO(stmt);
		    FormatDAO tableFormat = new FormatDAO(stmt);
		    AlbumDAO tableAlbum = new AlbumDAO(stmt);
		    LigneCommandeDAO tableLigneCommande = new LigneCommandeDAO(stmt);
		    FichierImageDAO tableFichierImage = new FichierImageDAO(stmt);
		    ContientDAO tableContient = new ContientDAO(stmt);	
		
		    //Affichage des elements
		    System.out.println("\nAdresses de Facturation xxxxxxxxxxxxxxxxx");
		    tableAdresse.affiche_F();
			System.out.println("\nAdresses de livraison xxxxxxxxxxxxxxxxxxx");
			tableAdresse.affiche_L();
			System.out.println("\nClients xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			tableClient.affiche();
			System.out.println("\nCommandes xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			tableCommande.affiche();
			System.out.println("\nFormats xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			tableFormat.affiche();
			System.out.println("\nAlbum xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			tableAlbum.affiche();
			System.out.println("\nligneCommandes xxxxxxxxxxxxxxxxxxxxxxxxxx");
			tableLigneCommande.affiche();
			System.out.println("\nImage xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			tableFichierImage.affiche();
			System.out.println("\nContient xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			tableContient.affiche();
		}
		catch (Exception e) {
			System.out.println("echec driver : "+e);
		}
	}
}
