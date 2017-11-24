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



	}

	public int affichageInit(){

		int menu = 0;
		int choix = 0;
		
		affichageInit();
		
		while ((choix=this.choix()) != 0) {
<<<<<<< HEAD

			switch (choix = choix() != 0) {
				case 1: {
					menu = 1;
=======
		
			switch (menu) {
				case 1: { // menu Init
					switch (choix) {
					case 1:		
						affichageNouveauClient();
						break;

					default:
						break;
					}
>>>>>>> 4f834f28ff44c1a07f6f3073fa21b67f49a16ac4
				}
				case 2: {
					menu = 2;
				}
				case 9: {
					menu = 0;
				}
				default:
					System.out.println("Entrez un choix entre 1, 2 et 9");
					break;
			}
			return (menu);
		}
	}

	public void affichageInit(){
	
		System.out.println("--- --- Bienvenue sur Esyphoto --- ---");
		System.out.println("Nouveau client : tapez 1");
		System.out.println("Connexion : tapez 2");
		System.out.println("Sortir : tapez 9");
	}

	public void affichageNouveauClient(){

	}
	
	public int choix() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
}
