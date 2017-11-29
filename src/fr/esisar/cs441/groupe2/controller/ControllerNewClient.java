package fr.esisar.cs441.groupe2.controller;

import fr.esisar.cs441.groupe2.model.Model;
import fr.esisar.cs441.groupe2.view.View;

/**
 * Created by maximefelici on 29/11/2017.
 */
public class ControllerNewClient extends Controller{

	public ControllerNewClient(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	
	public void notifyChangement(String changement) {
		
		String[] element = new String[4];
		int i = 0;
		
		while(changement.length()>0 & i<4) {
			System.out.println(changement);
			if(i<3) {
				element[i] = changement.substring(0, changement.indexOf(" "));
			}else {
				element[i] = changement.substring(0, changement.length());
			}
			changement = changement.substring(0,changement.indexOf(" ")+1);	
			i++;
		}
		
		if(i==4) {
			boolean result = model.createClient(element[0], element[1], element[2], element[3]);
			if(result) {
				view.displayMenu(new String("Bienvenu " + element[1] + " " + element[2]));	
			}
			
		}else {
			view.displayNewClient("erreur");
		}
		

	}
}
