package fr.esisar.cs441.groupe2.model;

import fr.esisar.cs441.groupe2.base.entity.Client;

public class Model {

	
	public String getClientPassword(String id) {
		if(id.equals("plop")) {
			return "123456";
		}
		return null;
	}
	
	public boolean createClient(String adresse, String nom, String prenom, String password) {
		Client newClient = new Client(adresse, nom, prenom, password, null, null);
		// completer
		return true;
	}
}
