package com.DMUtil;






import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DMUtil {
	//private String url = "jdbc:mysql://localhost:3306/dormitory";
  private String url = "jdbc:mysql://localhost:3306/GUI?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&autoReconnect=true&useSSL=true";
  private String userName = "root";
  private String userPassword = "54894liuyi";
  private String jdbcName = "com.mysql.jdbc.Driver";
  
  public Connection getCon() {
	  try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  Connection con = null;
	try {
		con = DriverManager.getConnection(url,userName,userPassword);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return con;
  }
  public void closeCon(Connection con) throws Exception{
	  if(con!=null){
		  con.close();
	  }
  }
  public static void main(String[] args){
	  DMUtil dmutil = new DMUtil();
	  Connection con = null;
	  try {
		con = dmutil.getCon();
		System.out.println("���ݿ����ӳɹ���");
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		try {
			dmutil.closeCon(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
  }
}




