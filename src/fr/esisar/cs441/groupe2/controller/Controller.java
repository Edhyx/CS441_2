package fr.esisar.cs441.groupe2.controller;

import fr.esisar.cs441.groupe2.model.Model;
import fr.esisar.cs441.groupe2.view.View;

//superclass des controllers, connecte view et modele.
public class Controller {
	protected View view;
	protected Model model;
	
	public void notifyChangement(String changement) {
	}
}
