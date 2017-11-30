package fr.esisar.cs441.groupe2.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.esisar.cs441.groupe2.base.BDDs.AdresseDAO;
import fr.esisar.cs441.groupe2.base.BDDs.ClientDAO;
import fr.esisar.cs441.groupe2.base.BDDs.CommandeDAO;
import fr.esisar.cs441.groupe2.base.entity.*;

public class BDD_Test {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String server = "tp-oracle.esisar.grenoble-inp.fr";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@//"+server+"/xe";
		String login = "malossep";
		String pass = "malossep";
		try{
			Class.forName(driver);
			Connection connexion = DriverManager.getConnection(url,login,pass);
			System.out.println("Connection OK!");
			Statement stmt = connexion.createStatement();
			//Creation des tables		    
			ClientDAO tableClient = new ClientDAO(stmt);
		    AdresseDAO tableAdresse = new AdresseDAO(stmt);
		    CommandeDAO tableCommande = new CommandeDAO(stmt);
		    
		    
		    //Creation des objets
			Adresse AdresseA = new Adresse(30,"t","r","s");
			Adresse AdresseB = new Adresse(50,"t","r","s");
			Client clientA = new Client("cc","Van Damme","Jean-Claude","DoubleImpact",AdresseA,AdresseB);
			Client clientB = new Client("allo","nom","prenom","xxx",AdresseA,AdresseB);
			Commande commandeA = new Commande(100,"today",50,clientA);
			Format formatA = new Format(10,50);
			Album albumA = new Album(1,"vacances","malte",clientA);
			LigneCommande lignecommandeA = new LigneCommande(20, commandeA, formatA, albumA);
			FichierImage fichier = new FichierImage("chemin","canon","obj",20,20,20,20,clientA);
			
			//Ajout des elements
			tableAdresse.add_F(AdresseA);
			tableAdresse.add_F(AdresseB);
			tableAdresse.add_L(AdresseB);
			tableClient.add(clientA);
			tableClient.add(clientB);
			tableCommande.add(commandeA);
	
			
			//Affichage des elements
			tableAdresse.affiche_F();
			tableAdresse.affiche_L();
			tableClient.affiche();
			
			Adresse a = tableAdresse.getById_F(30);

			System.out.println(a.toString_F());
			
			Client find= tableClient.getById("cc");
			System.out.println(find.toString());
			//System.out.println(tableAdresse.getById_F(50).toString());
			//System.out.println("e"+clientA.toString());
			//System.out.println(tableClient.getById("cc").toString());
			//tableClient.getById();
			
			
			tableClient.delete(clientA);
			tableClient.delete(clientB);
		}
		catch (Exception e) {
			System.out.println("echec driver : "+e);
		}
	}
}