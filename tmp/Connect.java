import java.sql.*;

//Download ojdbc6.jar then Build Path -> Libraries -> Add External JAR
public class Connect {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	String server = "tp-oracle.esisar.grenoble-inp.fr";
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@//"+server+"/xe";
	String login = "malossep";
	Class.forName(driver);
	Connection connection = DriverManager.getConnection(url,login,login);
		
    Statement stmt = connection.createStatement();
    
    /////////Creer une nouvelle table
    /*String sql_create = "CREATE TABLE Client" +
            "(adresseMail VARCHAR(255), " +
            " nom VARCHAR(255), " + 
            " prénom VARCHAR(255), " + 
            " password VARCHAR(255), " + 
            " PRIMARY KEY ( adresseMail ))";
    stmt.executeUpdate(sql_create);
    System.out.println("Table créée"); 
    /*
    
    //////////Supprimer la table dans la BDD
    /*String sql_delete_tab =  "DROP TABLE Client";
    ResultSet rs = stmt.executeQuery(sql_delete_tab);
    System.out.println("Table supprimée");
    */
	
    //////////Ajouter élément
    /*String sql_element = "INSERT INTO Client " +
            "VALUES ('daz@hdiz', 'pauline', 'malosse', 'xx')";
    stmt.executeUpdate(sql_element);
    System.out.println("Element créé"); 
    */

    /////////supprimer un élement
    /*String sql_delete = "DELETE FROM Client " +
            "WHERE adresseMail = 'daz@hdiz'";
    stmt.executeUpdate(sql_delete);
    */
    
    /////////affiche la table
    String sql_aff = "SELECT adresseMail, nom, prénom, password FROM Client ";
    ResultSet rs = stmt.executeQuery(sql_aff);

    while(rs.next()){
       //Retrieve by column name
       String id  = rs.getString("adresseMail");
       String nom = rs.getString("nom");
       String prénom = rs.getString("prénom");
       String password = rs.getString("password");

       //Display values
       System.out.print("adresseMail: " + id);
       System.out.print(", nom: " + nom);
       System.out.print(", prénom: " + prénom);
       System.out.println(", password: " + password);
    }
    rs.close();
    stmt.close();
    connection.close();
	}	
}