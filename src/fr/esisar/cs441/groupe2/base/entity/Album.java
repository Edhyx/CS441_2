package fr.esisar.cs441.groupe2.base.entity;

public class Album {

    private int idAlbum;
    private String titre;
    private String sousTitre;
    private Client creeParClient;
	
    public Album(int idAlbum, String titre, String sousTitre) {
		super();
		this.idAlbum = idAlbum;
		this.titre = titre;
		this.sousTitre = sousTitre;
		this.creeParClient = null;
	}
    
    public Album(int idAlbum, String titre, String sousTitre, Client creeParClient) {
		super();
		this.idAlbum = idAlbum;
		this.titre = titre;
		this.sousTitre = sousTitre;
		this.creeParClient = creeParClient;
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
    
	public String toString() {
		return "Album [idAlbum=" + idAlbum + ", titre=" + titre + ", sousTitre=" + sousTitre +"]";
	}
}