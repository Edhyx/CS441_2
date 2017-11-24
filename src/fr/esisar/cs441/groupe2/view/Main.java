/*
Projet CS441 - Mini projet de developpement d'une application de gestion de tirages
photos numériques
Equipe 2
 */

package fr.esisar.cs441.groupe2.view;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	}

	public static void init() {
		Int choix = 0;
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
					System.out.println("Nouveau client");
				}
				case 2: {
					System.out.println("Connexion");
				}
				case 9: {
					System.out.println("Sortir");
				}
			}
		}
	}
}
