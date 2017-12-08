package fr.esisar.cs441.groupe2.controller;

import fr.esisar.cs441.groupe2.model.Model;
import fr.esisar.cs441.groupe2.view.View;

public class ControllerNewClient extends Controller { // creation d'un nouveau
														// client

	public ControllerNewClient(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	public void notifyChangement(String changement) {
		String[] element = new String[10];
		int i = 0;
		try {
			while (changement.length() > 0 & i < 10) { // recuperations des
														// infos nouveau client
				if (i < 9) {
					element[i] = changement.substring(0, changement.indexOf(" "));
				} else {
					element[i] = changement.substring(0, changement.length());
				}
				changement = changement.substring(changement.indexOf(" ") + 1, changement.length());
				i++;
			}
			if (i == 10) {
				// creation du nouveau client
				boolean result = model.createClient(element[0], element[1], element[2], element[3], element[4],
						element[5], element[6], element[7], element[8], element[9]);
				if (result) {
					// On met a jour le model dans l'objet de type View
					model.setClient(element[0]);
					view.setModel(model);
					view.displayMenu(new String("Bienvenue " + element[1] + " " + element[2]));
				} else {
					view.displayNewClient("impossible de creer le client");
				}
			} else {
				view.displayNewClient("erreur");
			}
		} catch (StringIndexOutOfBoundsException e) {
			view.displayNewClient("probleme saisie");
		}
	}
}
