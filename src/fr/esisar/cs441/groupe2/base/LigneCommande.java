/*
CS441 Equipe N°2

LigneCommande.java
*/

package fr.esisar.cs441.groupe2.base;

public class LigneCommande {

    private int quantite;
    private Album album;
    private Commande commande;
    private Format format;
	
    public LigneCommande(int quantite, Album album, Commande commande, Format format) {
		super();
		this.quantite = quantite;
		this.album = album;
		this.commande = commande;
		this.format = format;
	}

	public int getQuantite() {
		return quantite;
	}

	public Album getAlbum() {
		return album;
	}

	public Commande getCommande() {
		return commande;
	}

	public Format getFormat() {
		return format;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public void setFormat(Format format) {
		this.format = format;
	}
    
}