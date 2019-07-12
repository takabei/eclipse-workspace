package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcTest {
	public static Connection getConnection() throws SQLException {
		String password = "";
		String user = "root";
		String url = "jdbc:mysql://localhost:3306/shop";
		return DriverManager.getConnection(url, user, password);
	}
	
	public static Connection getConnection(String url, String user, String pass) throws SQLException {
		return DriverManager.getConnection(url, user, pass);
	}
}
