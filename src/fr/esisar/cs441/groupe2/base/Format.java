package fr.esisar.cs441.groupe2.base;

import java.util.ArrayList;

public class Format {

	private int idFormat;
    private int prixUnitaire;
    private ArrayList<LigneCommande> ligneCommande;
	
    public Format(int idFormat, int prixUnitaire, ArrayList<LigneCommande> ligneCommande) {
		super();
		this.idFormat = idFormat;
		this.prixUnitaire = prixUnitaire;
		this.ligneCommande = ligneCommande;
	}
      
	public Format(int idFormat, int prixUnitaire) {
		super();
		this.idFormat = idFormat;
		this.prixUnitaire = prixUnitaire;
		this.ligneCommande = new ArrayList<LigneCommande>();
	}

	public int getIdFormat() {
		return idFormat;
	}

	public int getPrixUnitaire() {
		return prixUnitaire;
	}

	public ArrayList<LigneCommande> getLigneCommande() {
		return ligneCommande;
	}

	public void setIdFormat(int idFormat) {
		this.idFormat = idFormat;
	}

	public void setPrixUnitaire(int prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public void setLigneCommande(ArrayList<LigneCommande> ligneCommande) {
		this.ligneCommande = ligneCommande;
	}

    
    
}