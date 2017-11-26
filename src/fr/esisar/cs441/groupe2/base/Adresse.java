package fr.esisar.cs441.groupe2.base;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

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
    private Optional<Client> client;
	
    // Constructeur avec client
	public Adresse(int idAdresse, String rue, String codePostal, String ville, Client client) {
		super();
		this.idAdresse = idAdresse;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.client = Optional.ofNullable(client);
	}
	
	// Constructeur sans client
	public Adresse(int idAdresse, String rue, String codePostal, String ville) {
		super();
		this.idAdresse = idAdresse;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.client = Optional.empty();
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

	public Optional<Client> getClient() {
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

	public void setClient(Optional<Client> client) {
		this.client = client;
	}
	
	public void add_F(Statement stmt) throws SQLException{
	    String sql_element = "INSERT INTO AdresseF " +
	            "VALUES ("+idAdresse+", '"+rue+"', '"+codePostal+"', '"+ville+"')";
	    try{
	    stmt.executeUpdate(sql_element);
	    System.out.println("AdresseF '"+idAdresse+"' cree");
	    } catch (SQLException e){
	    	System.out.println("idAdresseF '"+idAdresse+"' existant");
	    }
	}
	
	public void add_L(Statement stmt) throws SQLException{
	    String sql_element = "INSERT INTO AdresseL " +
	            "VALUES ("+idAdresse+", '"+rue+"', '"+codePostal+"', '"+ville+"')";
	    try{
	    stmt.executeUpdate(sql_element);
	    System.out.println("AdresseL '"+idAdresse+"' cree");
	    } catch (SQLException e){
	    	System.out.println("idAdresseL '"+idAdresse+"' existant");
	    }
	}
	
	public void delete_F(Statement stmt) throws SQLException{
	    String sql_delete = "DELETE FROM AdresseF " +
	            "WHERE idAdresseF = "+idAdresse+"";
	    try{
	    stmt.executeUpdate(sql_delete);
	    System.out.println("AdresseF '"+idAdresse+"' supprime");
		} catch (SQLException e){
	    	System.out.println("Table AdresseF non existant");
	    }
	}
	
	public void delete_L(Statement stmt) throws SQLException{
	    String sql_delete = "DELETE FROM AdresseL " +
	            "WHERE idAdresseL = "+idAdresse+"";
	    try{
	    stmt.executeUpdate(sql_delete);
	    System.out.println("AdresseL '"+idAdresse+"' supprime");
		} catch (SQLException e){
	    	System.out.println("Table AdresseL non existant");
	    }
	}
	
	public void affiche_F(Statement stmt) throws SQLException{
		try{
		String sql_aff = "SELECT idAdresseF, rue, codePostal, ville FROM AdresseF ";
	    ResultSet rs = stmt.executeQuery(sql_aff);
	    
	    boolean a;
	    while(a=rs.next())
	    if (a==false){
	    	System.out.println("La table AdresseF est vide"); 
	    }
	    else{
	       //Retrieve by column name
	       int id  = rs.getInt("idAdresseF");
	       String rue = rs.getString("rue");
	       String codePostal = rs.getString("codePostal");
	       String ville = rs.getString("ville");

	       //Display values
	       System.out.print("idAdresseF: " + id);
	       System.out.print(", rue: " + rue);
	       System.out.print(", codePostal: " + codePostal);
	       System.out.println(", ville: " + ville);
	    }
	    rs.close();
		} catch (SQLException e){
	    	System.out.println("Table AdresseF non existante");
	    }
	}
	
	public void affiche_L(Statement stmt) throws SQLException{
		try{
		String sql_aff = "SELECT idAdresseL, rue, codePostal, ville FROM AdresseL ";
	    ResultSet rs = stmt.executeQuery(sql_aff);
	    
	    boolean a;
	    while(a=rs.next())
	    if (a==false){
	    	System.out.println("La table AdresseL est vide"); 
	    }
	    else{
	       //Retrieve by column name
	       int id  = rs.getInt("idAdresseL");
	       String rue = rs.getString("rue");
	       String codePostal = rs.getString("codePostal");
	       String ville = rs.getString("ville");

	       //Display values
	       System.out.print("idAdresseL: " + id);
	       System.out.print(", rue: " + rue);
	       System.out.print(", codePostal: " + codePostal);
	       System.out.println(", ville: " + ville);
	    }
	    rs.close();
		} catch (SQLException e){
	    	System.out.println("Table AdresseL non existante");
	    }
	}
	    
}