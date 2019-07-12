package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import domain.Class;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import cn.itcast.commons.CommonUtils;
import domain.Admin;
import domain.Student;
import domain.Teacher;
import domain.User;
import utils.JdbcUtils;

public class UserDaoImpl<T extends User> {
	QueryRunner qr = new QueryRunner(JdbcUtils.getDB());
	
	public Student getStudent(String stuId) {
		String sql = "select * from student where stuId = ?";
		try {
			Map<String, Object> map = qr.query(sql, new MapHandler(), stuId);
			sql = "select * from class where classId = ?";
			Class clazz = qr.query(sql, new BeanHandler<Class>(Class.class), map.get("classId"));
			Student stu = CommonUtils.toBean(map, Student.class);
			stu.setClazz(clazz);
			return stu;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public List<Teacher> getTeacherAll(){
		String sql = "select * from teacher";
		try {
			List<Teacher> query = qr.query(sql, new BeanListHandler<Teacher>(Teacher.class));
			return query;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Student> getStudentAll(){
		String sql = "select * from student";
		try {
			List<Map<String, Object>> query = qr.query(sql, new MapListHandler());
			sql = "select * from class where classId = ?";
			List<Student> list = new ArrayList<Student>();
			for(Map map : query) {
				Student bean = CommonUtils.toBean(map, Student.class);
				bean.setClazz(qr.query(sql, new BeanHandler<domain.Class>(domain.Class.class),map.get("classId")));
				list.add(bean);			
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int addStudent1(Student stu) {
		String sql = "insert into student (stuId,classId,name,password,sex,tel,address) values(?,?,?,?,?,?,?)";
//		String sql = "insert into student (stuId,name) values(?,?)";
					//insert into teacher (teaId,name,password) values(?,?,?)
//		Object[] params = {
//			stu.getStuId(),stu.getName()	
//		};
		Object[] params = {
				stu.getStuId(),	stu.getClazz().getClassId(),stu.getName(),stu.getPassword(),
				stu.getSex(),stu.getTel(),stu.getAddress()
		};
		try {
			return qr.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int addStudent(Student stu) {	
		String sql = "insert into student (stuId,classId,name,password,sex,tel,address) values(?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stu.getStuId());
			pstmt.setString(2, stu.getClazz().getClassId());
			pstmt.setString(3, stu.getName());
			pstmt.setString(4, stu.getPassword());
			pstmt.setString(5, stu.getSex());
			pstmt.setString(6, stu.getTel());
			pstmt.setString(7, stu.getAddress());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Teacher findTeacher(Teacher user) {
		String sql = "select * from " + user.getTable() + " where teaId = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Teacher tea = null;
		try {
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getTeaId());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				tea = new Teacher();
				tea.setTeaId(rs.getString("teaId"));
				tea.setName(rs.getString("name"));
				tea.setMajor(rs.getString("major"));
				tea.setPassword(rs.getString("password"));
			}
			return tea;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public int updateUserPass(T user, String tnp) {
		String sql = "update " + user.getTable() + " set password = ? where name = ? and password = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tnp);
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPassword());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 登陆方法
	 * 
	 * @param user
	 * @return
	 */
	public int Login(T user) {// 根据传入的表名和用户名以及密码进行校验
		String sql = "select count(*) from " + user.getTable() + " where name = ? and password = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPassword());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int num = rs.getInt(1);
				return num;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}


	public int findStudent(String tsid) {
		String sql = "select count(*) from student where stuId = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tsid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		}catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public int addTeacher(Teacher tea) {
		String sql = "insert into teacher (teaId,name,password) values(?,?,?)";
		Object[] params = {
			tea.getTeaId(),tea.getName(),tea.getPassword()	
		};
		try {
			return qr.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int updateTeacher(Teacher tea) {
		String sql = "update " + tea.getTable() + " set name = ?, password = ?, sex = ?, major = ? where teaId = ?";
		Object[] params = {
				tea.getName(),tea.getPassword(),tea.getSex(),tea.getMajor(),tea.getTeaId()
		};
		try {
			return qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int deleteTeacher(String tea) {
		String sql = "delete from teacher where teaId = ?";
		try {
			return qr.update(sql, tea);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int updateStudent(Student test) {
		String sql = "update student set name = ?, classId = ?, password = ?,"
				+ " sex = ?, tel = ?, address = ? where "
				+ "stuId = ?";
		Object[] params = {
			test.getName(),test.getClazz().getClassId(),test.getPassword(),	
			test.getSex(),test.getTel(),test.getAddress(),test.getStuId()
		};
		try {
			return qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int deleteStudent(String stuId) {
		String sql = "delete from student where stuId = ?";
		try {
			return qr.update(sql, stuId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
