package fr.esisar.cs441.groupe2.controller;

import fr.esisar.cs441.groupe2.model.Model;
import fr.esisar.cs441.groupe2.view.View;

public abstract class Controller {
	protected View view;
	protected Model model;
	
	public abstract void notifyChangement(String changement);
}
