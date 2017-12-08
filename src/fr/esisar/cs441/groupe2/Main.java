package fr.esisar.cs441.groupe2;

import fr.esisar.cs441.groupe2.model.Model;
import fr.esisar.cs441.groupe2.view.View;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Model model = new Model();
		View view = new View(model);
		view.displayInit();
	}

}
