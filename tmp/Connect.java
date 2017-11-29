import java.sql.*;
import java.util.ArrayList;

import fr.esisar.cs441.groupe2.base.entity.Adresse;
import fr.esisar.cs441.groupe2.base.entity.Album;
import fr.esisar.cs441.groupe2.base.entity.Client;
import fr.esisar.cs441.groupe2.base.entity.Commande;
import fr.esisar.cs441.groupe2.base.entity.FichierImage;
//Download ojdbc6.jar then Build Path -> Libraries -> Add External JAR
public class Connect {
	
	private static String adresseMail;
    private static String nom;
    private static String prenom;
    private static String password;
    
    public Connect() {
		super();
		this.adresseMail="cc";
		this.nom="malosse";
		this.prenom="pauline";
		this.password="xxxx";
	}
    
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
	String server = "tp-oracle.esisar.grenoble-inp.fr";
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@//"+server+"/xe";
	String login = "malossep";
	Class.forName(driver);
	Connection connection = DriverManager.getConnection(url,login,login);
		
    Statement stmt = connection.createStatement();
 /*   
/////////Creer table AdressF
    String sql_adresseF = "CREATE TABLE AdresseF " + 
            "(idAdresseF INTEGER, " +
            " rue VARCHAR(255), " + 
            " codePostal VARCHAR(255), " + 
            " ville VARCHAR(255), " + 
            " PRIMARY KEY ( idAdresseF ))";
    stmt.executeUpdate(sql_adresseF);
    System.out.println("Table AdresseF cree");
    
/////////Creer table AdressL
    String sql_adresseL = "CREATE TABLE AdresseL " +
            "(idAdresseL INTEGER, " +
            " rue VARCHAR(255), " + 
            " codePostal VARCHAR(255), " + 
            " ville VARCHAR(255), " + 
            " PRIMARY KEY ( idAdresseL ))";
    stmt.executeUpdate(sql_adresseL);
    System.out.println("Table AdresseL cree"); 
    
/////////Creer table client
    String sql_client = "CREATE TABLE Client " +
            "(adresseMail VARCHAR(255), " +
            " nom VARCHAR(255), " + 
            " prenom VARCHAR(255), " + 
            " password VARCHAR(255), " + 
            " idAdresseF INTEGER, " +
            " idAdresseL INTEGER, " +
            " PRIMARY KEY ( adresseMail ), " +
            " FOREIGN KEY (idAdresseF) REFERENCES AdresseF(idAdresseF), " +
            " FOREIGN KEY (idAdresseL) REFERENCES AdresseL(idAdresseL))";
    stmt.executeUpdate(sql_client);
    System.out.println("Table Client cree"); */
    
    
    //////////Supprimer la table dans la BDD
   /*String sql_delete_tab =  "DROP TABLE Client";
    ResultSet rss = stmt.executeQuery(sql_delete_tab);
    System.out.println("Table supprimee");*/
    
	Connect c = new Connect();
	//c.add(stmt); 
    /////////Ajouter élément
  /*String sql_element = "INSERT INTO Client " +
            "VALUES ('cc', 'xxx', 'xxxx','xxxxx')";
    stmt.executeUpdate(sql_element);
    System.out.println("Element créé");*/
    

    /////////supprimer un élement
    /*String sql_delete = "DELETE FROM Client " +
            "WHERE adresseMail = 'daz@hdiz'";
    stmt.executeUpdate(sql_delete);
    */
    ///////trouver un element
/*	String sql_find = "SELECT * FROM Client " +
                      "WHERE adresseMail= 'cc'"; 
	ResultSet rs = stmt.executeQuery(sql_find);*/
  

    /////////affiche la table
    //String sql_aff = "SELECT adresseMail, nom, prenom, password FROM Client ";
   // ResultSet rs = stmt.executeQuery(sql_aff);
    ClientDAO tableClient = new ClientDAO(stmt);
	Adresse AdresseA = new Adresse(30,"t","r","s");
	Client clientA = new Client("cc","Van Damme","Jean-Claude","DoubleImpact",AdresseA,AdresseA);
	Client clientB = new Client("yz","nom","prenom","xxx",AdresseA,AdresseA);
	
   //tableClient.add(clientB);
	
  // tableClient.delete(clientA);
	
   tableClient.getById(clientB.getAdresseMail()).toString();
    /*ArrayList<Client> listeClient = tableClient.getAll();
	for(Client cl : listeClient) {
		System.out.println(cl.toString());
	}*/
	
   /* 
   boolean a;
    while(a=rs.next()){
    if (a==false){
    	System.out.println("La table est vide"); 
    }
    else{
       //Retrieve by column name
       String id  = rs.getString("adresseMail");
       String nom = rs.getString("nom");
       String prenom = rs.getString("prenom");
       String password = rs.getString("password");

       //Display values
       System.out.print("adresseMail: " + id);
       System.out.print(", nom: " + nom);
       System.out.print(", prenom: " + prenom);
       System.out.println(", password: " + password);
    }
    rs.close();
    stmt.close();
    connection.close();
	}*/
		}
	
	public void add(Statement stmt) throws SQLException{
	    String sql_element = "INSERT INTO Client " +
	            "VALUES ('"+adresseMail+"', '"+nom+"', '"+prenom+"', '"+password+"')";
	    stmt.executeUpdate(sql_element);
	    System.out.println("Element créé");
	}
}