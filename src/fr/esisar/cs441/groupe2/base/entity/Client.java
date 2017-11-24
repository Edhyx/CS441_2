/*
CS441 Equipe N°2

Client.java
*/

package fr.esisar.cs441.groupe2.base.entity;

import java.sql.*;
import java.util.*;

public class Client {

	private String adresseMail;
    private String nom;
    private String prenom;
    private String password;
    private Adresse adresseDeFacturation;
    private Adresse adresseDeLivraison;
    private ArrayList<FichierImage>	fichierImages;
    private ArrayList<Commande>	commandes;
    private ArrayList<Album> albums;
	
    public Client(String adresseMail, String nom, String prenom, String password, Adresse adresseDeFacturation,
			Adresse adresseDeLivraison) {
		super();
		this.adresseMail = adresseMail;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.adresseDeFacturation = adresseDeFacturation;
		this.adresseDeLivraison = adresseDeLivraison;
		this.fichierImages = new ArrayList<FichierImage>();
		this.commandes = new ArrayList<Commande>();
		this.albums = new ArrayList<Album>();
	}

	public Client(String adresseMail, String nom, String prenom, String password) {
		super();
		this.adresseMail = adresseMail;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.adresseDeFacturation = null;
		this.adresseDeLivraison = null;
		this.fichierImages = new ArrayList<FichierImage>();
		this.commandes = new ArrayList<Commande>();
		this.albums = new ArrayList<Album>();
	}

	public String getAdresseMail() {
		return adresseMail;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getPassword() {
		return password;
	}

	public Adresse getAdresseDeFacturation() {
		return adresseDeFacturation;
	}

	public Adresse getAdresseDeLivraison() {
		return adresseDeLivraison;
	}

	public ArrayList<FichierImage> getFichierImages() {
		return fichierImages;
	}

	public ArrayList<Commande> getCommandes() {
		return commandes;
	}

	public ArrayList<Album> getAlbums() {
		return albums;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAdresseDeFacturation(Adresse adresseDeFacturation) {
		this.adresseDeFacturation = adresseDeFacturation;
	}

	public void setAdresseDeLivraison(Adresse adresseDeLivraison) {
		this.adresseDeLivraison = adresseDeLivraison;
	}

	public void setFichierImages(ArrayList<FichierImage> fichierImages) {
		this.fichierImages = fichierImages;
	}

	public void setCommandes(ArrayList<Commande> commandes) {
		this.commandes = commandes;
	}

	public void setAlbums(ArrayList<Album> albums) {
		this.albums = albums;
	}	

	@Override
	public String toString() {
		return "Client [adresseMail=" + adresseMail + ", nom=" + nom + ", prenom=" + prenom + ", password=" + password
				+ ", adresseDeFacturation=" + adresseDeFacturation + ", adresseDeLivraison=" + adresseDeLivraison
				+ ", fichierImages=" + fichierImages + ", commandes=" + commandes + ", albums=" + albums + "]";
	}
}