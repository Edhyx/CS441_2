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
		String server = "tp-oracle.esisar.grenoble-inp.fr";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@//" + server + "/xe";
		String login = "malossep";
		String pass = "malossep";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connexion = null;
		try {
			connexion = DriverManager.getConnection(url, login, pass);
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
		if (client == null) {
			return null;
		} else
			return client.getPassword();

	}

	private Adresse createAdressF(int idAdresseF, String rue, String codePostal, String ville) {
		Adresse newAdressF = new Adresse(idAdresseF, rue, codePostal, ville);
		AdresseDAO tableAdressF = new AdresseDAO(stmt);
		try {
			tableAdressF.add_F(newAdressF);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return newAdressF;
	}

	public Adresse createAdressL(int idAdresseL, String rue, String codePostal, String ville) {
		Adresse newAdressL = new Adresse(idAdresseL, rue, codePostal, ville);
		AdresseDAO tableAdressL = new AdresseDAO(stmt);
		try {
			tableAdressL.add_F(newAdressL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newAdressL;
	}

	public boolean createClient(String adresseMail, String nom, String prenom, String password) {
		Client newClient = new Client(adresseMail, nom, prenom, password, createAdressF(0, null, null, null),
				createAdressL(0, null, null, null));
		ClientDAO tableClient = new ClientDAO(stmt);
		try {
			tableClient.add(newClient);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean addFile(String idClient, String appareilPhoto, String objectif, int distance, int sensibilte,
			int ouverture, int vitesse) {

		String url = new String("" + ThreadLocalRandom.current().nextInt(0, 1000 + 1));
		ClientDAO tableClient = new ClientDAO(stmt);
		Client client = tableClient.getById(idClient);
		FichierImage fichierIm = new FichierImage(url, appareilPhoto, objectif, distance, sensibilte, ouverture,
				vitesse, client);
		FichierImageDAO tableFichierIm = new FichierImageDAO(stmt);
		if (client==null) {return false;}
		else{
			try {
				tableFichierIm.add(fichierIm);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return true;
			}
	}

	public boolean addFolder(String idClient, String titre, String sousTitre) {

		Integer id = new Integer(ThreadLocalRandom.current().nextInt(0, 1000 + 1));
		ClientDAO tableClient = new ClientDAO(stmt);
		Client client = tableClient.getById(idClient);
		Album album = new Album(id, titre, sousTitre, client);
		AlbumDAO tableAlbum = new AlbumDAO(stmt);
		if (client==null) {return false;}
		else{
			try {
				tableAlbum.add(album);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return true;
			}
	}

	public ArrayList<String> getFolderList() {

		ArrayList<String> returns = new ArrayList<String>();
		ArrayList<Album> album = new ArrayList<Album>();
		AlbumDAO tableAlbum = new AlbumDAO(stmt);
		album = tableAlbum.getAll();

		for (Album al : album) {
			returns.add(album.toString());
		}
		return returns;
	}
	public boolean delFolder(int idAlbum) {
		AlbumDAO tableAlbum = new AlbumDAO(stmt);
		try {
			Album album = tableAlbum.getById(idAlbum);
			if (album==null){return false;}
			else{
				tableAlbum.delete(album);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public boolean addOrder(String idClient, String date,int prixTotal){
		Integer id = new Integer(ThreadLocalRandom.current().nextInt(0, 1000 + 1));
		ClientDAO tableClient = new ClientDAO(stmt);
		Client client = tableClient.getById(idClient);
		Commande commande = new Commande(id,date,prixTotal,client);
		CommandeDAO tableCommande = new CommandeDAO(stmt);
		if (client==null) {return false;}
		else{
			try {
				tableCommande.add(commande);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return true;
			}
	}
	public ArrayList<String> getOrderList(){
		ArrayList<String> returns = new ArrayList<String>();
		ArrayList<Commande> commande = new ArrayList<Commande>();
		CommandeDAO tableCommande = new CommandeDAO(stmt);
		commande = tableCommande.getAll();

		for (Commande co : commande) {
			returns.add(commande.toString());
		}
		return returns;
	}
	//j'ai changé le type de fichierImage en Liste de fichierImage au lieux de contient 
	public boolean addFileToFolder(int idAlbum, String idFile){
		AlbumDAO tableAlbum = new AlbumDAO(stmt);
		try {
			Album album = tableAlbum.getById(idAlbum);
			ArrayList<FichierImage> fichierImages = new ArrayList<FichierImage>();
			FichierImageDAO tableFI = new FichierImageDAO(stmt);
			FichierImage fichier = tableFI.getById(idFile);
			fichierImages.add(fichier);
			album.setFichierImages(fichierImages);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

}
