package fr.esisar.cs441.groupe2.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
			Commande commandeB = new Commande(50,"today",50,clientB);
			Format formatA = new Format(10,50);
			Format formatB = new Format(50,50);
			Album albumA = new Album(1,"vacances","malte",clientA);
			Album albumB = new Album(2,"vacances","malte",clientB);
			LigneCommande lignecommandeA = new LigneCommande(20, commandeA, formatA, albumA);
			LigneCommande lignecommandeB = new LigneCommande(200, commandeB, formatB, albumB);
			FichierImage fichier = new FichierImage("chemin","canon","obj",20,20,20,20,clientA);
			FichierImage fichierB = new FichierImage("ec","canon","obj",20,20,20,20,clientB);
			Contient contient = new Contient(2,"valetta","beau",fichier,albumA);
			Contient contientB = new Contient(2,"ec","beau",fichierB,albumB);
			
			//Ajout des elements
			tableAdresse.add_F(AdresseA);
			tableAdresse.add_F(AdresseB);
			tableAdresse.add_L(AdresseA);
			tableAdresse.add_L(AdresseB);
			tableClient.add(clientA);
			tableClient.add(clientB);
			tableCommande.add(commandeA);
			tableCommande.add(commandeB);
			tableFormat.add(formatA);
			tableFormat.add(formatB);
			tableAlbum.add(albumA);
			tableAlbum.add(albumB);
			tableLigneCommande.add(lignecommandeA);
			tableLigneCommande.add(lignecommandeB);
			tableFichierImage.add(fichier);
			tableFichierImage.add(fichierB);
			tableContient.add(contient);
			tableContient.add(contientB);
						
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
					
			ArrayList<Adresse> adressesF = tableAdresse.getAll_F();			
			for (Adresse array : adressesF) {
				System.out.println(array.toString_F());
			}
			
			ArrayList<Adresse> adressesL = tableAdresse.getAll_L();			
			for (Adresse array : adressesL)
				System.out.println(array.toString_L());
			
			ArrayList<Client> client = tableClient.getAll();			
			for (Client array : client){
				System.out.println(array.toString());
			}
			
			ArrayList<Commande> commande = tableCommande.getAll();			
			for (Commande array : commande)
				System.out.println(array.toString());
			
			ArrayList<Format> format = tableFormat.getAll();			
			for (Format array : format)
				System.out.println(array.toString());
			
			ArrayList<Album> album = tableAlbum.getAll();			
			for (Album array : album)
				System.out.println(array.toString());
			
			ArrayList<LigneCommande> lc = tableLigneCommande.getAll();			
			for (LigneCommande array : lc)
				System.out.println(array.toString());
			
			ArrayList<FichierImage> fis = tableFichierImage.getAll();			
			for (FichierImage array : fis)
				System.out.println(array.toString());
			
			ArrayList<Contient> con = tableContient.getAll();			
			for (Contient array : con)
				System.out.println(array.toString());
			
			//Supprime les �l�ments
			tableLigneCommande.delete(lignecommandeA);
			tableLigneCommande.delete(lignecommandeB);
			tableCommande.delete(commandeA);
			tableCommande.delete(commandeB);
			tableFormat.delete(formatA);
			tableFormat.delete(formatB);
			tableContient.delete(contient);
			tableContient.delete(contientB);
			tableAlbum.delete(albumA);
			tableAlbum.delete(albumB);
			tableFichierImage.delete(fichier);
			tableFichierImage.delete(fichierB);
			tableClient.delete(clientA);
			tableClient.delete(clientB);
			tableAdresse.delete_F(AdresseA);
			tableAdresse.delete_F(AdresseB);
			tableAdresse.delete_L(AdresseA);
			tableAdresse.delete_L(AdresseB);
		}
		catch (Exception e) {
			System.out.println("echec driver : "+e);
		}
	}
}