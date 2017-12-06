/*
CS441 Equipe N°2

Format.java
*/

package fr.esisar.cs441.groupe2.base.entity;

public class Format {

	private int idFormat;
    private int prixUnitaire;
	      
	public Format(int idFormat, int prixUnitaire) {
		super();
		this.idFormat = idFormat;
		this.prixUnitaire = prixUnitaire;
	}

	public int getIdFormat() {
		return idFormat;
	}

	public int getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setIdFormat(int idFormat) {
		this.idFormat = idFormat;
	}

	public void setPrixUnitaire(int prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	
	public String toString() {
		return "Format [idFormat =" + idFormat + ", prixUnitaire=" + prixUnitaire +"]";
	}
}