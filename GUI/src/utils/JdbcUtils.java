package utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import com.mysql.jdbc.Driver;

public class JdbcUtils {
	private static BasicDataSource bs = new BasicDataSource();
	public static BasicDataSource getDB() {
		bs.setDriverClassName("com.mysql.jdbc.Driver");
		bs.setUrl("jdbc:mysql://127.0.0.1:3306/GUI?characterEncoding=UTF8");
		bs.setUsername("root");
		bs.setPassword("54894liuyi");
		//2、设置连接是否默认自动提交
		bs.setDefaultAutoCommit(true);
		//3、设置初始后连接数
		bs.setInitialSize(3);
		//4、设置最大的连接数
		bs.setMaxActive(5);
		//5、设置空闲等待时间，获取连接后没有操作开始计时，到达时间后没有操作回收链接
		bs.setMaxIdle(3000);
		return bs;
	}
	/**
	 * 获取默认数据库连接
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return getConnection("GUI", "root", "54894liuyi");
	}
	
	/**
	 * 获取数据库连接
	 * 
	 * @param dbName
	 * @param userName
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection(String dbName, String userName,
			String password) throws SQLException {

		String url = "jdbc:mysql://localhost:3306/" + dbName + "?characterEncoding=utf8";

		DriverManager.registerDriver(new Driver());

		return DriverManager.getConnection(url, userName, password);
	}

	/**
	 * 设置 PreparedStatement 参数
	 * 
	 * @param preStmt
	 * @param params
	 * @throws SQLException
	 */
	public static void setParams(PreparedStatement preStmt, Object... params)
			throws SQLException {

		if (params == null || params.length == 0)
			return;

		for (int i = 1; i <= params.length; i++) {
			Object param = params[i - 1];
			if (param == null) {
				preStmt.setNull(i, Types.NULL);
			} else if (param instanceof Integer) {
				preStmt.setInt(i, (Integer) param);
			} else if (param instanceof String) {
				preStmt.setString(i, (String) param);
			} else if (param instanceof Double) {
				preStmt.setDouble(i, (Double) param);
			} else if (param instanceof Long) {
				preStmt.setDouble(i, (Long) param);
			} else if (param instanceof Timestamp) {
				preStmt.setTimestamp(i, (Timestamp) param);
			} else if (param instanceof Boolean) {
				preStmt.setBoolean(i, (Boolean) param);
			} else if (param instanceof Date) {
				preStmt.setDate(i, (Date) param);
			}
		}
	}
	

	/**
	 * 执行 SQL，返回影响的行数
	 * 
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public static int executeUpdate(String sql) throws SQLException {
		return executeUpdate(sql, new Object[] {});
	}

	/**
	 * 带参数执行SQL，返回影响的行数
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public static int executeUpdate(String sql, Object... params)
			throws SQLException {

		Connection conn = null;
		PreparedStatement preStmt = null;

		try {
			conn = getConnection();

			preStmt = conn.prepareStatement(sql);

			setParams(preStmt, params);

			return preStmt.executeUpdate();

		} finally {
			if (preStmt != null)
				preStmt.close();
			if (conn != null)
				conn.close();
		}
	}

	/**
	 * 获取总数。
	 * 
	 * @param sql
	 *            格式必须为 SELECT count(*) FROM ...
	 * @return
	 * @throws SQLException
	 */
	public static int getCount(String sql) throws SQLException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			return rs.getInt(1);
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
	}

	
}
