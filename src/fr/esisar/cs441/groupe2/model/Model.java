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
	private int idAlbum;
	private int idCommand;
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
		this.idAlbum = 0;
		this.idClient = null;
	}

	public void setClient(String id) {
		this.idClient = id;
	}
	
	public void setAlbum(int id) {
		this.idAlbum = id;
	}
	
	public void setCommand(int id) {
		this.idCommand = id;
	}

	public String getClientPassword(String id) {
		ClientDAO tableClient = new ClientDAO(stmt);
		Client client = tableClient.getById(id);
		if (client == null) {
			return null;
		} else
			return client.getPassword();

	}

	/* Methode permettant de creer un client dans la base
	 * ainsi que les deux adresses associes
	 */
	public boolean createClient(String adresseMail, String nom, String prenom, String password, String rueL, String codeL, String villeL, String rueF, String codeF, String villeF) {
		
		AdresseDAO tableAdresse = new AdresseDAO(stmt);
		
		Integer idF = new Integer(ThreadLocalRandom.current().nextInt(0, 1000 + 1));
		while(tableAdresse.getById_F(idF) != null) {} // on verifie que l'id n'existe pas deja
		
		// creation de l'adresse dans la table d'adresse
		Adresse adresseF = new Adresse(idF, rueF, codeF, villeF);
		
		Integer idL = new Integer(ThreadLocalRandom.current().nextInt(0, 1000 + 1));
		while(tableAdresse.getById_L(idL) != null) {} // on verifie que l'id n'existe pas deja
		
		Adresse adresseL = new Adresse(idL, rueL, codeL, villeL);
		
		if(tableAdresse.add_F(adresseF) & tableAdresse.add_L(adresseL)) {
			// creation des addresses reussi
			Client newClient = new Client(adresseMail, nom, prenom, password, adresseF, adresseL);
			ClientDAO tableClient = new ClientDAO(stmt);
			
			if(tableClient.add(newClient)) {
				System.out.println("oui");
				return true;
			}
		}
		
		return false;

	}

	public boolean addFile(String appareilPhoto, String objectif, int distance, int sensibilte,
			int ouverture, int vitesse) {

		String url = new String("" + ThreadLocalRandom.current().nextInt(0, 1000 + 1));
		
		ClientDAO tableClient = new ClientDAO(stmt);
		Client client = tableClient.getById(idClient);
		
		FichierImage fichierIm = new FichierImage(url, appareilPhoto, objectif, distance, sensibilte, ouverture,
				vitesse, client);
		FichierImageDAO tableFichierIm = new FichierImageDAO(stmt);
		
		if (client==null) {return false;}
		else{
			
			if(tableFichierIm.add(fichierIm)) {
				return true;
			}
			
			return false;
		}
	}

	public boolean addFolder( String titre, String sousTitre) {

		Integer id = new Integer(ThreadLocalRandom.current().nextInt(0, 1000 + 1));
		ClientDAO tableClient = new ClientDAO(stmt);
		Client client = tableClient.getById(idClient);
		Album album = new Album(id, titre, sousTitre, client);
		AlbumDAO tableAlbum = new AlbumDAO(stmt);
		if (client==null) {return false;}
		else{
			if(tableAlbum.add(album)) {
				return true;
			}
		}
		
		return false;
	}

	public ArrayList<String> getFolderList() {

		ArrayList<String> returns = new ArrayList<String>();
		
		ArrayList<Album> album = new ArrayList<Album>();
		AlbumDAO tableAlbum = new AlbumDAO(stmt);
		album = tableAlbum.getAllById(idClient);

		for (Album al : album) {
			returns.add(al.toString());
		}
		return returns;
	}
	
	public ArrayList<String> getAllFilesWithNoFolder(String idFolder) {
		
		FichierImageDAO tableFichier = new FichierImageDAO(stmt);
		AlbumDAO tableAlbum = new AlbumDAO(stmt);
		ContientDAO tableContient = new ContientDAO(stmt);
		
		// On verifie si l'Album existe
		if(tableAlbum.getById(Integer.parseInt(idFolder)) != null) {
			
			this.setAlbum(Integer.parseInt(idFolder));
			
			ArrayList<FichierImage> pictures = tableFichier.getAll();
			ArrayList<Contient> folders = tableContient.getAll();
			ArrayList<String> picturesWithNoFolder = new ArrayList<String>();
			
			boolean find;
			
			for( FichierImage picture : pictures) {
				
				find = false;
				
				for( Contient folder : folders) {
					
					//On test si l'image ne fait pas deja partie d'un album
					if(folder.getFichierImages().getCheminAcces().equals(picture.getCheminAcces())) {
						find = true;
					}
				}
				
				if(!find) {
					picturesWithNoFolder.add(picture.toString());	
				}
			}
			
			return picturesWithNoFolder;
			
		}else {
			// on retourne null si probleme
			return null;
		}
		
	}
		
	public ArrayList<String> getAllFilesWithNoFolder() {
		
		FichierImageDAO tableFichier = new FichierImageDAO(stmt);
		AlbumDAO tableAlbum = new AlbumDAO(stmt);
		ContientDAO tableContient = new ContientDAO(stmt);
		
		// On verifie si l'Album existe
		if(tableAlbum.getById(idAlbum) != null) {
						
			ArrayList<FichierImage> pictures = tableFichier.getAll();
			ArrayList<Contient> folders = tableContient.getAll();
			ArrayList<String> picturesWithNoFolder = new ArrayList<String>();
			
			boolean find;
			
			for( FichierImage picture : pictures) {
				
				find = false;
				
				for( Contient folder : folders) {					
					//On test si l'image ne fait pas deja partie d'un album
					if(folder.getFichierImages().getCheminAcces().equals(picture.getCheminAcces())) {
						find = true;
					}
				}
				
				if(!find) {
					picturesWithNoFolder.add(picture.toString());	
				}
			}
			
			return picturesWithNoFolder;
			
		}else {
			// on retourne null si probleme
			return null;
		}
		
	}
	
	public boolean delFolder(int idAlbumDel) {
		
		AlbumDAO tableAlbum = new AlbumDAO(stmt);
		
		Album album = tableAlbum.getById(idAlbumDel);
		if (album==null){return false;}
		else  {
			
			if(this.delFolderFileLink(idAlbumDel) 
					& this.delFolderOrderLineLink(idAlbumDel)
					& tableAlbum.delete(album)) {
				return true;
			}
			
			return false;			
		}
	}
	
	public boolean delFolderFileLink(int idAlbumDel) {
		
		ContientDAO tableContient = new ContientDAO(stmt);
		
		ArrayList<Contient> listContient = tableContient.getAll();
		
		for( Contient contient : listContient) {
			if(contient.getAlbum().getIdAlbum() == idAlbumDel) {
				if(!tableContient.delete(contient)) {
					return false;
				}
			}
		}
		
		return true;
		
	}
	
	public boolean delFolderOrderLineLink(int idAlbumDel) {
		
		LigneCommandeDAO tableCommande = new LigneCommandeDAO(stmt);
		
		ArrayList<LigneCommande> listCommande = tableCommande.getAll();
		
		for( LigneCommande contient : listCommande) {
			if(contient.getAlbum().getIdAlbum() == idAlbumDel) {
				if(!tableCommande.delete(contient)) {
					return false;
				}
			}
		}
		
		return true;
		
	}
	
	//j'ai changé le type de fichierImage en Liste de fichierImage au lieux de contient 
	public boolean addFileToFolder(String idFile, int numOrdre, String titre, String commentaire){
		
		AlbumDAO tableAlbum = new AlbumDAO(stmt);
		Album album = tableAlbum.getById(idAlbum);
		
		FichierImageDAO tableFI = new FichierImageDAO(stmt);
		
		// On test si le fichier est trouve
		if(tableFI.getById(idFile) != null) {
			ContientDAO tableContient = new ContientDAO(stmt);
			Contient contientNew = new Contient(numOrdre, titre, commentaire, tableFI.getById(idFile), album);
		
			return tableContient.add(contientNew);
			
		}

		return true;
	}
	
	public boolean addOrder(int idAlbumAdd, String date, int prixTotal, int quantite){
		
		Integer id = new Integer(ThreadLocalRandom.current().nextInt(0, 1000 + 1));
		
		ClientDAO tableClient = new ClientDAO(stmt);
		Client client = tableClient.getById(this.idClient);
		
		Commande commande = new Commande(id,date,prixTotal,client);
		CommandeDAO tableCommande = new CommandeDAO(stmt);
		
		if (client==null) {return false;}
		else{
			
			if(tableCommande.add(commande)) {
				
				/* on determine le prix unitaire
				 * en comptant le nombre de photos
				 * 
				 * On met a jour la table Format
				 */
				ContientDAO tableContient = new ContientDAO(stmt);
				ArrayList<Contient> contients = tableContient.getAll();
				int nombreFile = 0;
				
				for( Contient contient : contients) {
					if(contient.getAlbum().getIdAlbum() == idAlbumAdd) {
						nombreFile++;
					}
				}
				
				Format format = new Format(id, prixTotal/nombreFile);
				FormatDAO tableFormat = new FormatDAO(stmt);
				
				if( tableFormat.add(format) ) {
					
					AlbumDAO tableAlbum = new AlbumDAO(stmt);
					
					if(tableAlbum.getById(idAlbumAdd) != null) {
						
						/* On met a jour la table LigneCommande */
						LigneCommandeDAO tableLigneCommande = new LigneCommandeDAO(stmt);
						LigneCommande ligneCommande = new LigneCommande(quantite, 
																		commande, 
																		format, 
																		tableAlbum.getById(idAlbumAdd));
						if(tableLigneCommande.add(ligneCommande)) {
							
							return true;
						}
					}
				}
			}
			
			return false;
		}
	}
	
public boolean addLine(int idAlbumAdd, int prixTotal, int quantite){
		
		Integer id = new Integer(ThreadLocalRandom.current().nextInt(0, 1000 + 1));
		
		ClientDAO tableClient = new ClientDAO(stmt);
		Client client = tableClient.getById(this.idClient);
		
		try {
			
			if (client==null) {return false;}
			else{
			
					
					/* on determine le prix unitaire
					 * en comptant le nombre de photos
					 * 
					 * On met a jour la table Format
					 */
					ContientDAO tableContient = new ContientDAO(stmt);
					ArrayList<Contient> contients = tableContient.getAll();
					int nombreFile = 0;
					
					for( Contient contient : contients) {
						if(contient.getAlbum().getIdAlbum() == idAlbumAdd) {
							nombreFile++;
						}
					}
					
					Format format = null;
					
					if(nombreFile!=0) {	 format = new Format(id, prixTotal/nombreFile); }
					else { 
						format = new Format(id, 0);
					}
					
					FormatDAO tableFormat = new FormatDAO(stmt);
					
					
					if( tableFormat.add(format) ) {
						
						AlbumDAO tableAlbum = new AlbumDAO(stmt);
						
						if(tableAlbum.getById(idAlbumAdd) != null) {
							
							/* On met a jour la table LigneCommande */
							LigneCommandeDAO tableLigneCommande = new LigneCommandeDAO(stmt);
							CommandeDAO tableCommande = new CommandeDAO(stmt);
							
							LigneCommande ligneCommande = new LigneCommande(quantite, 
																			tableCommande.getById(idCommand), 
																			format, 
																			tableAlbum.getById(idAlbumAdd));
							if(tableLigneCommande.add(ligneCommande)) {
								
								return true;
							}
						}
					}
			
				return false;
			}
		}catch(NullPointerException e) {
			return false;
		}
	}
	
	public boolean delCommand(int idCommande){
	
		CommandeDAO tableCommande = new CommandeDAO(stmt);
		
		Commande commande = tableCommande.getById(idCommande);
		if (commande==null){return false;}
		else  {
			
			if(this.delCommandOrderLineLink(idCommande)
					& tableCommande.delete(commande)) {
				return true;
			}
			
			return false;			
		}
	}
	
	public boolean delCommandOrderLineLink(int idCommand) {
		
		LigneCommandeDAO tableCommande = new LigneCommandeDAO(stmt);
		
		ArrayList<LigneCommande> listCommande = tableCommande.getAll();
		
		for( LigneCommande contient : listCommande) {
			if(contient.getCommande().getIdCommande() == idCommand) {
				if(!tableCommande.delete(contient)) {
					return false;
				}
			}
		}
		
		return true;
		
	}

	public ArrayList<String> getOrderList(){
		
		ArrayList<String> returns = new ArrayList<String>();
		ArrayList<Commande> commande = new ArrayList<Commande>();
		CommandeDAO tableCommande = new CommandeDAO(stmt);

		commande = tableCommande.getAllById(idClient);

		for (Commande co : commande) {
			returns.add(co.toString());
		}
		return returns;
	}

}