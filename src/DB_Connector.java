import java.sql.*;


public class DB_Connector {
Connection con;
	
	Connection getConnection(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "system", "system");
			System.out.println("connection established");
			return con;
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

}
}
