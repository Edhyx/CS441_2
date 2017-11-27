package fr.esisar.cs441.groupe2.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.esisar.cs441.groupe2.base.entity.*;

public class BDD_Test {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/test?useSSL=false";
		String login = "root";
		String pass = "Pauline02";
		try{
			Class.forName(driver);	
			Connection connexion = DriverManager.getConnection(url,login,pass);	
			System.out.println("Connection OK!"); 
			Statement stmt = connexion.createStatement();
	 
			Adresse AdresseA_f = new Adresse(30,"t","r","s");
			Adresse AdresseA_l = new Adresse(30,"t","r","s");
			Client clientA = new Client("hnfjydt","nom","prenom","xxx",AdresseA_f,AdresseA_l);
			Client clientB = new Client("coucou","nom","prenom","xxx",AdresseA_f,AdresseA_l);
			Commande commandeA = new Commande(100,"today",50,clientA);
			Format formatA = new Format(10,50);
			Album albumA = new Album(1,"vacances","malte",clientA);
			LigneCommande lignecommandeA = new LigneCommande(20, commandeA, formatA, albumA);
			FichierImage fichier = new FichierImage("chemin","canon","obj",20,20,20,20,clientA);
			/*ArrayList albums = new ArrayList();
			albums.add(albumA);
			Contient contient = new Contient(2,"valetta","beau",albums,fichier);*/
			
			//ADD
			System.out.println("ADD");
			AdresseA_f.add_F(stmt);
			AdresseA_l.add_L(stmt);
			AdresseA_f.affiche_F(stmt);
			AdresseA_l.affiche_L(stmt);
			// erreur a cause des modifs de Mathieu
			clientA.add(stmt);
			clientB.add(stmt);
			clientA.affiche(stmt);
			commandeA.add(stmt);
			commandeA.affiche(stmt);
			formatA.add(stmt);
			formatA.affiche(stmt);
			albumA.add(stmt);
			albumA.affiche(stmt);
			//Peut en avoir à l'infinie, lignecommande n'as pas de clef primaire
			//lignecommandeA.add(stmt);
			//lignecommandeA.affiche(stmt);
			fichier.add(stmt);
			fichier.affiche(stmt);
			
			//DELETE
			System.out.println("DELETE");
			//Peut en avoir à l'infinie, lignecommande n'as pas de clef primaire
			//Comment supprimer un élément de cette table
			//lignecommandeA.delete(stmt);
			//lignecommandeA.affiche(stmt);
			commandeA.delete(stmt);
			commandeA.affiche(stmt);
			formatA.delete(stmt);
			formatA.affiche(stmt);
			albumA.delete(stmt);
			albumA.affiche(stmt);
			fichier.delete(stmt);
			fichier.affiche(stmt);
			clientA.delete(stmt);
			clientB.delete(stmt);
			clientA.affiche(stmt);
			AdresseA_f.delete_F(stmt);
			AdresseA_l.delete_L(stmt);
			AdresseA_f.affiche_F(stmt);
			AdresseA_l.affiche_L(stmt);
		}
		catch (Exception e) {
			System.out.println("echec driver : "+e);
		}
	}
}
