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
		
		if(changement.charAt(0)=='9') {
			view.displayEnd("");
		}else {
			
			// On test tout les codes
			if(changement.substring(0,3).equals("NEW")) { // new Folder
				
				if(this.newFolder( changement.substring( changement.indexOf(" ")+1, changement.length()))) {
					view.displayAlbumMenu("nouvel album");
				}else {
					view.displayAlbumMenu("creation impossible");
				}
			}else if(changement.substring(0,3).equals("PRE")) { // new Folder
				
				view.displayAlbumManagement(model.getFolderList());
			}else if(changement.substring(0,3).equals("ADA")) { // affichage liste d'ajout
				
				view.displayAlbumADD(model.getFoldersFileList(changement.substring(changement.indexOf(" ")+1, changement.length())));
				
			}else if(changement.substring(0,3).equals("DEA")) { // on supprime un album
				
				if(model.delAlbum(changement.substring(changement.indexOf(" ")+1,changement.length()))) {
					view.displayAlbumManagement(model.getFolderList());	
				}else {
					
					view.displayAlbumMenu("Probleme");
				}
			}else if(changement.substring(0,3).equals("ADF")) { // on ajoute une image à un album
				
				if(model.delAlbum(changement.substring(changement.indexOf(" ")+1,changement.length()))) {
					view.displayAlbumManagement(model.getFolderList());	
				}else {
					
					view.displayAlbumMenu("Probleme");
				}
			}
		}
	}
	
	private boolean newFolder(String data) {
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
			
			return model.addFolder(element[0], element[1]);		
		}catch(StringIndexOutOfBoundsException e) {
			view.displayAddPhoto("probleme saisie");
			return false;
		}
	}
}
