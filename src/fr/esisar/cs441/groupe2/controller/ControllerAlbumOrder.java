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
			if(changement.substring(0,3).equals("NEW")) { // new Folder
				view.displayOrderADD(model.getFolderList());	
			}	
			view.displayAddOrder("renseignements enregistres");
		}/**********************************************************/
	}
	
	private boolean newOrder(String data) {
		try {

			/*String[] element = new String[2];
			int i = 0;

			while (data.length() > 0 & i < 2) {

				if (i < 1) {
					element[i] = data.substring(0, data.indexOf(" "));
				} else {
					element[i] = data.substring(0, data.length());
				}
				data = data.substring(data.indexOf(" ") + 1, data.length());
				i++;*/
			}

			return model.addFolder(element[0], element[1]);
		} catch (StringIndexOutOfBoundsException e) {
			/*view.displayAddOrder("probleme saisie");*/
			return false;
		}
	}
}
