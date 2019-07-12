package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import damain.Student;
import utils.JdbcUtils;
import utils.PageBean;
import utils.PageConstants;

public class StudentDao {
	JdbcUtils ju = new JdbcUtils();
	
	public PageBean<Student> findByCriteria(int pc) throws SQLException{
		int tr = count();
		int ps = PageConstants.BOOK_PAGE_SIZE;
		String sql = "select * from student order by depID limit ?,?";
		PreparedStatement pstmt = ju.getConnection().prepareStatement(sql);
		ju.setParams(pstmt, (pc-1)*ps, ps);
		ResultSet rs = pstmt.executeQuery();
		
		PageBean<Student> pb = new PageBean<Student>();
		pb.setBeanList(getStudent(rs));
		pb.setPc(pc);
		pb.setPs(ps);
		pb.setTr(tr);
		
		return pb;
		
	}
	
	//获取总记录书
	private int count() {
		String sql = " SELECT count(*) FROM student";
		int tr = -1;
		try {
			tr = ju.getCount(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tr;
	}
	
	private List<Student> getStudent(ResultSet rs) throws SQLException{
		List<Student> list = new ArrayList<Student>();
		while(rs.next()) {
			Student student = new Student();
			student.setId(rs.getInt("id"));
			student.setDepID(rs.getInt("depID"));
			student.setUserName(rs.getString("userName"));
			student.setUserPwd(rs.getString("userPwd"));
			student.setUserCode(rs.getString("userCode"));
			student.setUserSex(rs.getString("userSex"));
			student.setUserAge(rs.getInt("userAge"));
			list.add(student);
		}
		return list;
	}
	
	/**
	 * 获取全部书籍
	 * @return
	 * @throws SQLException
	 */
	public List<Student> findAll(){
		Connection conn = null;
		String sql = "";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ju.getConnection();
			sql = "select * from student";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			return getStudent(rs);
		} catch(SQLException e) {
			System.out.println(e);
		} finally {
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return null;
		
	
	}
	
}
