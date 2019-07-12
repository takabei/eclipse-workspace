package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import domain.Class;
import domain.College;
import utils.JdbcUtils;

public class CollegeDaoImpl {
	
	public int addColl(College coll) {
		String sql = "insert into college(collegeId,name) values(?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			 conn = JdbcUtils.getConnection();
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, coll.getCollegeId());
			 pstmt.setString(2, coll.getName());
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
