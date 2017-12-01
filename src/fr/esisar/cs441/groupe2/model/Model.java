package fr.esisar.cs441.groupe2.model;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import fr.esisar.cs441.groupe2.base.entity.*;
import fr.esisar.cs441.groupe2.base.BDDs.*;
public class Model {

	private String idClient;
	private Statement stmt;

	public Model(Statement stmt) {
		this.stmt = stmt;
	}
	
	public void setClient(String id) {
		this.idClient = id;
	}
	
	public String getClientPassword(String id) {
		if(id.equals("plop")) {
			return "123456";
		}
		return null;
	}
	
	private Adresse createAdressF(int idAdresseF, String rue, String codePostal, String ville) {
		Adresse newAdressF = new Adresse(idAdresseF,rue,codePostal,ville);
		AdresseDAO tableAdressF = new AdresseDAO(stmt);
		tableAdressF.add_F(newAdressF);
		return newAdressF;
	}
	public Adresse createAdressL(int idAdresseL, String rue, String codePostal, String ville) {
		Adresse newAdressL = new Adresse(idAdresseL,rue,codePostal,ville);
		AdresseDAO tableAdressL = new AdresseDAO(stmt);
		tableAdressL.add_F(newAdressL);
		return newAdressL;
	}
	public boolean createClient(String adresseMail, String nom, String prenom, String password) {
		Client newClient = new Client(adresseMail, nom, prenom, password, createAdressF, adresseL);
		// completer
		return true;
	}
	
	public boolean addFile(String appareilPhoto, String objectif, String distance, String sensibilte, String ouverture, String vitesse) {
		
		String url = new String(""+ThreadLocalRandom.current().nextInt(0, 1000 + 1));
		
		// completer

		return true;
	}
	
	public boolean addFolder( String titre, String sousTitre) {
		
		String id = new String(""+ThreadLocalRandom.current().nextInt(0, 1000 + 1));
		
		// completer
		
		return true;
		
	}
	
	public ArrayList<String> getFolderList() {
		
	}
	
	
}
