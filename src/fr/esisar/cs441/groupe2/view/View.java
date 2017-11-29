/*
Projet CS441 - Mini projet de developpement d'une application de gestion de tirages
photos numériques
Equipe 2

Gestion de l'affichage en ligne de commandes
 */

package fr.esisar.cs441.groupe2.view;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.execute();
	}

	public void execute() {

		int menu = 1;
		int choice;
		
		displayInit();
		
		while ((choice=this.choice()) != 0) {
			switch (menu) {
				case 1:  // menu Init
					switch (choice) {
					case 1: displayNewClient(); break;
					case 2: displayClient(); break;
					case 9: menu = 0; break;

					default: break;
					}
					break;

				case 2: // menu Ajouter des photos
					displayAddPhoto();
					break;
				case 3: //menu Creation ou suppression d'album
					displayAlbumManagement();
					break;
				case 4: //menu Commande d'albums
					displayAlbumOrder();
					break;
				case 5: //menu Liste des commandes
					displayOrderList();
					break;
				case 0: //fermeture
					break;
				default:
					System.out.println("Entrez un choix entre 1, 2 et 9");
					break;
			}
		}
	}

	public void displayInit(){
	
		System.out.println("--- --- Bienvenue sur Esyphoto --- ---");
		System.out.println("Nouveau client : tapez 1");
		System.out.println("Connexion : tapez 2");
		System.out.println("Sortir : tapez 9");
	}

	public void displayNewClient(){
		System.out.println("--- --- Bienvenue --- ---");
		System.out.println("Veuillez entrer une adresse mail : ");
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
	
	public int choice() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
}
