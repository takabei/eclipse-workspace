package com.Dao;



import java.sql.Connection;

import com.DMUtil.DMUtil;



public class BaseDao {
	public Connection con = new DMUtil().getCon();

}
