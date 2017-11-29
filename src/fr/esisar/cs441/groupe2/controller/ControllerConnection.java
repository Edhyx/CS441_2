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
			
			}
		}
		
	}

}
