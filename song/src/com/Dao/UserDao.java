package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.DMModel.User;



public class UserDao {
  public User Login(Connection con,User user) throws Exception{
	  User currentuser = null;
	  String sql =  "select * from d_user where userName=? and userPassword=?";
	  PreparedStatement pstmt = con.prepareStatement(sql);
	  pstmt.setString(1,user.getUserName());
	  pstmt.setString(2,user.getUserPassword());
	  ResultSet rs = pstmt.executeQuery();
	  while(rs.next()){
		 currentuser = new User();
		 currentuser.setUserName(rs.getString("userName"));
		 currentuser.setUserPassword(rs.getString("userPassword"));
	  }
	return currentuser;
  }
}
