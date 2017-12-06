/*
CS441 Equipe N°2

Commande.java
*/

package fr.esisar.cs441.groupe2.base.entity;

public class Commande {

	private int idCommande;
    private String date;
    private int prixTotal;
    private Client client;
   	  

	public Commande(int idCommande, String date, int prixTotal, Client client) {
		super();
		this.idCommande = idCommande;
		this.date = date;
		this.prixTotal = prixTotal;
		this.client = client;
	}

	public int getIdCommande() {
		return idCommande;
	}

	public String getDate() {
		return date;
	}

	public int getPrixTotal() {
		return prixTotal;
	}

	public Client getClient() {
		return client;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setPrixTotal(int prixTotal) {
		this.prixTotal = prixTotal;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public String toString() {
		return "Commande [idCommande =" + idCommande + ", date=" + date + ", prixTotal=" + prixTotal + "]";
	}
}