import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class TestData {
	@Test
	public void test() throws SQLException {
		Connection conn = null;//连接
		PreparedStatement pstmt = null;//
		ResultSet rs = null;//结果集
		String driverClassName = "com.mysql.jdbc.Driver";//驱动
		String url = "jdbc:mysql://localhost:3306/test";//访问的数据库
		String user = "root";//用户名
		String psd = "54894liuyi";//密码
		String sql = "select username,password from user where username = ? and password = ?";
		
		conn = DriverManager.getConnection(url, user, psd);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "liuyi");
		pstmt.setString(2, "123456");
		rs = pstmt.executeQuery();
		while (rs.next()) {
			String username = rs.getString("username");
			String password = rs.getString("password");
			System.out.println("username = " + username);
			System.out.println("password = " + password);
		}
	}
}
