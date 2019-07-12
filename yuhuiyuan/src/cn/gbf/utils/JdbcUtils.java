package cn.gbf.utils;

import java.io.InputStream;

import java.sql.SQLException;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class JdbcUtils {
	private static DataSource ds = null;//数据库连接池
	static {
		try {
			InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			Properties prop = new Properties();
			prop.load(in);
			BasicDataSourceFactory factory = new BasicDataSourceFactory();//数据库连接池工厂
			ds = factory.createDataSource(prop);//创建数据库连接池
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static DataSource getDatasource() throws SQLException {
		return ds;
	}
}
