package fr.esisar.cs441.groupe2.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.esisar.cs441.groupe2.model.Model;
import fr.esisar.cs441.groupe2.view.View;

public class ControllerAlbumOrder extends Controller {

	public ControllerAlbumOrder(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	public void notifyChangement(String changement) {
		try {
			if (changement.charAt(0) == '9') { // quitter l'application
				view.displayEnd("");
			} else if (changement.charAt(0) == '8') { 
				view.displayMenu("");
			} else {
				// On test tous les codes envoy�s par view
				if (changement.substring(0, 3).equals("NEW")) { 
					// nouvelle commande					
					view.displayOrderADD(model.getFolderList());
				} else if (changement.substring(0, 3).equals("ADC")) {					
					// ajout nouvelle commande
					if (newOrder(changement.substring(changement.indexOf(" ") + 1, changement.length()))) {
						view.displayOrderMenu("Nouvelle commande");
					} else {
						view.displayOrderADD(model.getFolderList());
					}
				} else if (changement.substring(0, 3).equals("SHC")) {					
					// affichage de la liste des commandes
					view.displayAlbumOrder(model.getOrderList());
				} else if (changement.substring(0, 3).equals("FFF")) {					
					// On propose la liste des albums
					if (Integer.parseInt(changement.substring(changement.indexOf(" ") + 1, changement.length())) > 0) {
						model.setCommand(Integer
								.parseInt(changement.substring(changement.indexOf(" ") + 1, changement.length())));
						view.displayOrderADDCommand(model.getFolderList());
					} else {
						view.displayOrderMenu("Probleme");
					}
				} else if (changement.substring(0, 3).equals("AFF")) { 					
					//permet de choisir l'album a commander
					if (model.addLine(
							Integer.parseInt(
									changement.substring(changement.indexOf(" ") + 1, changement.lastIndexOf(" "))),
							30, Integer.parseInt(
									changement.substring(changement.lastIndexOf(" ") + 1, changement.length())))) {
						view.displayOrderMenu("Nouvelle commande");
					} else {
						view.displayOrderMenu("Probleme");
					}
				} else if (changement.substring(0, 3).equals("DLC")) { // supprimer une commande
					if (model.delCommand(
							Integer.parseInt(changement.substring(changement.indexOf(" ") + 1, changement.length())))) {
						view.displayMenu("Commande supprimée");
					} else {
						view.displayMenu("Probleme");
					}
				} else {
					view.displayMenu("Probleme");
				}
			}
		} catch (StringIndexOutOfBoundsException e) {
			view.displayOrderMenu("Probleme saisie");
		} catch (NumberFormatException e) {
			view.displayOrderMenu("Probleme nombre");
		}
	}

	// methode utilisee pour la creation
	// d'une commande
	private boolean newOrder(String data) {
		try {
			String[] element = new String[2];
			int i = 0;
			while (data.length() > 0 & i < 2) {
				if (i < 1) {
					element[i] = data.substring(0, data.indexOf(" "));
				} else {
					element[i] = data.substring(0, data.length());
				}
				data = data.substring(data.indexOf(" ") + 1, data.length());
				i++;
			}
			if (i == 2) {
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				return model.addOrder(Integer.parseInt(element[0]), dateFormat.format(date), 30,
						Integer.parseInt(element[1]));
			} else {
				return false;
			}
		} catch (StringIndexOutOfBoundsException e) {
			return false;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
