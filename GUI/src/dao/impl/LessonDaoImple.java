package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import domain.Class;
import domain.College;
import domain.Lesson;
import utils.JdbcUtils;

public class LessonDaoImple {
	
	public int addLess(Lesson less) {
		String sql = "insert into lesson(lessId,teaId,name) values(?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			 conn = JdbcUtils.getConnection();
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, less.getLessId());
			 pstmt.setString(2, less.getTeacher().getTeaId());
			 pstmt.setString(3, less.getName());
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
	
	
}
