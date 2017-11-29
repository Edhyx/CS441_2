package fr.esisar.cs441.groupe2.controller;

import fr.esisar.cs441.groupe2.model.Model;
import fr.esisar.cs441.groupe2.view.View;

/**
 * Created by maximefelici on 29/11/2017.
 */
public class ControllerNewClient extends Controller {
	public ControllerNewClient(View view, Model model) {
		this.view = view;
		this.model = model;
	}
	
	public void notifyChangement(String changement) {
		
		String[] element = new String[4];
		int i = 0;
		
		while(changement.length()>0 & i<4) {
			element[i] = changement.substring(0, changement.indexOf(" "));
			changement = changement.substring(0,changement.indexOf(" "));	
			i++;
		}
		
		if(i==4) {
			String result = model.createClient(element[0], element[1], element[2], element[3]);	
			
		}else {
			view.displayNewClient("erreur");
		}
		

	}
}
