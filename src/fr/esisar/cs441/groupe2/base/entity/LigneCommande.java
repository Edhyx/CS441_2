/*
CS441 Equipe N°2

LigneCommande.java
*/

package fr.esisar.cs441.groupe2.base.entity;

public class LigneCommande {

    private int quantite;
    private Album album;
    private Commande commande;
    private Format format;
	
    public LigneCommande(int quantite) {
		super();
		this.quantite = quantite;
		this.album = null;
		this.commande = null;
		this.format = null;
	}
    
    public LigneCommande(int quantite, Commande commande, Format format, Album album) {
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
	
	public String toString() {
		return "LigneCommande [quantite =" + quantite + "]";
	}
    
}