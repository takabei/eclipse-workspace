package dao.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;

import utils.JdbcUtils;

public class StuAndLessDao {
	private QueryRunner qr = new QueryRunner(JdbcUtils.getDB());
	
	public void addstuandless(String stuId, String lessId) {
		System.out.println("添加关系 stuId = " + stuId + " lessId = " + lessId);
		String sql = "insert into stuless (slId,stuId,lessId) values(?,?,?)";
		String slId = new SimpleDateFormat("ssSS").format(new Date());
		Object[] params = {
				slId,stuId,lessId
		};
		try {
			qr.update(sql,params);
			sql = "insert into grade (gradeId,core,slId) values(?,?,?)";
			Object[] param = {
					new SimpleDateFormat("SSss").format(new Date()),"0",slId
			};
			qr.update(sql,param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
