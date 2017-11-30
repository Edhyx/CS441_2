package fr.esisar.cs441.groupe2.controller;

import fr.esisar.cs441.groupe2.model.Model;
import fr.esisar.cs441.groupe2.view.View;

public class ControllerAddPhoto extends Controller{
	
	public ControllerAddPhoto(View view, Model model) {
		this.view = view;
		this.model = model;
	}
	
	public void notifyChangement(String changement) {
		
				// On extrait les informations
		int i = 0;
		String[] element = new String[6];
		
		if(changement.charAt(0) == '9') {
			view.displayEnd("");
		}else {
		
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

}
