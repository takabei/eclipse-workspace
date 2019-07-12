package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Student;
import utils.PageBean;

public class StudentDao {
	
	public PageBean<Student> findByPage(int pagenow){
		int tr = findTotal();
		int pagesize = 25;
		String sql = "select * from student order by depID limit ?,?";
		PreparedStatement pstmt = null;
		PageBean<Student> pb = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			pstmt = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/shop", "root", "").prepareStatement(sql);
			pstmt.setInt(1, (pagenow-1)*pagesize);
			pstmt.setInt(2, pagesize);
			ResultSet rs = pstmt.executeQuery();
			
			pb = new PageBean<Student>();
			pb.setBeanList(getStudent(rs));
			pb.setPc(pagenow);
			pb.setPs(pagesize);
			pb.setTr(tr);
			
			return pb;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e){
			System.out.println(e);
		}finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pb;
		
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
	
	//获取总共有多少条数据
		public int findTotal(){
			int res = 0;
			// 连接数据，获取学生列表
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/shop", "root", "");

				ps = conn.prepareStatement("select count(*) as total  from student");

				rs = ps.executeQuery();
				// 取出rs中的每一行数据，在页面上进行呈现
				if (rs.next()) {
					res = rs.getInt("total");
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					// 回收资源
					if (rs != null) {
						rs.close();
					}

					if (ps != null) {
						ps.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			return res;
		}
	
	
	
}
