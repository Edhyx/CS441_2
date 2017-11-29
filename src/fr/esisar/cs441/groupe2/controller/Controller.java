package fr.esisar.cs441.groupe2.controller;

import fr.esisar.cs441.groupe2.model.Model;

public abstract class Controller {
	private View view;
	private Model model;
	
	public abstract void notifychangement();
}
