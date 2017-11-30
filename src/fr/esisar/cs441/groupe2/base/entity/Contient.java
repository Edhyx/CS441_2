/*
CS441 Equipe N°2

Contient.java
*/

package fr.esisar.cs441.groupe2.base.entity;

/*
 * il faut gerer l'association
 */
public class Contient {

	private int numOrdre;
    private String titre;
    private String commentaire;
    private FichierImage fichierImages;
	private Album album;
	   
    public Contient(int numOrdre, String titre, String commentaire, FichierImage fichierImages, Album album){

    	this.numOrdre = numOrdre;
    	this.titre = titre;
    	this.commentaire = commentaire;
    	this.fichierImages = fichierImages;
    	this.album = album;
    }
	
    public FichierImage getFichierImages() {
		return fichierImages;
	}

	public void setFichierImages(FichierImage fichierImages) {
		this.fichierImages = fichierImages;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
    
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getNumOrdre() {
		return numOrdre;
	}
	public void setNumOrdre(int numOrdre) {
		this.numOrdre = numOrdre;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	public String toString() {
		return "Contient [numOrdre =" + numOrdre + ", titre=" + titre + ", commentaire=" + commentaire + ", ALbum=" + album.getIdAlbum() +", FichierImage=" + fichierImages.getCheminAcces() +"]";
	}
}