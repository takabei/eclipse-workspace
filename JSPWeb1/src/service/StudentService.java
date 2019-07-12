package service;

import java.sql.SQLException;

import damain.Student;
import dao.StudentDao;
import utils.PageBean;

public class StudentService {
	StudentDao studentDao = new StudentDao();

	public PageBean<Student> findList(int pc) {
		try {
			return  studentDao.findByCriteria(pc);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
