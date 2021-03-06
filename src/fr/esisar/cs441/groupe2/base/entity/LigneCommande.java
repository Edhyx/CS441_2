package fr.esisar.cs441.groupe2.base.entity;

public class LigneCommande {

    private int quantite;
    private Album album;
    private Commande commande;
    private Format format;
	
    public LigneCommande(int quantite, int idCommande, int idFormat, int idAlbum) {
		super();
		this.quantite = quantite;
		this.album = new Album(idAlbum, null, null);
		this.commande = new Commande(idCommande, null, idAlbum, null);
		this.format = new Format(idFormat, 0);
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