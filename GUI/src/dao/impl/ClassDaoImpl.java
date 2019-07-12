package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import domain.Class;
import domain.User;
import utils.JdbcUtils;

public class ClassDaoImpl {
	
	
	public Class findClass(String str) {
		String sql = "select * from class where name like ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Class clazz = null;
		try {
			 conn = JdbcUtils.getConnection();
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, str);
			 rs = pstmt.executeQuery();			 
			 while(rs.next()) {
				 clazz = new Class();
				 clazz.setClassId(""+rs.getInt("classId"));
				 clazz.setName(rs.getString("name"));
			 }
			 return clazz;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int addClass(Class clazz) {
		String sql = "insert into class(classId,name,collegeId) values(?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			 conn = JdbcUtils.getConnection();
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, clazz.getClassId());
			 pstmt.setString(2, clazz.getName());
			 pstmt.setString(3, clazz.getCollege().getCollegeId());
			 return pstmt.executeUpdate();
		} catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public  List<String> getNameAll(){
		String sql = "select name from class";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> list = null;
		try {
			conn= JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<String>();
			while(rs.next()) {
				list.add(rs.getString("name"));
			}
			return list;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
