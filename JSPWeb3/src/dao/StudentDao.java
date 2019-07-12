package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import po.Student;


public class StudentDao {

	
	//根据页码获取当前页面的数据
		public List<Student> findByPage(int pagenow,int pagesize){
			// 连接数据，获取学生列表
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<Student> lists = new ArrayList<Student>();

			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = jdbcTest.getConnection();

				ps = conn.prepareStatement("select * from student order by id asc limit ?,? ");

				ps.setInt(1, (pagenow-1)* pagesize);
				ps.setInt(2, pagesize);
				rs = ps.executeQuery();
				// 取出rs中的每一行数据，在页面上进行呈现
				while (rs.next()) {
					// 获取rs行中的结果
					// 将每一行的数据，封装到一个结构中，Student Class
					Student stu = new Student();
					int id = rs.getInt("id");
					int depID = rs.getInt("depID");
					String userName = rs.getString("userName");
					String userPwd = rs.getString("userPwd");
					String userCode = rs.getString("userCode");
					String userSex = rs.getString("userSex");
					int userAge = rs.getInt("userAge");
					stu.setId(id);
					stu.setDepID(depID);
					stu.setUserName(userName);
					stu.setUserPwd(userPwd);
					stu.setUserCode(userCode);
					stu.setUserSex(userSex);
					stu.setUserAge(userAge);

					// 加入到集合中 java中集合 List Set Map
					lists.add(stu);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
			
			return lists;
		}
		
		//获取总共有多少条数据
		public int findTotal(){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select count(*) from student";
			int len = -1;
			try {
				con = jdbcTest.getConnection();
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					len = rs.getInt(1);
				}
				return len;
			} catch(Exception e) {
				System.out.println(e);
			} finally {
				if(rs != null)
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
			return len;
		}

}
