/*
Projet CS441 - Mini projet de developpement d'une application de gestion de tirages
photos numÃ©riques
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
	
	public void setModel(Model model) {
		this.model = model;
	}

	@SuppressWarnings("resource")
	public void displayInit(){
		control = new ControllerInit(this, model);
		System.out.println("--- --- Bienvenue sur Esyphoto --- ---");
		System.out.println("Nouveau client : tapez 1");
		System.out.println("Connexion : tapez 2");
		System.out.println("Sortir : tapez 9");
		Scanner sc = new Scanner(System.in);
		control.notifyChangement(sc.nextLine());		//Scan et envoi dans controler

	}

	@SuppressWarnings("resource")
	public void displayNewClient(String str){
		if(!str.isEmpty()){
			System.out.println(str);
		}
		control = new ControllerNewClient(this, model);
		System.out.println("--- --- Bienvenue --- ---");
		System.out.println("Veuillez entrer une adresse mail : ");
		
		Scanner sc = new Scanner(System.in);
		String client = sc.nextLine();
		String rue,code,ville;
		
		System.out.println("Veuillez entrer un nom : ");
		client = client + " " + sc.nextLine();
		System.out.println("Veuillez entrer un prÃ©nom : ");
		client = client + " " + sc.nextLine();
		System.out.println("Veuillez entrer un password : ");
		client = client + " " + sc.nextLine();
		
		System.out.println("Adresse de Livraison : Veuillez entrer la rue : ");
		rue = sc.nextLine();
		client = client + " " + rue;
		System.out.println("Adresse de Livraison : Veuillez entrer le code postal : ");
		code = sc.nextLine();
		client = client + " " + code;
		System.out.println("Adresse de Livraison : Veuillez entrer la ville : ");
		ville = sc.nextLine();
		client = client + " " + ville;
		
		System.out.println("Meme adresse de Facturation? (y/n)");
		if(sc.nextLine().charAt(0) == 'y') {
			client = client + " " + rue + " " + code + " " + ville;
		}else {
			System.out.println("Adresse de Livraison : Veuillez entrer la rue : ");
			rue = sc.nextLine();
			client = client + " " + rue;
			System.out.println("Adresse de Livraison : Veuillez entrer le code postal : ");
			code = sc.nextLine();
			client = client + " " + code;
			System.out.println("Adresse de Livraison : Veuillez entrer la ville : ");
			ville = sc.nextLine();
			client = client + " " + ville;
		}
		
		control.notifyChangement(client);		//Envoi dans controler
	}

	public void displayConnection(ArrayList<String> str){
		control = new ControllerConnection(this, model);
		if(!str.isEmpty()){
			System.out.println(str);
		}
		System.out.println("--- --- Bienvenue --- ---");
		System.out.println("Tapez 9 pour quitter");
		System.out.println("Tapez adresse_mail mot_de_passe pour vous identifier");
		System.out.print(">>");
		Scanner sc = new Scanner(System.in);
		control.notifyChangement(sc.nextLine());	//Scan et envoi dans controler.
	}

	public void displayMenu(String str){
		
		control = new ControllerMenu(this, model);
		if(!str.isEmpty()){
			System.out.println(str);
		}
		System.out.println("--- --- MENU --- ---");
		System.out.println("Ajouter des photos : tapez 1");
		System.out.println("GÃ©rer les albums photo : tapez 2");
		System.out.println("Commander des albums : tapez 3");
		System.out.println("Lister les commandes en cours : tapez 4");
		System.out.println("Quitter : tapez 9");
		Scanner sc = new Scanner(System.in);
		String choix = sc.nextLine();
		sc = null;
		control.notifyChangement(choix);	//Scan et envoi dans controler.

	}

	public void displayAddPhoto(String str){
		
		control = new ControllerAddPhoto(this, model);
		
		if(str!=null){
			System.out.println("["+str+"]");
		}
		
		System.out.println("--- --- AJOUTER DES PHOTOS --- ---");
		System.out.println("Ajouter une photo : taper 1");
		System.out.println("Ajouter un lot de photo : taper 2");
		System.out.println("Quitter : tapez 9");
		Scanner sc = new Scanner(System.in);
		
		String choix = sc.nextLine();
		
		String fichier;
		
		if(choix.charAt(0)=='1') {
			
			fichier = "1";
			
			System.out.println("Telechargement terminé.\nIl vous faut renseigner les informations suivantes :");
			System.out.print("L'appareil Photo : ");
			fichier = fichier + " " + sc.nextLine();
			System.out.print("L'objectif : ");
			fichier = fichier + " " + sc.nextLine();
			System.out.print("La distance Focale : ");
			fichier = fichier + " " + sc.nextLine();
			System.out.print("La sensibilité ISO : ");
			fichier = fichier + " " + sc.nextLine();
			System.out.print("L'ouverture : ");
			fichier = fichier + " " + sc.nextLine();
			System.out.print("La vitesse d'Obturation : ");
			fichier = fichier + " " + sc.nextLine();
			
			control.notifyChangement(fichier);
			
		}else if(choix.charAt(0)=='2') {
						
			System.out.println("Combien de photos?");
			fichier = sc.nextLine();
			System.out.println("Telechargement terminé.\nIl vous faut renseigner les informations suivantes :");
			System.out.print("L'appareil Photo : ");
			fichier = fichier + " " + sc.nextLine();
			System.out.print("L'objectif : ");
			fichier = fichier + " " + sc.nextLine();
			System.out.print("La distance Focale : ");
			fichier = fichier + " " + sc.nextLine();
			System.out.print("La sensibilité ISO : ");
			fichier = fichier + " " + sc.nextLine();
			System.out.print("L'ouverture : ");
			fichier = fichier + " " + sc.nextLine();
			System.out.print("La vitesse d'Obturation : ");
			fichier = fichier + " " + sc.nextLine();
			
			control.notifyChangement(fichier);
			
		}else {
			control.notifyChangement(choix);
		}

	}
	
	@SuppressWarnings("resource")
	public void displayAlbumMenu(String str){
		control = new ControllerAlbumManagement(this, model);
		
		if(!str.isEmpty()){
			System.out.println("["+str+"]");
		
		}
		System.out.println("--- --- GESTION DES ALBUMS --- ---");
		System.out.println("Nouvel album : taper 1");
		System.out.println("Consulter albums : taper 2");
		System.out.println("Quitter : tapez 9");
		Scanner sc = new Scanner(System.in);
		
		String choix = sc.nextLine();
		
		String fichier;
		
		if(choix.charAt(0)=='1') {
			
			fichier = "NEWW";
			
			System.out.println("Il vous faut renseigner les informations suivantes :");
			System.out.print("Titre de l'album : ");
			fichier = fichier + " " + sc.nextLine();
			System.out.print("Le sous-titre de l'album : ");
			fichier = fichier + " " + sc.nextLine();
			
			control.notifyChangement(fichier);
			
		}else if(choix.charAt(0)=='2') {
			
			control.notifyChangement("PREA");
			
		}else {
			control.notifyChangement(choix);
		}
	}
	
	public void displayAlbumManagement(ArrayList<String> str){
		
		control = new ControllerAlbumManagement(this, model);
		
		System.out.println("--- --- GESTION DES ALBUMS --- ---");
		if(!str.isEmpty()){
			System.out.println("liste des Albums");
			System.out.println(str);
		}
		
		System.out.println("Ajouter des photos a un album : taper 1 [espace] chemin de l'album");
		System.out.println("Suprimer album :  taper 2 [espace] chemin de l'album");
		System.out.println("Quitter : tapez 9");
		Scanner sc = new Scanner(System.in);
		
		String choix = sc.nextLine();
		
		String fichier;
		
		if(choix.charAt(0)=='1') {
			
			fichier = "ADDA";
			
			fichier = fichier + choix.substring(choix.indexOf(" ")+1, choix.length());
			
			control.notifyChangement(fichier);
			
		}else if(choix.charAt(0)=='2') { 
			
			fichier = "DELA";
			
			fichier = fichier + choix.substring(choix.indexOf(" ")+1, choix.length());
			
			control.notifyChangement(fichier);
		}else {
			control.notifyChangement(choix);
		}
	}
	
	public void displayAlbumADD(ArrayList<String> str){
		
		control = new ControllerAlbumManagement(this, model);
		
		System.out.println("--- --- GESTION DES ALBUMS --- ---");
		if(!str.isEmpty()){
			System.out.println("liste des Albums");
			System.out.println(str);
		}
		
		System.out.println("Ajouter des photos a l'album : taper 1 [espace] id de la photo");
		System.out.println("Suprimer des photos a l'album :  taper 2 [espace] id de la photo");
		System.out.println("Quitter : tapez 9");
		Scanner sc = new Scanner(System.in);
		
		String choix = sc.nextLine();
		
		String fichier;
		
		if(choix.charAt(0)=='1') {
			
			fichier = "ADDF";
			
			fichier = fichier + choix.substring(choix.indexOf(" ")+1, choix.length());
			
			control.notifyChangement(fichier);
			
		}else if(choix.charAt(0)=='2') { 
			
			fichier = "DELF";
			
			fichier = fichier + choix.substring(choix.indexOf(" ")+1, choix.length());
			
			control.notifyChangement(fichier);
		}else {
			control.notifyChangement(choix);
		}
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
