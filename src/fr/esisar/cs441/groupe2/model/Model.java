package fr.esisar.cs441.groupe2.model;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import fr.esisar.cs441.groupe2.base.entity.Client;

public class Model {

	private String idClient;
	
	public void setClient(String id) {
		this.idClient = id;
	}
	
	public String getClientPassword(String id) {
		if(id.equals("plop")) {
			return "123456";
		}
		return null;
	}
	
	public boolean createClient(String adresse, String nom, String prenom, String password) {
		Client newClient = new Client(adresse, nom, prenom, password, null, null);
		// completer
		return true;
	}
	
	public boolean addFile(String appareilPhoto, String objectif, String distance, String sensibilte, String ouverture, String vitesse) {
		
		String url = new String(""+ThreadLocalRandom.current().nextInt(0, 1000 + 1));
		
		// completer

		return true;
	}
	
	public boolean addFolder( String titre, String sousTitre) {
		
		String id = new String(""+ThreadLocalRandom.current().nextInt(0, 1000 + 1));
		
		// completer
		
		return true;
		
	}
	
	public ArrayList<String> getFolderList() {
		ArrayList<String> returns = new ArrayList<String>();
		
		returns.add("blabla");
		returns.add("poloplop");
		
		return returns;
	}
	
	public boolean delFolder(String id) {
		
		// A completer
		return true;
	}

	public ArrayList<String> getFoldersFileList(String substring) {
		
		ArrayList<String> returns = new ArrayList<String>();
		
		returns.add("photo1");
		returns.add("photo2");
		
		return returns;
		
	}

	public boolean delAlbum(String id) {
		
		// a completer
		
		return true;
	}
	
	
}
