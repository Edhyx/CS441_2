package fr.esisar.cs441.groupe2.controller;

import fr.esisar.cs441.groupe2.model.Model;
import fr.esisar.cs441.groupe2.view.View;

public class ControllerAddPhoto extends Controller{
	
	public ControllerAddPhoto(View view, Model model) {
		this.view = view;
		this.model = model;
	}
	
	public void notifyChangement(String changement) {		
		// On extrait les informations fournies par view
		int i = 0;
		String[] element = new String[6];
		boolean result = true;
		if (changement.charAt(0) == '9') { //quitter l'application
			view.displayEnd("");
		} else if(changement.charAt(0) == '8') { //retourner au menu principal
			view.displayMenu("");
		}
		else {		
			try {				
				//detection du type de telechargement
				int number = Integer.parseInt(changement.substring(0, changement.indexOf(" ")));
				changement = changement.substring( changement.indexOf(" ")+1, changement.length());
							
				while(changement.length()>0 & i<6) {	
					if(i<5) {
						element[i] = changement.substring(0, changement.indexOf(" "));
					} else {
						element[i] = changement.substring(0, changement.length());
					}
					changement = changement.substring(changement.indexOf(" ")+1, changement.length());	
					i++;
				}	
				if(i==6) {
					for(int j=0; j<number; j++) { //envoie des informations photos au modele
						if(!model.addFile(element[0],
											 element[1], 
											 Integer.parseInt(element[2]), 
											 Integer.parseInt(element[3]), 
											 Integer.parseInt(element[4]), 
											 Integer.parseInt(element[5]))) {
							view.displayAddPhoto("probleme saisie");
							result = false;
						}
					}		
				}
			}catch(StringIndexOutOfBoundsException e) {
				view.displayAddPhoto("probleme saisie");
			}catch (NumberFormatException e) {
				view.displayAddPhoto("probleme saisie");
			}			
			if(result) {
				view.displayAddPhoto("renseignements enregistres");
			}
		}
	}

}
