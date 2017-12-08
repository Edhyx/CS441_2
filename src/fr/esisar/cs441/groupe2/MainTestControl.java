package fr.esisar.cs441.groupe2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import fr.esisar.cs441.groupe2.model.Model;
import fr.esisar.cs441.groupe2.view.View;

public class MainTestControl {

	public MainTestControl() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Model model = new Model();
		View view = new View(model);
		view.displayInit();
	}

}
