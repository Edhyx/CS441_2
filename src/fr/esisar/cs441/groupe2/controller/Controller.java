package fr.esisar.cs441.groupe2.controller;

import fr.esisar.cs441.groupe2.model.Model;
import fr.esisar.cs441.groupe2.view.View;

public abstract class Controller {
	private View view;
	private Model model;
	
	public abstract void notifychangement();
}
