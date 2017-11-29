package fr.esisar.cs441.groupe2.controller;

import java.util.ArrayList;

import fr.esisar.cs441.groupe2.model.Model;
import fr.esisar.cs441.groupe2.view.View;

public class ControllerMenu extends Controller{
	
	public ControllerMenu(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	public void notifyChangement(String changement) {

		ArrayList<String> vide = new ArrayList<String>();

		if(changement.charAt(0)=='1') {
			view.displayAddPhoto(vide);
		}else if(changement.charAt(0)=='2') {
			view.displayAlbumManagement(vide);
		}else if(changement.charAt(0)=='3') {
			view.displayAlbumOrder(vide);
		}else if(changement.charAt(0)=='4') {
			view.displayOrderList(vide);
		}else if(changement.charAt(0)=='9') {
			view.displayEnd("");
		}else {
			view.displayMenu("");
		}
	}

}
