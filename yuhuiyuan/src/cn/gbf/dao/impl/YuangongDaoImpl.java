package cn.gbf.dao.impl;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.dao.YuangongDao;
import cn.gbf.domain.Grade;
import cn.gbf.domain.Student;
import cn.gbf.utils.JdbcUtils;
/*
 * 数据库交互层
 */
public class YuangongDaoImpl implements YuangongDao {

	@Override
	/*
	 * 返回整数：返回数据库被影响的行数（0，1）
	 * 0代表操作失败
	 * 1代表操作成功
	 */
	public int addStudent(Student student) {
		try {//QueryRunner jdbc工具类
			/*
			 * 获取数据库连接池：JdbcUtils.getDatasource()
			 * 
			 */
			QueryRunner runner = new QueryRunner(JdbcUtils.getDatasource());
			String sql = "insert into student values (?,?,?,?,?,?)";//sql语句添加一行
			Object[] params = new Object[] {
					student.getId(), student.getPassword(), student.getName(),
					student.getSex(), student.getAge(), student.getCollage() 
					};
			return runner.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	/*
	 * delete
	 * update
	 * insert
	 * runner.update（）方法执行
	 * 一个问号对应一个参数
	 */
	public int deleteStudent(String id) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDatasource());
			String sql = "delete from student where id = ?";//sql删除语句
			Object[] params = new Object[] {
					id 
				};
			return runner.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int updateStudent(Student student) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDatasource());
			String sql = "update student set password = ?,name = ?, sex = ?, age = ?, collage = ? where id = ?";
			Object[] params = new Object[] {
					student.getPassword(), student.getName(), student.getSex(),
					student.getAge(), student.getCollage(), student.getId() 
			};
			return runner.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	/*
	 * 查找：select
	 * runner.select()
	 * new BeanHandler<>(类的类型)代表的是单个类（把数据库中的一行封装成一个类）
	 * BeanListHandler：代表的是类的集合（把数据库中的多行封装成多个类并放入一个集合中）
	 */
	public Student queryStudent(String id) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDatasource());
			String sql = "select * from student where id = ?";//sql语句查找（通过id）
			Object[] params = new Object[] { id };
			Student student = runner.query(sql, params, new BeanHandler<>(Student.class));

			// ��ѯ�ɼ�
			sql = "select * from grade where fk_id = ?";
			Grade grade = runner.query(sql, params, new BeanHandler<>(Grade.class));
			if (grade != null)
				student.setGrade(grade);

			return student;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Student queryStudent(String id, String password) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDatasource());
			String sql = "select * from student where id = ? and password = ?";
			Object[] params = new Object[] { id, password };
			return runner.query(sql, params, new BeanHandler<>(Student.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Student> queryAll() {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDatasource());
			String sql = "select * from student";
			Object[] params = null;
			List<Student> list = runner.query(sql, params, new BeanListHandler<>(Student.class));

			// ��ѯ�ɼ�
			for (Student student : list) {//foreach语句
				sql = "select * from grade where fk_id = ?";
				params = new Object[] { student.getId() };
				Grade grade = runner.query(sql, params, new BeanHandler<>(Grade.class));
				student.setGrade(grade);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
