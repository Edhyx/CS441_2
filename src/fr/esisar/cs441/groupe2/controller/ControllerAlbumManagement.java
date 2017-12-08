package fr.esisar.cs441.groupe2.controller;

import java.util.ArrayList;

import fr.esisar.cs441.groupe2.model.Model;
import fr.esisar.cs441.groupe2.view.View;

public class ControllerAlbumManagement extends Controller {

	private String albumId;
	private String log;
	
	public ControllerAlbumManagement(View view, Model model) {
		this.view = view;
		this.model = model;
	}
	
	public void notifyChangement(String changement) {
		
		if(changement.charAt(0)=='9') { //quitter l'application
			view.displayEnd("");
		}else if (changement.charAt(0) == '8') { //retourner au menu principal
			view.displayMenu("");
		}
		else {
			
			// On test tout les codes possibles envoyés par view
			if(changement.substring(0,3).equals("NEW")) { // création nouvel album
				
				if(this.newFolder( changement.substring( changement.indexOf(" ")+1, changement.length()))) {
					view.displayAlbumMenu("nouvel album");
				}else {
					view.displayAlbumMenu("creation impossible");
				}
			}else if(changement.substring(0,3).equals("PRE")) { // consulter les albums
				
				view.displayAlbumManagement(model.getFolderList());
			
			}else if(changement.substring(0,3).equals("ADA")) { // affichage liste d'albums
				
				ArrayList<String> returns = model.getAllFilesWithNoFolder(changement.substring(changement.indexOf(" ")+1, changement.length()));
				
				if(returns == null) {
					view.displayAlbumManagement(model.getFolderList());
				}else if(returns.isEmpty()) {
					returns.add("\tPas d'image sans albums");
					view.displayAlbumADD(returns);	
				}else {
					view.displayAlbumADD(returns);	
				}
				
			}else if(changement.substring(0,3).equals("DEA")) { // suppression d'un album
				
				if(model.delFolder(Integer.parseInt(changement.substring(changement.indexOf(" ")+1,changement.length())))) {
					view.displayAlbumManagement(model.getFolderList());	
				}else {
					
					view.displayAlbumMenu("Probleme");
				}
			}else if(changement.substring(0,3).equals("ADF")) { // ajout d'une image à un album
				
				if(addFileToFolder(changement.substring(changement.indexOf(" ")+1,changement.length()))){
				}
				
				ArrayList<String> returns = model.getAllFilesWithNoFolder();
				
				if(returns == null) {
					view.displayAlbumManagement(model.getFolderList());
				}else if(returns.isEmpty()) {
					returns.add("\tPas d'image sans albums");
					view.displayAlbumADD(returns);	
				}else {
					view.displayAlbumADD(returns);	
				}
			}
		}
	}
	
	private boolean newFolder(String data) { // méthode utilisée pour la création d'un album
		try {
			
			String[] element = new String[2];
			int i=0;
						
			while(data.length()>0 & i<2) {

				if(i<1) {
					element[i] = data.substring(0, data.indexOf(" "));
				}else {
					element[i] = data.substring(0, data.length());
				}
				data = data.substring(data.indexOf(" ")+1, data.length());	
				i++;
			}
			
			if(i==2) {
				return model.addFolder(element[0], element[1]);	
			}else {
				return false;
			}
				
		}catch(StringIndexOutOfBoundsException e) {
			view.displayAddPhoto("probleme saisie");
			return false;
		}
	}
	
	private boolean addFileToFolder( String str) { // méthode utilisée pour l'ajout d'une photo à l'album
		
		String[] element = new String[4];
		
		int i=0;
		
		try {
			while(str.length()>0 & i<4) {
				
				if(i<3) {
					element[i] = str.substring(0, str.indexOf(" "));
				}else {
					element[i] = str.substring(0, str.length());
				}
				str = str.substring(str.indexOf(" ")+1, str.length());	
				i++;
			}
			
			if(i==4) {
				
				return model.addFileToFolder(element[0],
											 Integer.parseInt(element[1]),
											 element[2], 
											 element[3]);
				
			}else {
				return false;
			}
		}catch(StringIndexOutOfBoundsException e) {
			return false;
		}
	}
}
