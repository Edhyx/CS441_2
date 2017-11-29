/*
Projet CS441 - Mini projet de developpement d'une application de gestion de tirages
photos numériques
Equipe 2

Gestion de l'affichage en ligne de commandes

Auteur : Maxime FELICI
 */

package fr.esisar.cs441.groupe2.view;

import fr.esisar.cs441.groupe2.controller.*;
import fr.esisar.cs441.groupe2.model.*;
import java.util.ArrayList;
import java.util.Scanner;


public class View {
	private Controller control;
	private Model model;

	public View(Model model){
		this.model = model;
	}

	public void displayInit(){
		control = new ControllerInit(this, model);
		System.out.println("--- --- Bienvenue sur Esyphoto --- ---");
		System.out.println("Nouveau client : tapez 1");
		System.out.println("Connexion : tapez 2");
		System.out.println("Sortir : tapez 9");
		Scanner sc = new Scanner(System.in);
		control.notifyChangement(sc.nextLine());		//Scan et envoi dans controler

	}

	public void displayNewClient(){
		control = new ControllerNewClient(this, model);
		System.out.println("--- --- Bienvenue --- ---");
		System.out.println("Veuillez entrer une adresse mail : ");
		Scanner address = new Scanner(System.in);
		address.nextLine();
		System.out.println("Veuillez entrer un nom : ");
		Scanner name = new Scanner(System.in);
		name.nextLine();
		System.out.println("Veuillez entrer un prénom : ");
		Scanner surname = new Scanner(System.in);
		surname.nextLine();
		System.out.println("Veuillez entrer un password : ");
		Scanner passwd = new Scanner(System.in);
		passwd.nextLine();
		String sc = address + " " + name + " " + surname + " " + passwd; //Concaténation
		control.notifyChangement(sc);		//Envoi dans controler
	}

	public void displayConnection(ArrayList<String> str){
		control = new ControllerConnection(this, model);
		if(!str.isEmpty()){
			System.out.println(str);
		}
		System.out.println("--- --- Bienvenue --- ---");
		System.out.println("Tapez 0 pour quitter");
		System.out.println("Tapez adresse_mail mot_de_passe pour vous identifier");
		System.out.println(">>");
		Scanner sc = new Scanner(System.in);
		control.notifyChangement(sc.nextLine());	//Scan et envoi dans controler.
	}

	public void displayMenu(ArrayList<String> str){
		control = new ControllerMenu(this, model);
		if(!str.isEmpty()){
			System.out.println(str);
		}
		System.out.println("--- --- MENU --- ---");
		System.out.println("Ajouter des photos : tapez 1");
		System.out.println("Gérer les albums photo : tapez 2");
		System.out.println("Commander des albums : tapez 3");
		System.out.println("Lister les commandes en cours : tapez 4");
		System.out.println("Quitter : tapez 9");
		Scanner sc = new Scanner(System.in);
		control.notifyChangement(sc.nextLine());	//Scan et envoi dans controler.

	}

	public void displayAddPhoto(ArrayList<String> str){
		control = new ControllerAddPhoto(this, model);
		if(!str.isEmpty()){
			System.out.println(str);
		}
		System.out.println("--- --- AJOUTER DES PHOTOS --- ---");
		Scanner sc = new Scanner(System.in);
		control.notifyChangement(sc.nextLine());

	}
	
	public void displayAlbumManagement(ArrayList<String> str){
		control = new ControllerAlbumManagement(this, model);
		if(!str.isEmpty()){
			System.out.println(str);
		}
		System.out.println("--- --- GESTION DES ALBUMS --- ---");
		Scanner sc = new Scanner(System.in);
		control.notifyChangement(sc.nextLine());
	}
	
	public void displayAlbumOrder(ArrayList<String> str){
		control = new ControllerAlbumOrder(this, model);
		if(!str.isEmpty()){
			System.out.println(str);
		}
		System.out.println("--- --- COMMANDER UN ALBUM --- ---");
		Scanner sc = new Scanner(System.in);
		control.notifyChangement(sc.nextLine());
	}

	public void displayOrderList(ArrayList<String> str){
		control = new ControllerOrderList(this, model);
		if(!str.isEmpty()){
			System.out.println(str);
		}
		System.out.println("--- --- LISTE DES COMMANDES --- ---");
		Scanner sc = new Scanner(System.in);
		control.notifyChangement(sc.nextLine());
	}

	public void displayEnd(String str){
		if(!str.isEmpty()){
			System.out.println(str);
		}
		System.out.println("--- --- FIN DU PROGRAMME --- ---");
	}

	
}
