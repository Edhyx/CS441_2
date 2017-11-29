package fr.esisar.cs441.groupe2.controller;

import java.util.ArrayList;

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
		ArrayList<String> vide = new ArrayList<String>();
		
		switch(this.changement){
		case "1": view.displayAddPhoto(vide);
		case "2": view.displayAlbumManagement(vide);
		case "3": view.displayAlbumOrder(vide);
		case "4": view.displayOrderList(vide);
		case "9": view.displayEnd(null);
		}
	}

}
