package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.DMModel.Room;
import com.DMUtil.StringUtil;


public class RoomDao {
  public int roomAdd(Connection con,Room room) throws Exception{
	  String sql = "insert into room_message values(null,?,?)";
	  PreparedStatement pstmt = con.prepareStatement(sql);
	  pstmt.setString(1,room.getMember());
	  pstmt.setString(2, room.getLeader());
	  return pstmt.executeUpdate();
  }
  public ResultSet roomList(Connection con,Room room) throws Exception{
	  StringBuffer sb =new StringBuffer("select * from room_message");
	  if(StringUtil.isNotEmpty(room.getMember())){
		  String member =room.getMember();
		   sb.append(" and member like '%"+ room.getMember()+"%'");
	  }
	  PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
	  return pstmt.executeQuery();
  }
  public int roomModify(Connection con,Room room)throws Exception{
	  String sql = "update room_message set member=?,leader=? where id=?";
	  PreparedStatement pstmt = con.prepareStatement(sql);
	  pstmt.setString(1,room.getMember());
	  pstmt.setString(2,room.getLeader());
	  pstmt.setString(3,room.getId());
	  return pstmt.executeUpdate();  
	  }
  public int roomDelete(Connection con ,Room room)throws Exception{
	  String sql = "delete from room_message where member=?";
	  PreparedStatement pstmt = con.prepareStatement(sql);
	  pstmt.setString(1,room.getMember());
	  return pstmt.executeUpdate();
  }
}
