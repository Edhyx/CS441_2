/*
Projet CS441 - Mini projet de developpement d'une application de gestion de tirages
photos numériques
Equipe 2

Gestion de l'affichage en ligne de commandes
 */

package fr.esisar.cs441.groupe2.view;

import java.util.Scanner;



public class View {
	private controller control;


	public void displayInit(){
	
		System.out.println("--- --- Bienvenue sur Esyphoto --- ---");
		System.out.println("Nouveau client : tapez 1");
		System.out.println("Connexion : tapez 2");
		System.out.println("Sortir : tapez 9");

		Scanner sc = new Scanner(System.in);
		control.notifyChangement(sc.next());		//Scan et envoi dans controler

	}

	public void displayNewClient(){
		System.out.println("--- --- Bienvenue --- ---");
		System.out.println("Veuillez entrer une adresse mail : ");

		Scanner sc = new Scanner(System.in);
		control.notifyChangement(sc.next());		//Scan et envoi dans controler
		System.out.println("Veuillez entrer un nom : ");
		Scanner sc = new Scanner(System.in);
		control.notifyChangement(sc.next());		//Scan et envoi dans controler
		System.out.println("Veuillez entrer un prénom : ");
		Scanner sc = new Scanner(System.in);
		control.notifyChangement(sc.next());		//Scan et envoi dans controler
		System.out.println("Veuillez entrer un password : ");
		Scanner sc = new Scanner(System.in);
		control.notifyChangement(sc.next());		//Scan et envoi dans controler
	}

	public void displayConnection(ArrayList<String> str){
		control = new controlConnection;
		if(!str.isEmpty()){
			System.out.println(str);
		}
		System.out.println("--- --- Bienvenue --- ---");
		System.out.print("Veuillez entrer votre identifiant (adresse mail) : ");
		Scanner sc = new Scanner(System.in);
		control.notifyChangement(sc.next());	//Scan et envoi dans controler.
		System.out.print("Veuillez entrer votre mot de passe : ");
		Scanner sc = new Scanner(System.in);
		control.notifyChangement(sc.next());		//Scan et envoi dans controler.
	}

	public void displayAddPhoto(ArrayList<String> str){
		control = new controlAddPhoto;
		if(!str.isEmpty()){
			System.out.println(str);
		}
		System.out.println("--- --- AJOUTER DES PHOTOS --- ---");
		Scanner sc = new Scanner(System.in);
		control.notifyChangement(sc.next());

	}
	
	public void displayAlbumManagement(ArrayList<String> str){
		control = new controlAlbumManagement;
		if(!str.isEmpty()){
			System.out.println(str);
		}
		System.out.println("--- --- GESTION DES ALBUMS --- ---");
		Scanner sc = new Scanner(System.in);
		control.notifyChangement(sc.next());
	}
	
	public void displayAlbumOrder(ArrayList<String> str){
		control = new controlAlbumOrder;
		if(!str.isEmpty()){
			System.out.println(str);
		}
		System.out.println("--- --- COMMANDER UN ALBUM --- ---");
		Scanner sc = new Scanner(System.in);
		control.notifyChangement(sc.next());
	}

	public void displayOrderList(ArrayList<String> str){
		control = new controlOrderList;
		if(!str.isEmpty()){
			System.out.println(str);
		}
		System.out.println("--- --- LISTE DES COMMANDES --- ---");
		Scanner sc = new Scanner(System.in);
		control.notifyChangement(sc.next());
	}

	public void displayEnd(ArrayList<String> str){
		control = new controlEnd;
		if(!str.isEmpty()){
			System.out.println(str);
		}
		System.out.println("--- --- FIN DU PROGRAMME --- ---");
		Scanner sc = new Scanner(System.in);
		control.notifyChangement(sc.next());


		//Scan et envoi dans base
		System.out.println("Veuillez entrer un nom : ");
		//Scan et envoi dans base
		System.out.println("Veuillez entrer un prénom : ");
		//Scan et envoi dans base
		System.out.println("Veuillez entrer un password : ");
		//Scan et envoi dans base

	}

	public void displayClient(){
		System.out.println("--- --- Bienvenue --- ---");
		System.out.print("Veuillez entrer votre identifiant (adresse mail) : ");
		//Scan et envoi dans base. Check si vrai
		System.out.print("Veuillez entrer votre mot de passe : ");
		//Scan et envoi dans base. Check si vrai
	}

	public void displayAddPhoto(){
		System.out.println("--- --- AJOUTER DES PHOTOS --- ---");

	}
	
	public void displayAlbumManagement(){
		System.out.println("--- --- GESTION DES ALBUMS --- ---");
	}
	
	public void displayAlbumOrder(){
		System.out.println("--- --- COMMANDER UN ALBUM --- ---");
	}

	public void displayOrderList(){
		System.out.println("--- --- LISTE DES COMMANDES --- ---");

	}
	
}
