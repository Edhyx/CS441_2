package fr.esisar.cs441.groupe2.controller;

import fr.esisar.cs441.groupe2.model.Model;
import fr.esisar.cs441.groupe2.view.View;


public class ControllerAlbumOrder extends Controller{
	
	public ControllerAlbumOrder(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	public void notifyChangement(String changement) {
		if(changement.charAt(0) == '9') {
			view.displayEnd("");
		}else {
			
			// On test tous les codes
			if(changement.substring(0,3).equals("NEW")) { // new order
				view.displayOrderADD(model.getFolderList());
				
			} else if(changement.substring(0,3).equals("ADC")) { // ajout nouvelle commande
				changement = "12/12/17 "+"30€ "+changement; //ajout des infos commande "random"
				if(newOrder(changement)){
					view.displayOrderMenu("");
				} else {
					view.displayAddOrder("problème ajout nouvelle commande");
				}
			} else if(changement.substring(0,3).equals("SHC")) { // affichage liste commandes
				view.displayOrderADD(model.getOrderList());
			}
		}/**********************************************************/
	}
	
	private boolean newOrder(String data) {
		try {

			String[] element = new String[3];
			int i = 0;

			while (i < 3) {

				if (i == 0) {
					element[i] = data.substring(0, 7);
				}else if (i == 1) {
					element[i] = data.substring(9, data.indexOf("€"));
				} else {
						element[i] = data.substring(data.indexOf("€")+6, data.length());
				}
				i++;
			}

			return model.addOrder(element[0], element[1], element[2]);
		} catch (StringIndexOutOfBoundsException e) {
			view.displayAddOrder("probleme saisie");
			return false;
		}
	}
}
