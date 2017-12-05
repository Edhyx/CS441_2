/*
 * Projet CS441 - Mini projet de developpement d'une application de gestion de tirages
 * photos numériques
 * Equipe 2
 * 
 * pattern MVC : View
 * Gestion de l'affichage en ligne de commandes
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
		System.out.println("Veuillez entrer un prénom : ");
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
		System.out.println("Gérer les albums photo : tapez 2");
		System.out.println("Gérer les commandes : tapez 3");
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
			
			System.out.println("Telechargement termin�.\nIl vous faut renseigner les informations suivantes :");
			System.out.print("L'appareil Photo : ");
			fichier = fichier + " " + sc.nextLine();
			System.out.print("L'objectif : ");
			fichier = fichier + " " + sc.nextLine();
			System.out.print("La distance Focale : ");
			fichier = fichier + " " + sc.nextLine();
			System.out.print("La sensibilit� ISO : ");
			fichier = fichier + " " + sc.nextLine();
			System.out.print("L'ouverture : ");
			fichier = fichier + " " + sc.nextLine();
			System.out.print("La vitesse d'Obturation : ");
			fichier = fichier + " " + sc.nextLine();
			
			control.notifyChangement(fichier);
			
		}else if(choix.charAt(0)=='2') {
						
			System.out.println("Combien de photos?");
			fichier = sc.nextLine();
			System.out.println("Telechargement termin�.\nIl vous faut renseigner les informations suivantes :");
			System.out.print("L'appareil Photo : ");
			fichier = fichier + " " + sc.nextLine();
			System.out.print("L'objectif : ");
			fichier = fichier + " " + sc.nextLine();
			System.out.print("La distance Focale : ");
			fichier = fichier + " " + sc.nextLine();
			System.out.print("La sensibilit� ISO : ");
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
			
			fichier = "NEW";
			
			System.out.println("Il vous faut renseigner les informations suivantes :");
			System.out.print("Titre de l'album : ");
			fichier = fichier + " " + sc.nextLine();
			System.out.print("Le sous-titre de l'album : ");
			fichier = fichier + " " + sc.nextLine();
			
			control.notifyChangement(fichier);
			
		}else if(choix.charAt(0)=='2') {
			
			control.notifyChangement("PRE");
			
		}else {
			control.notifyChangement(choix);
		}
	}
	
	public void displayAlbumManagement(ArrayList<String> str){
		
		control = new ControllerAlbumManagement(this, model);
		
		System.out.println("--- --- GESTION DES ALBUMS --- ---");
		System.out.println("liste des albums :");
		if(!str.isEmpty()){
			for(String line : str) {
				System.out.println("+ " + line);
			}
		}
		
		System.out.println("Ajouter des photos a un album : taper 1 [espace] chemin de l'album");
		System.out.println("Suprimer album :  taper 2 [espace] chemin de l'album");
		System.out.println("Quitter : tapez 9");
		Scanner sc = new Scanner(System.in);
		
		String choix = sc.nextLine();
		
		String fichier;
		
		if(choix.charAt(0)=='1') {
			
			fichier = "ADA";
			
			fichier = fichier + " " + choix.substring(choix.indexOf(" ")+1, choix.length());
			
			control.notifyChangement(fichier);
			
		}else if(choix.charAt(0)=='2') { 
			
			fichier = "DEA";
			
			fichier = fichier + " " +choix.substring(choix.indexOf(" ")+1, choix.length());
			
			control.notifyChangement(fichier);
		}else {
			control.notifyChangement(choix);
		}
	}
	
	public void displayAlbumADD(ArrayList<String> str){
		
		control = new ControllerAlbumManagement(this, model);
		
		System.out.println("--- --- GESTION DES ALBUMS --- ---");
		System.out.println("liste des Images sans albums");
		
		if(!str.isEmpty()){
			
			for(String line : str) {
				System.out.println("+ " + line);
			}
		}
		
		System.out.println("Ajouter des photos a l'album : taper 1 [espace] id de la photo");
		System.out.println("Quitter : tapez 9");
		Scanner sc = new Scanner(System.in);
		
		String choix = sc.nextLine();
		
		String fichier;
		
		if(choix.charAt(0)=='1') {
			
			fichier = "ADF";
			
			fichier = fichier + " " + choix.substring(choix.indexOf(" ")+1, choix.length());
			
			control.notifyChangement(fichier);
			
		}else {
			control.notifyChangement(choix);
		}
	}
	
	public void displayAlbumOrder(String str){
		control = new ControllerAlbumOrder(this, model);
		
		System.out.println("--- --- GESTION DES COMMANDES --- ---");
		if(!str.isEmpty()){
			System.out.println("liste des commandes");
			System.out.println(str);
		}
		
		System.out.println("Commander un album : taper 1 ");
		System.out.println("Suprimer commande :  taper 2 ");
		System.out.println("Quitter : tapez 9");
		Scanner sc = new Scanner(System.in);
		
		String choix = sc.nextLine();
		
		String fichier;
		
		if(choix.charAt(0)=='1') {
			
			fichier = "ADC";
			
			fichier = fichier + choix.substring(choix.indexOf(" ")+1, choix.length());
			control.notifyChangement(fichier);
			
		}else if(choix.charAt(0)=='2') { //à modif
			
			fichier = "DLC";
			
			fichier = fichier + choix.substring(choix.indexOf(" ")+1, choix.length());
			
			control.notifyChangement(fichier);
		}else {
			control.notifyChangement(choix);
		}
	}
	
	public void displayOrderADD(ArrayList<String> str){
		
		control = new ControllerAlbumOrder(this, model);
		
		System.out.println("--- --- NOUVELLE COMMANDE --- ---");
		System.out.println("liste des albums :");
		if(!str.isEmpty()){
			for(String line : str) {
				System.out.println("+ " + line);
			}
		}
		
		System.out.println("choisir l'album à commander: taper 1 [espace] id de l'album");
		Scanner sc = new Scanner(System.in);
		
		String choix = sc.nextLine();
		
		String fichier;
		
		if(choix.charAt(0)=='1') {
			
			fichier = "ADC";
			
			fichier = fichier + choix.substring(choix.indexOf(" ")+1, choix.length());
			
			control.notifyChangement(fichier);
			
		}
	}
	
	public void displayOrderMenu(String str){
		control = new ControllerAlbumOrder(this, model);
		
		if(!str.isEmpty()){
			System.out.println("["+str+"]");
		
		}
		System.out.println("--- --- GESTION DES COMMANDES --- ---");
		System.out.println("Nouvele Commande : taper 1");
		System.out.println("Consulter Commandes : taper 2");
		System.out.println("Quitter : tapez 9");
		Scanner sc = new Scanner(System.in);
		
		String choix = sc.nextLine();
		
		String fichier;
		
		if(choix.charAt(0)=='1') {
			
			fichier = "NEW";
			control.notifyChangement(fichier);
			
		}else if(choix.charAt(0)=='2') {
			
			control.notifyChangement("PREA");
			
		}else {
			control.notifyChangement(choix);
		}
	}
	
	public void displayAddOrder(String str){
		System.out.println(str);
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
