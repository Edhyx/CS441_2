package fr.esisar.cs441.groupe2.base;

import com.sun.security.ntlm.Client;

/*
 * classe Adresse
 * Association : juste un client selon l'UML
 * 
 */
public class Adresse {

    private int idAdresse;
    private String rue;
    private String codePostal;
    private String ville;
    private Client client;
	
    // Constructeur avec client
	public Adresse(int idAdresse, String rue, String codePostal, String ville, Client client) {
		super();
		this.idAdresse = idAdresse;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.client = client;
	}

	// Constructeur sans client
	public Adresse(int idAdresse, String rue, String codePostal, String ville) {
		super();
		this.idAdresse = idAdresse;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.client = null;
	}

	public int getIdAdresse() {
		return idAdresse;
	}

	public String getRue() {
		return rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public String getVille() {
		return ville;
	}

	public Client getClient() {
		return client;
	}

	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	    
}