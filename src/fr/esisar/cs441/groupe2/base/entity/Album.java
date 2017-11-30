/*
CS441 Equipe N°2

Album.java
*/

package fr.esisar.cs441.groupe2.base.entity;

import java.util.ArrayList;
/*
 * classe Album
 * Association : verifier pour ligneCommande cas ou c'est 0
 * 
 */
public class Album {


    private int idAlbum;
    private String titre;
    private String sousTitre;
    private Client creeParClient;
    private ArrayList<Contient>	fichierImages;
    private ArrayList<LigneCommande> ligneCommandes;
	
    public Album(int idAlbum, String titre, String sousTitre, Client creeParClient) {
		super();
		this.idAlbum = idAlbum;
		this.titre = titre;
		this.sousTitre = sousTitre;
		this.creeParClient = creeParClient;
		this.fichierImages = new ArrayList<Contient>();
		this.ligneCommandes = new ArrayList<LigneCommande>();
	}
    
    public Album(int idAlbum, String titre, String sousTitre, Client creeParClient,
			ArrayList<Contient> fichierImages, ArrayList<LigneCommande> ligneCommandes) {
		super();
		this.idAlbum = idAlbum;
		this.titre = titre;
		this.sousTitre = sousTitre;
		this.creeParClient = creeParClient;
		this.fichierImages = fichierImages;
		this.ligneCommandes = ligneCommandes;
	}

	public Album(int idAlbum, String titre, String sousTitre, Client creeParClient,
			ArrayList<Contient> fichierImages) {
		super();
		this.idAlbum = idAlbum;
		this.titre = titre;
		this.sousTitre = sousTitre;
		this.creeParClient = creeParClient;
		this.fichierImages = fichierImages;
		this.ligneCommandes = new ArrayList<LigneCommande>();
	}

	public int getIdAlbum() {
		return idAlbum;
	}

	public String getTitre() {
		return titre;
	}

	public String getSousTitre() {
		return sousTitre;
	}

	public Client getCreeParClient() {
		return creeParClient;
	}

	public ArrayList<Contient> getFichierImages() {
		return fichierImages;
	}

	public ArrayList<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setIdAlbum(int idAlbum) {
		this.idAlbum = idAlbum;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public void setSousTitre(String sousTitre) {
		this.sousTitre = sousTitre;
	}

	public void setCreeParClient(Client creeParClient) {
		this.creeParClient = creeParClient;
	}

	public void setFichierImages(ArrayList<Contient> fichierImages) {
		this.fichierImages = fichierImages;
	}

	public void setLigneCommandes(ArrayList<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	} 
    
	public String toString() {
		return "Album [idAlbum=" + idAlbum + ", titre=" + titre + ", sousTitre=" + sousTitre + ", client=" + creeParClient.getAdresseMail() +"]";
	}
}