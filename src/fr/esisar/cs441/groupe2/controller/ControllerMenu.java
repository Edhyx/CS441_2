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

		if(changement.charAt(0)=='1') {
			view.displayAddPhoto(null);
		}else if(changement.charAt(0)=='2') {
			view.displayAlbumMenu("");
		}else if(changement.charAt(0)=='3') {
			view.displayOrderMenu("");
		}else if(changement.charAt(0)=='4') {
			view.displayOrderList(null);
		}else if(changement.charAt(0)=='9') {
			view.displayEnd("");
		}else {
			view.displayMenu("");
		}
	}

}
