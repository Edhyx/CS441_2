package fr.esisar.cs441.groupe2.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.esisar.cs441.groupe2.model.Model;
import fr.esisar.cs441.groupe2.view.View;


public class ControllerAlbumOrder extends Controller{
	
	public ControllerAlbumOrder(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	public void notifyChangement(String changement) {
		
		try {
			if(changement.charAt(0) == '9') {
				view.displayEnd("");
			}else if (changement.charAt(0) == '8') {
				view.displayMenu("");
			}
			else {
				
				// On test tous les codes
				if(changement.substring(0,3).equals("NEW")) { // new order
					view.displayOrderADD(model.getFolderList());
					
				} else if(changement.substring(0,3).equals("ADC")) { // ajout nouvelle commande
					
					if(newOrder(changement.substring(changement.indexOf(" ")+1,changement.length()))){
						view.displayOrderMenu("Nouvelle commande");
					} else {
						view.displayOrderADD(model.getFolderList());
					}
				} else if(changement.substring(0,3).equals("SHC")) { // affichage liste commandes
					view.displayAlbumOrder(model.getOrderList());
					
				} else if(changement.substring(0,3).equals("ADC")) { // On propose la liste des albums
					
					if(Integer.parseInt(changement.substring(changement.indexOf(" "), changement.length())) >0) {
						model.setAlbum(Integer.parseInt(changement.substring(changement.indexOf(" "), changement.length())));
						view.displayOrderADD(model.getFolderList());
					}
					
				}
			}/**********************************************************/
		}catch(StringIndexOutOfBoundsException e) {
			view.displayOrderMenu("");
		}catch(NumberFormatException e){
			view.displayOrderMenu("");			
		}
	}
	
	private boolean newOrder(String data) {

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
			
			if(i==2) {
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
								
				return model.addOrder(Integer.parseInt(element[0]), 
									  dateFormat.format(date), 
									  30,
									  Integer.parseInt(element[1]));	
			}else {
				return false;
			}
				
		}catch(StringIndexOutOfBoundsException e) {
			return false;
		}catch(NumberFormatException e){
			return false;
			
		}
	}
}
