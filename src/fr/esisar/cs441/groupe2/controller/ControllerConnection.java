package fr.esisar.cs441.groupe2.controller;

import java.util.ArrayList;

import fr.esisar.cs441.groupe2.model.Model;
import fr.esisar.cs441.groupe2.view.View;

public class ControllerConnection extends Controller{

	public ControllerConnection(View view, Model model) {
		this.view = view;
		this.model = model;
	}
	
	public void notifyChangement(String changement) {
		
		try {
			if(changement.length() == 1) {
				if(changement.charAt(0)=='9') { // Quitter l'application
					view.displayEnd("");
				}else {
					view.displayConnection(""); // connexion � l'application
				}
			}else { // On test l'identification de l'utilisateur
				
				String id = changement.substring(0,changement.indexOf(" "));
				String password = changement.substring(changement.indexOf(" ")+1,changement.length());
				String clientPassword;
				
				if((clientPassword = model.getClientPassword(id)) != null) {
					
					if(password.equals(clientPassword)) { // on v�rifie ID et MDP dans le mod�le
						model.setClient(id);
						view.setModel(model);
						view.displayMenu("");
					}else {
						
						view.displayConnection("Probleme : impossible de se connecter");
					}
				}else {
	
					view.displayConnection("Probleme : impossible de se connecter");
				}
			}
		}catch(StringIndexOutOfBoundsException e) {
			view.displayConnection("Probleme : saisie");
		}
		
	}

}
