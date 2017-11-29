package fr.esisar.cs441.groupe2.controller;

import fr.esisar.cs441.groupe2.model.Model;
import fr.esisar.cs441.groupe2.view.View;

public class ControllerConnection extends Controller{

	public ControllerConnection(View view, Model model) {
		this.view = view;
		this.model = model;
	}
	
	public void notifychangement(String changement) {
		
		// on detecte si il s'agit d'une commande
		if(changement.length() == 1) {
			switch(changement) {
				case "0" : view.displayClose();
				break;
				default : view.displayClose();
			}
		}else { // On test l'identification
			String id = changement.substring(0,changement.indexOf(" ")-1);
			String password = changement.substring(changement.indexOf(" ")+1,changement.length());
			String clientPassword = model.
		}
		
	}

}
