/*
Projet CS441 - Mini projet de developpement d'une application de gestion de tirages
photos numériques
Equipe 2

Gestion de l'affichage en ligne de commandes
 */

package fr.esisar.cs441.groupe2.view;

import fr.esisar.cs441.groupe2.controller.ControllerConnection;
import fr.esisar.cs441.groupe2.controller.ControllerMenu;
import fr.esisar.cs441.groupe2.model.Model;

import java.util.ArrayList;
import java.util.Scanner;





public class View {
	private controller control;
	private Model model;

	public View(Model model){
		this.model = model;
	}

	public void displayInit(){
		control = new ControllerInit(this,model);
		System.out.println("--- --- Bienvenue sur Esyphoto --- ---");
		System.out.println("Nouveau client : tapez 1");
		System.out.println("Connexion : tapez 2");
		System.out.println("Sortir : tapez 9");
		Scanner sc = new Scanner(System.in);
		control.notifyChangement(sc.next());		//Scan et envoi dans controler

	}

	public void displayNewClient(){
		control = new ControllerNewClient;
		System.out.println("--- --- Bienvenue --- ---");
		System.out.println("Veuillez entrer une adresse mail : ");
		Scanner address = new Scanner(System.in);
		System.out.println("Veuillez entrer un nom : ");
		Scanner name = new Scanner(System.in);
		System.out.println("Veuillez entrer un prénom : ");
		Scanner surname = new Scanner(System.in);
		System.out.println("Veuillez entrer un password : ");
		Scanner passwd = new Scanner(System.in);
		String sc = address + " " + name + " " + surname + " " + passwd; //Concaténation
		control.notifyChangement(sc.next());		//Scan et envoi dans controler
	}

	public void displayConnection(ArrayList<String> str){
		control = new ControllerConnection;
		if(!str.isEmpty()){
			System.out.println(str);
		}
		System.out.println("--- --- Bienvenue --- ---");
		System.out.print("Tapez 0 pour quitter");
		System.out.print("Tapez adresse_mail mot_de_passe pour vous identifier");
		System.out.print(">>");
		Scanner sc = new Scanner(System.in);
		control.notifyChangement(sc.next());	//Scan et envoi dans controler.
	}

	public void displayMenu(ArrayList<String> str){
		control = new ControllerMenu;
		if(!str.isEmpty()){
			System.out.println(str);
		}
		System.out.println("--- --- MENU --- ---");
		System.out.println("Ajouter des photos : tapez 1");
		System.out.println(" : tapez 1");
		System.out.println("Nouveau client : tapez 1");
		System.out.println("Nouveau client : tapez 1");
		System.out.println("Nouveau client : tapez 1");

	}

	public void displayAddPhoto(ArrayList<String> str){
		control = new ControllerAddPhoto;
		if(!str.isEmpty()){
			System.out.println(str);
		}
		System.out.println("--- --- AJOUTER DES PHOTOS --- ---");
		Scanner sc = new Scanner(System.in);
		control.notifyChangement(sc.next());

	}
	
	public void displayAlbumManagement(ArrayList<String> str){
		control = new ControllerAlbumManagement;
		if(!str.isEmpty()){
			System.out.println(str);
		}
		System.out.println("--- --- GESTION DES ALBUMS --- ---");
		Scanner sc = new Scanner(System.in);
		control.notifyChangement(sc.next());
	}
	
	public void displayAlbumOrder(ArrayList<String> str){
		control = new ControllerAlbumOrder;
		if(!str.isEmpty()){
			System.out.println(str);
		}
		System.out.println("--- --- COMMANDER UN ALBUM --- ---");
		Scanner sc = new Scanner(System.in);
		control.notifyChangement(sc.next());
	}

	public void displayOrderList(ArrayList<String> str){
		control = new ControllerOrderList;
		if(!str.isEmpty()){
			System.out.println(str);
		}
		System.out.println("--- --- LISTE DES COMMANDES --- ---");
		Scanner sc = new Scanner(System.in);
		control.notifyChangement(sc.next());
	}

	public void displayEnd(ArrayList<String> str){
		control = new ControllerEnd;
		if(!str.isEmpty()){
			System.out.println(str);
		}
		System.out.println("--- --- FIN DU PROGRAMME --- ---");
		Scanner sc = new Scanner(System.in);
		control.notifyChangement(sc.next());
	}

	
}
