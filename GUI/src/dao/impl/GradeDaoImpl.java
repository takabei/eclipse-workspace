package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.commons.CommonUtils;
import domain.Grade;
import domain.Lesson;
import domain.StuANDLess;
import domain.Student;
import domain.User;
import utils.JdbcUtils;

public class GradeDaoImpl {
	private UserDaoImpl<User> daoImpl = new UserDaoImpl<User>();
	QueryRunner qr = new QueryRunner(JdbcUtils.getDB());
	
	public List<Grade> getAll(String... strs){
		
		String sql = "select slId from stuless where stuId = ?";
		List<Grade> gradeList = new ArrayList<Grade>();
		try {
			List<StuANDLess> squery = qr.query(sql, new BeanListHandler<StuANDLess>(StuANDLess.class), strs[0]);
			
			for(StuANDLess sl : squery) {
				sql = "select * from grade where slId = ?";
				List<Map<String, Object>> list = qr.query(sql, new MapListHandler(), sl.getSlId());
				
				for(Map map : list) {
					Grade grade = CommonUtils.toBean(map, Grade.class);
					StuANDLess sLess = new StuANDLess();
					sql = "select * from stuless where slId = ?";
					Map<String, Object> query = qr.query(sql, new MapHandler(), map.get("slId"));
					
					String stuId = ((Integer) query.get("stuId")).toString();
					Student stu = daoImpl.getStudent(stuId);
					sLess.setStu(stu);
					
					sql = "select * from lesson where lessId = ?";
					Lesson lesson = qr.query(sql, new BeanHandler<Lesson>(Lesson.class),query.get("lessId"));
					sLess.setLess(lesson);
					
					grade.setsLess(sLess);
					
					gradeList.add(grade);
				}		
			}
			
			return gradeList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;	
	}
	
	public List<Grade> getAll(){
		String sql = "select * from grade";
		try {
			List<Map<String, Object>> list = qr.query(sql, new MapListHandler());
			List<Grade> gradeList = new ArrayList<Grade>();
			for(Map map : list) {
				Grade grade = CommonUtils.toBean(map, Grade.class);
				StuANDLess sLess = new StuANDLess();
				sql = "select * from stuless where slId = ?";
				Map<String, Object> query = qr.query(sql, new MapHandler(), map.get("slId"));
				
				String stuId = ((Integer) query.get("stuId")).toString();
				Student stu = daoImpl.getStudent(stuId);
				sLess.setStu(stu);
				
				sql = "select * from lesson where lessId = ?";
				Lesson lesson = qr.query(sql, new BeanHandler<Lesson>(Lesson.class),query.get("lessId"));
				sLess.setLess(lesson);
				
				grade.setsLess(sLess);
				gradeList.add(grade);
			}
			return gradeList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int updateGrade(String lessid, String stuid, String lgrade) {
		String sql = "select slId from stuless where stuId = ? and lessId = ?";
		try {
			String slId = qr.query(sql, new ScalarHandler<Integer>(), stuid,lessid).toString();
			sql = "update grade set core = ? where slId = ?";
			return qr.update(sql,lgrade,slId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(String lessid, String stuid) {
		String sql = "select slId from stuless where stuId = ? and lessId = ?";
		try {
			String slId = qr.query(sql, new ScalarHandler<Integer>(), stuid,lessid).toString();
//			sql = "delete from stuless where slId = ?";
//			qr.update(sql, slId);
//			sql = "delete from grade where slId = ?";
//			return qr.update(sql,slId);
			sql = "update grade set core = ? where slId = ?";
			return qr.update(sql,0,slId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
