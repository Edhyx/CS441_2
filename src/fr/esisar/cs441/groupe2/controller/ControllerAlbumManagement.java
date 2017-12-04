package fr.esisar.cs441.groupe2.controller;

import java.util.ArrayList;

import fr.esisar.cs441.groupe2.model.Model;
import fr.esisar.cs441.groupe2.view.View;

public class ControllerAlbumManagement extends Controller {

	private String albumId;
	private String log;
	
	public ControllerAlbumManagement(View view, Model model) {
		this.view = view;
		this.model = model;
	}
	
	public void notifyChangement(String changement) {
		

	}
	
	private boolean newFolder(String data) {
		try {
			
			String[] element = new String[2];
			int i=0;
						
			while(data.length()>0 & i<2) {

				if(i<1) {
					element[i] = data.substring(0, data.indexOf(" "));
				}else {
					element[i] = data.substring(0, data.length());
				}
				data = data.substring(data.indexOf(" ")+1, data.length());	
				i++;
			}
			
			return model.addFolder(element[0], element[1]);		
		}catch(StringIndexOutOfBoundsException e) {
			view.displayAddPhoto("probleme saisie");
			return false;
		}
	}
}
