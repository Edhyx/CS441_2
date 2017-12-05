package fr.esisar.cs441.groupe2.base;

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
		// TODO Auto-generated method stub
		String server = "tp-oracle.esisar.grenoble-inp.fr";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@//"+server+"/xe";
		String login = "malossep";
		String pass ="malossep";
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
		tableAdresse.affiche_F();
		tableAdresse.affiche_L();
		tableClient.affiche();
		tableCommande.affiche();
		tableFormat.affiche();
		tableAlbum.affiche();
		tableLigneCommande.affiche();
		tableFichierImage.affiche();
		tableContient.affiche();
	}
	catch (Exception e) {
		System.out.println("echec driver : "+e);
	}
	}
}
