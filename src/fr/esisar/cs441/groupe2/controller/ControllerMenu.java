package fr.esisar.cs441.groupe2.controller;

import fr.esisar.cs441.groupe2.model.Model;
import fr.esisar.cs441.groupe2.view.View;

public class ControllerMenu extends Controller{

	private String changement;
	
	public ControllerMenu(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	public void notifyChangement(String changement) {
		this.changement=changement;
		
		switch(this.changement){
		case "": view.displayNewClient();
		case "": view.displayConnection(vide);
		case "": view.displayEnd(null);
		}
	}

}
