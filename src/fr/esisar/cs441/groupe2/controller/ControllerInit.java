package fr.esisar.cs441.groupe2.controller;

import java.util.ArrayList;

import fr.esisar.cs441.groupe2.model.Model;
import fr.esisar.cs441.groupe2.view.View;

public class ControllerInit extends Controller{

	public ControllerInit(View view, Model model) {
		this.view = view;
		this.model = model;
	}
	
	public void notifyChangement(String changement) {
		ArrayList<String> vide = new ArrayList<String>();
		
		switch(changement){
			case "1": view.displayNewClient();
			case "2": view.displayConnection(vide);
			case "9": view.displayEnd(null);
			}
		}	
	
}
