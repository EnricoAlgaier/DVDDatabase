package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DataBaseConnection {
	public Statement statement;
	public Connection connection;

	private static final String JDBC_URL = "jdbc:mysql://angebotsinfo.de:3306/DvdDatabase"; 
	private static final String USERNAME = "DvdDatabase"; 
	private static final String PASSWORD = "";

	public void connectDatabase() {
		try {
			if (connection == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
				statement = connection.createStatement();
				System.out.println("Connection successful");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No connection to the Server", "Attention", JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
	}
	
	public void closeConnection() {
		try {
			connection.close();
			System.out.println("Connection successfully terminated");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public PreparedStatement prepareStatement() {
		return null;
	}
}