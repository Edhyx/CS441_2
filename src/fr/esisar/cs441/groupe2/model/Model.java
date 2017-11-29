package fr.esisar.cs441.groupe2.model;

public class Model {

	
	public String getClientPassword(String id) {
		if(id.equals("plop")) {
			return "123456";
		}
		return null;
	}
}
