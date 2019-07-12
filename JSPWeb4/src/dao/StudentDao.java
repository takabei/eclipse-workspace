package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import po.PageBean;
import po.Student;

public class StudentDao {
	
	  public PageBean findPage(int pageCode) {
		  PageBean pageBean = new PageBean();
		  pageBean.setPageCode(pageCode);
		  pageBean.setTotal(count());
		  String sql = "select * from student limit ?,?";
		  Connection connection = null;
		  PreparedStatement preparedStatement = null;
		  ResultSet rs = null;
		  List<Student> studentList = new ArrayList<Student>();
		  try {
			  Class.forName("com.mysql.jdbc.Driver");
			  connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/shop", "root", "");
			  preparedStatement = connection.prepareStatement(sql);
			  preparedStatement.setInt(1, (pageCode -1)*pageBean.pageSize);
			  preparedStatement.setInt(2, pageBean.pageSize);
			  rs = preparedStatement.executeQuery();
			  while(rs.next()) {
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
					studentList.add(stu);
			  }
			  pageBean.setList(studentList);
			  return pageBean;
		  }catch(Exception e) {
			  System.out.println(e);
		  } finally {
			  try {
				  if(null != rs)
					  rs.close();
				  if(null != preparedStatement)
					  preparedStatement.close();
				  if(null != connection)
					  connection.close();
			  } catch(Exception e) {
				  System.out.println(e);
			  }
		  }
		  
		return pageBean;
	  }

	  
	  private int count() {
		  String sql = "select count(*) from student";
		  Connection connection = null;
		  PreparedStatement preparedStatement = null;
		  ResultSet rs = null;
		  try {
			  Class.forName("com.mysql.jdbc.Driver");
			  connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/shop", "root", "");
			  preparedStatement = connection.prepareStatement(sql);
			  rs = preparedStatement.executeQuery();
			  while(rs.next()) {
				  return rs.getInt(1);
			  }
		  }catch(Exception e) {
			  System.out.println(e);
		  } finally {
			  try {
				  if(null != rs)
					  rs.close();
				  if(null != preparedStatement)
					  preparedStatement.close();
				  if(null != connection)
					  connection.close();
			  } catch(Exception e) {
				  System.out.println(e);
			  }
		  }
		  return -1;
	  }
}
