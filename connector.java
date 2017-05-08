import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connector {
	
	/*
	private static final String serverName = "localhost";
	private static final String port = "3306";
	private static final String user = "root";
	private static final String password = "hofstracs";
	private static final String dbname = "smart_health";
	private static final String table = "userinfo";
	*/
	
	public static void main(String[] argv) {
		try{
			selectRecords();
		} catch (SQLException e){System.out.println(e.getMessage());}
	}	
//--------------------------------------------------------------------------------------------------------
	//Select which table and information to show
	public static void selectRecords() throws SQLException {
		Connection dbConnection = null;
		Statement statement = null;

		String selectTableSQL = "SELECT IDUSERINFO, USERNAME, PASSWORD from USERINFO";

		try {
			dbConnection = getConnection();
			statement = dbConnection.createStatement();

			System.out.println(selectTableSQL);

			// execute select SQL stetement
			ResultSet rs = statement.executeQuery(selectTableSQL);

			while (rs.next()) {
				String userid = rs.getString("IDUSERINFO");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");

				System.out.println("userid : " + userid);
				System.out.println("username : " + username);
				System.out.println("password : " + password);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
	}
//--------------------------------------------------------------------------------------------------------
	//Establish Connection to the Database
	private static Connection getConnection() {
		Connection dbConnection = null;
		try {
			dbConnection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/smart_health", "root", "hofstracs");
			System.out.println("Connected to database");
		} catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			//return dbConnection;
		}
		return dbConnection;
	}
}