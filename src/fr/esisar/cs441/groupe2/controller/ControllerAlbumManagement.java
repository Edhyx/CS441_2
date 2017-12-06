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
			}else if(changement.substring(0,3).equals("PRE")) { // consulter les albums
				
				view.displayAlbumManagement(model.getFolderList());
			
			}else if(changement.substring(0,3).equals("ADA")) { // affichage liste d'ajout
				
				ArrayList<String> returns = model.getAllFilesWithNoFolder(changement.substring(changement.indexOf(" ")+1, changement.length()));
				
				if(returns == null) {
					view.displayAlbumManagement(model.getFolderList());
				}else if(returns.isEmpty()) {
					returns.add("\tPas d'image sans albums");
					view.displayAlbumADD(returns);	
				}else {
					view.displayAlbumADD(returns);	
				}
				
			}else if(changement.substring(0,3).equals("DEA")) { // on supprime un album
				
				if(model.delFolder(Integer.parseInt(changement.substring(changement.indexOf(" ")+1,changement.length())))) {
					view.displayAlbumManagement(model.getFolderList());	
				}else {
					
					view.displayAlbumMenu("Probleme");
				}
			}else if(changement.substring(0,3).equals("ADF")) { // on ajoute une image a un album
				
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
	
	private boolean addFileToFolder( String str) {
		
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
