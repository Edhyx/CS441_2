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
<<<<<<< HEAD


	}

	public int affichageInit(){
=======

>>>>>>> b84c22c55151dac5988e17574988e4334a498fa4
		int menu = 0;
		int choix = 0;
		
		affichageInit();
		
		while ((choix=this.choix()) != 0) {
		
			switch (choix=choix() != 0) {
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

	public void affichageInit(){
	
		System.out.println("--- --- Bienvenue sur Esyphoto --- ---");
		System.out.println("Nouveau client : tapez 1");
		System.out.println("Connexion : tapez 2");
		System.out.println("Sortir : tapez 9");
	}

	public void nouveauClient(){

	}
	
	public int choix() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
		
	}
}
