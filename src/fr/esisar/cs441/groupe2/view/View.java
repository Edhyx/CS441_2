/*
Projet CS441 - Mini projet de developpement d'une application de gestion de tirages
photos numériques
Equipe 2

Gestion de l'affichage en ligne de commandes
 */

package fr.esisar.cs441.groupe2.view;


import java.util.ArrayList;
import java.util.Scanner;



public class View {
	controller control;

	public void displayInit(){
		control = new controlInit;
		System.out.println("--- --- Bienvenue sur Esyphoto --- ---");
		System.out.println("Nouveau client : tapez 1");
		System.out.println("Connexion : tapez 2");
		System.out.println("Sortir : tapez 9");
		Scanner sc = new Scanner(System.in);
		control.notify(sc.next());
	}

	public void displayNewClient(ArrayList<String> str){
		control = new controlNewClient;
		if(!str.isEmpty()){
			System.out.println(str);
		}
		System.out.println("--- --- Bienvenue --- ---");
		System.out.println("Veuillez entrer une adresse mail : ");
		Scanner sc = new Scanner(System.in);
		control.Connection.notify(sc.next());		//Scan et envoi dans controler
		System.out.println("Veuillez entrer un nom : ");
		Scanner sc = new Scanner(System.in);
		controler.Connection.notify(sc.next());		//Scan et envoi dans controler
		System.out.println("Veuillez entrer un prénom : ");
		Scanner sc = new Scanner(System.in);
		controler.Connection.notify(sc.next());		//Scan et envoi dans controler
		System.out.println("Veuillez entrer un password : ");
		Scanner sc = new Scanner(System.in);
		controler.Connection.notify(sc.next());		//Scan et envoi dans controler
	}

	public void displayConnection(ArrayList<String> str){
		control = new controlClient;
		if(!str.isEmpty()){
			System.out.println(str);
		}
		System.out.println("--- --- Bienvenue --- ---");
		System.out.print("Veuillez entrer votre identifiant (adresse mail) : ");
		Scanner sc = new Scanner(System.in);
		controler.Connection.notify(sc.next());		//Scan et envoi dans controler.
		System.out.print("Veuillez entrer votre mot de passe : ");
		Scanner sc = new Scanner(System.in);
		controler.Connection.notify(sc.next());		//Scan et envoi dans controler.
	}

	public void displayAddPhoto(ArrayList<String> str){
		if(!str.isEmpty()){
			System.out.println(str);
		}
		System.out.println("--- --- AJOUTER DES PHOTOS --- ---");
		Scanner sc = new Scanner(System.in);
		controler.Connection.notify(sc.next());

	}
	
	public void displayAlbumManagement(ArrayList<String> str){
		if(!str.isEmpty()){
			System.out.println(str);
		}
		System.out.println("--- --- GESTION DES ALBUMS --- ---");
		Scanner sc = new Scanner(System.in);
		controler.Connection.notify(sc.next());
	}
	
	public void displayAlbumOrder(ArrayList<String> str){
		if(!str.isEmpty()){
			System.out.println(str);
		}
		System.out.println("--- --- COMMANDER UN ALBUM --- ---");
		Scanner sc = new Scanner(System.in);
		controler.Connection.notify(sc.next());
	}

	public void displayOrderList(ArrayList<String> str){
		if(!str.isEmpty()){
			System.out.println(str);
		}
		System.out.println("--- --- LISTE DES COMMANDES --- ---");
		Scanner sc = new Scanner(System.in);
		controler.Connection.notify(sc.next());
	}

	public void displayEnd(ArrayList<String> str){
		if(!str.isEmpty()){
			System.out.println(str);
		}
		System.out.println("--- --- FIN DU PROGRAMME --- ---");
		Scanner sc = new Scanner(System.in);
		controler.Connection.notify(sc.next());

	}
	
	public int choice() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
}
