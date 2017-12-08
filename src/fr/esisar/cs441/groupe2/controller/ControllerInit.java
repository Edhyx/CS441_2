package fr.esisar.cs441.groupe2.controller;

import fr.esisar.cs441.groupe2.model.Model;
import fr.esisar.cs441.groupe2.view.View;

public class ControllerInit extends Controller { 
	// permet l'initialisation de l'application et le
	// premier transfert vers les pages suivantes

	public ControllerInit(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	public void notifyChangement(String changement) { 	
		// choix du type de connexion (nouveau
		// client ou identification)
		if (changement.charAt(0) == '1') {
			view.displayNewClient("");
		} else if (changement.charAt(0) == '2') {
			view.displayConnection("");
		} else if (changement.charAt(0) == '9') {
			view.displayEnd("");
		} else {
			view.displayInit();
		}
	}
}
