package fr.esisar.cs441.groupe2.controller;

import fr.esisar.cs441.groupe2.model.Model;
import fr.esisar.cs441.groupe2.view.View;

public class ControllerAlbumManagement extends Controller {

	private String albumId;
	private String log;
	
	public ControllerAlbumManagement(View view, Model model) {
		this.view = view;
		this.model = model;
	}
	
	public void notifChangement(String changement) {
		
		if(changement.charAt(0) == '9') {
			view.displayEnd("");
		}else {
			
			// On test tout les codes
			if(changement.substring(0,3).equals("NEWW")) { // new Folder
				if(this.newFolder( changement.substring( changement.indexOf(" "), changement.length()))) {
					view.displayAlbumMenu("nouvelle album");
				}
			}else if(changement.substring(0,3).equals("PREA")) { // new Folder
				view.displayAlbumMenu(model.getFolderList());
			}
			try {
				
				// detection du type de telechargement
				int number = Integer.parseInt(changement.substring(0, changement.indexOf(" ")));
				changement = changement.substring( changement.indexOf(" ")+1, changement.length());
							
				while(changement.length()>0 & i<6) {
	
					if(i<5) {
						element[i] = changement.substring(0, changement.indexOf(" "));
					}else {
						element[i] = changement.substring(0, changement.length());
					}
					changement = changement.substring(changement.indexOf(" ")+1, changement.length());	
					i++;
				}
	
				if(i==6) {
					for(int j=0; j<number; j++) {
						while(!model.addFile(element[0], element[1], element[2], element[3], element[4], element[5]));
					}		
				}
			}catch(StringIndexOutOfBoundsException e) {
				view.displayAddPhoto("probleme saisie");
			}catch (NumberFormatException e) {
				view.displayAddPhoto("probleme nombre de photos");
			}
			
			view.displayAddPhoto("renseignements enregistres");
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
