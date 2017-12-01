package fr.esisar.cs441.groupe2.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import fr.esisar.cs441.groupe2.base.BDDs.*;
import fr.esisar.cs441.groupe2.base.entity.*;

public class BDD_Test {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
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
			Contient contient = new Contient(2,"valetta","beau",fichier,albumA);
			
			//Ajout des elements
			tableAdresse.add_F(AdresseA);
			tableAdresse.add_F(AdresseB);
			tableAdresse.add_L(AdresseB);
			tableClient.add(clientA);
			tableClient.add(clientB);
			tableCommande.add(commandeA);
			tableFormat.add(formatA);
			tableAlbum.add(albumA);
			tableLigneCommande.add(lignecommandeA);
			tableFichierImage.add(fichier);
			tableContient.add(contient);
			
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
						
			//Cherche les elements avec leur id
			Adresse a = tableAdresse.getById_F(30);
			System.out.println(a.toString_F());
			Client find= tableClient.getById("cc");
			System.out.println(find.toString());
			Commande c = tableCommande.getById(100);
			System.out.println(c.toString());
			Format f = tableFormat.getById(10);
			System.out.println(f.toString());
			Album al = tableAlbum.getById(1);
			System.out.println(al.toString());
			LigneCommande l = tableLigneCommande.getById(100);
			System.out.println(l.toString());
			FichierImage fi = tableFichierImage.getById("chemin");
			System.out.println(fi.toString());
			Contient co = tableContient.getById(1, "chemin");
			System.out.println(co.toString());
			
			//Supprime les elements
			tableLigneCommande.delete(lignecommandeA);
			tableCommande.delete(commandeA);
			tableFormat.delete(formatA);
			tableContient.delete(contient);
			tableAlbum.delete(albumA);
			tableFichierImage.delete(fichier);
			tableClient.delete(clientA);
			tableClient.delete(clientB);
			tableAdresse.delete_F(AdresseA);
			tableAdresse.delete_F(AdresseB);
			tableAdresse.delete_L(AdresseB);
		}
		catch (Exception e) {
			System.out.println("echec driver : "+e);
		}
	}
}