package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.User;


public class UserDao {
	
	/**
	 * 登陆校验
	 * 成功true
	 * 失败false
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public boolean Login(User user) {
		User user1 = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String sql = "select * from user where username = ? and password = ?";
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/shop", "root", "");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			ResultSet rs = pstmt.executeQuery();
			user1 = null;
			while(rs.next()) {
				user1 = new User();
				user1.setId(rs.getInt("id"));
				user1.setUsername(rs.getString("username"));
				user1.setPassword(rs.getString("password"));
				user1.setAge(rs.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e){
			System.out.println(e);
		}finally {
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		if(user1 != null) {
			user = user1;
			return true;
		}
		return false;
	}

}
