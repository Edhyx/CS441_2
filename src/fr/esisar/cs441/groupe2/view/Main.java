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

<<<<<<< HEAD
	public void execute() {
		

	}

	public int affichageInit(){
		int choix;
		int menu = 0;
=======
	public static void init() {
		int choix = 0;
>>>>>>> 9983bc76cab50a7211c8baded8ddf5cd3374003d
		boolean arret = false;
		while (!arret) {
			Scanner sc = new Scanner(System.in);
			System.out.println("--- --- Bienvenue sur Esyphoto --- ---");
			System.out.println("Nouveau client : tapez 1");
			System.out.println("Connexion : tapez 2");
			System.out.println("Sortir : tapez 9");
			choix = sc.nextInt();
			switch (choix) {
				case 1: {
					menu = 1;
				}
				case 2: {
					menu = 2;
				}
				case 9: {
					menu = 0;
				}
				default : System.out.println("Entrez un choix entre 1, 2 et 9"); break;
			}
			return(menu);
		}
	}

	public void nouveauClient(){

	}
}
