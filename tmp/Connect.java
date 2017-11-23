import java.sql.*;

public class Connect {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	String server = "tp-oracle.esisar.grenoble-inp.fr";
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@://"+server+":1512:xe";
	String login = "malossep";
	Class.forName(driver);
	Connection connection = DriverManager.getConnection(url,login,login);
	System.out.println("connection successsfully");
	}	
}