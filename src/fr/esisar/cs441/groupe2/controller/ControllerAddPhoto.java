package fr.esisar.cs441.groupe2.controller;

import java.util.ArrayList;

import fr.esisar.cs441.groupe2.model.Model;
import fr.esisar.cs441.groupe2.view.View;

public class ControllerAddPhoto extends Controller{
	
	public ControllerAddPhoto(View view, Model model) {
		this.view = view;
		this.model = model;
	}
	
	public void notifychangement(String changement) {
		
		// detection du type de telechargement
		String choix = changement.substring(0, changement.indexOf(" "));
		changement = changement.substring( changement.indexOf(" ")+1, changement.length());
		
		// faire du traitement de string 
	}

}
