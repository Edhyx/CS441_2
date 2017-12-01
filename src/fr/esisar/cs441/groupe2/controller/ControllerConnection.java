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
		
		// on detecte si il s'agit d'une commande
		if(changement.length() == 1) {
			if(changement.charAt(0)=='9') {
				view.displayEnd("");
			}else {
				view.displayConnection(new ArrayList<String>());
			}
		}else { // On test l'identification
			
			String id = changement.substring(0,changement.indexOf(" "));
			String password = changement.substring(changement.indexOf(" ")+1,changement.length());
			String clientPassword;
			
			if((clientPassword = model.getClientPassword(id)) != null) {
				System.out.println(clientPassword);
				if(password.equals(clientPassword)) {
					model.setClient(id);
					view.setModel(model);
					view.displayMenu("");
				}else {
					ArrayList<String> retour = new ArrayList<String>();
					retour.add("Probleme : impossible de se connecter");
					view.displayConnection(retour);
				}
			}else {
			
				ArrayList<String> retour = new ArrayList<String>();
				retour.add("Probleme : impossible de se connecter");
				view.displayConnection(retour);
			}
		}
		
	}

}
