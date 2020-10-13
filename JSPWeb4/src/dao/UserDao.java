package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import po.User;

public class UserDao {
	
	public int login(User user) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from user where username = ? and password = ?";
		int count = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/shop", "root", "");
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			}
			return count;
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(connection != null){
					connection.close();
				}
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		return count;
	}
	
}