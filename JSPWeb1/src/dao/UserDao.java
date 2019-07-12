package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import damain.User;
import utils.JdbcUtils;

public class UserDao {
	JdbcUtils ju = new JdbcUtils();
	
	/**
	 * 登陆校验
	 * 成功true
	 * 失败false
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public boolean Login(User user) throws SQLException {
		String sql = "select * from user where username = ? and password = ?";
		PreparedStatement pstmt = ju.getConnection().prepareStatement(sql);
		ju.setParams(pstmt, user.getUsername(), user.getPassword());
		ResultSet rs = pstmt.executeQuery();
		User user1 = null;
		while(rs.next()) {
			user1 = new User();
			user1.setId(rs.getInt("id"));
			user1.setUsername(rs.getString("username"));
			user1.setPassword(rs.getString("password"));
			user1.setAge(rs.getInt("age"));
		}
		if(user1 != null) {
			user = user1;
			return true;
		}
		return false;
	}
	

}
