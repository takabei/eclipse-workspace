package cn.gbf.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.dao.AdminDao;
import cn.gbf.domain.Teacher;
import cn.gbf.utils.JdbcUtils;
/*
 * 数据库交互类的实现类
 */
public class AdminDaoImpl implements AdminDao {

	@Override
	/*
	 * 添加用户
	 * 参数：一个teacher类的实体
	 * 返回整数：返回数据库被影响的行数（0，1）
	 * 0代表操作失败
	 * 1代表操作成功
	 * 
	 */
	public int addTeacher(Teacher teacher) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDatasource());
			String sql = "insert into teacher values (?,?)";
			Object[] params = new Object[] { teacher.getId(), teacher.getPassword() };
			return runner.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	/*
	 * 根据用用户名和密码查询用户是否存在
	 * 返回一个teacher用户（管理员）
	 * 
	 */
	public Teacher findTeacher(String id, String password) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDatasource());
			String sql = "select * from teacher where id = ? and password = ?";
			Object[] params = new Object[] {id,password };
			return runner.query(sql, params,new BeanHandler<Teacher>(Teacher.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * 通过用户名和密码查找某个用户
	 * 返回一个用户实体
	 */
	public Teacher findTeacher(String id) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDatasource());
			String sql = "select * from teacher where id = ?";
			Object[] params = new Object[] {id};
			return runner.query(sql, params,new BeanHandler<Teacher>(Teacher.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
