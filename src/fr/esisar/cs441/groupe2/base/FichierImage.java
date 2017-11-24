/*
CS441 Equipe N°2

FichierImage.java
*/

package fr.esisar.cs441.groupe2.base;

import java.util.ArrayList;

public class FichierImage {

	private String cheminAcces;
    private String appareilPhoto;
    private String objectif;
    private int distanceFocale;
    private int sensibiliteISO;
    private int ouverture;
    private int vitesseObturation;
    private Client client;
    private ArrayList<Album> albums;
	
    public FichierImage(String cheminAcces, String appareilPhoto, String objectif, int distanceFocale,
			int sensibiliteISO, int ouverture, int vitesseObturation, Client client, ArrayList<Album> albums) {
		super();
		this.cheminAcces = cheminAcces;
		this.appareilPhoto = appareilPhoto;
		this.objectif = objectif;
		this.distanceFocale = distanceFocale;
		this.sensibiliteISO = sensibiliteISO;
		this.ouverture = ouverture;
		this.vitesseObturation = vitesseObturation;
		this.client = client;
		this.albums = albums;
	}
	public String getCheminAcces() {
		return cheminAcces;
	}
	public String getAppareilPhoto() {
		return appareilPhoto;
	}
	public String getObjectif() {
		return objectif;
	}
	public int getDistanceFocale() {
		return distanceFocale;
	}
	public int getSensibiliteISO() {
		return sensibiliteISO;
	}
	public int getOuverture() {
		return ouverture;
	}
	public int getVitesseObturation() {
		return vitesseObturation;
	}
	public Client getClient() {
		return client;
	}
	public ArrayList<Album> getAlbums() {
		return albums;
	}
	public void setCheminAcces(String cheminAcces) {
		this.cheminAcces = cheminAcces;
	}
	public void setAppareilPhoto(String appareilPhoto) {
		this.appareilPhoto = appareilPhoto;
	}
	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}
	public void setDistanceFocale(int distanceFocale) {
		this.distanceFocale = distanceFocale;
	}
	public void setSensibiliteISO(int sensibiliteISO) {
		this.sensibiliteISO = sensibiliteISO;
	}
	public void setOuverture(int ouverture) {
		this.ouverture = ouverture;
	}
	public void setVitesseObturation(int vitesseObturation) {
		this.vitesseObturation = vitesseObturation;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void setAlbums(ArrayList<Album> albums) {
		this.albums = albums;
	}
    
}