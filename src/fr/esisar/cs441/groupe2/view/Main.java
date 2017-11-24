/*
Projet CS441 - Mini projet de developpement d'une application de gestion de tirages
photos numériques
Equipe 2
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
					break;
				case 4: //menu Commande d'albums
					break;
				case 5: //menu Liste des commandes
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
		System.out.print("Veuillez entrer une adresse mail : ");
		System.out.print("Veuillez entrer un nom : ");
		System.out.print("Veuillez entrer un prénom : ");
		System.out.print("Veuillez entrer un password : ");

	}

	public void displayClient(){
		System.out.println("--- --- Bienvenue --- ---");
		System.out.print("Veuillez entrer votre adresse mail : ");
		System.out.print("Veuillez entrer votre mot de passe : ");
	}

	public void displayAddPhoto(){
		System.out.println("--- --- AJOUTER DES PHOTOS --- ---");

	}
	
	public void displayAlbumManagement(){
		System.out.println("--- --- GESTION DES ALBUMS --- ---");
	}
	
	public void displayAlbumOrder(){}
	
	public int choice() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
}
