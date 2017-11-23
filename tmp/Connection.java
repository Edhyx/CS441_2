
public class Connection {
	String server = "tp-oracle.esisar.grenoble-inp.fr";
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@://"+server+"/xe";
	String login = "malossep";
	class.forName(driver);
	Connection connection = DriverManager.getConnection(url,login,login);
}
