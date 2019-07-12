package cn.gbf.dao.impl;  
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import cn.dao.GradeDao;
import cn.gbf.domain.Student;
import cn.gbf.utils.JdbcUtils;

public class GradeDaoImpl implements GradeDao {

	@Override
	public int addGrade(Student student) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDatasource());
			String sql = "insert into grade values (?,?,?,?)";
			Object[] params = new Object[] { student.getId(), student.getGrade().getChinese(),
					student.getGrade().getMath(), student.getGrade().getEnglish() };
			return runner.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int deleteGrade(String id) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDatasource());
			String sql = "delete from grade where fk_id = ?";
			Object[] params = new Object[] { id };
			return runner.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int updateGrade(Student student) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDatasource());
			String sql = "update student set chinese = ?,math = ?, english = ? where fk_id = ?";
			Object[] params = new Object[] { student.getGrade().getChinese(), student.getGrade().getMath(),
					student.getGrade().getEnglish(), student.getId()};
			return runner.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
