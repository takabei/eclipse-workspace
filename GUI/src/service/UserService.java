package service;

import java.util.List;

import dao.impl.UserDaoImpl;
import domain.Student;
import domain.Teacher;
import domain.User;

public class UserService{
	private UserDaoImpl<User> userDao = new UserDaoImpl<User>();
	
	public int Login(String table, String username, String password) {
		User user = new User(table, username, password );
		return userDao.Login(user);
	}

	public int updateUserPass(String table, String tun, String top, String tnp) {
		User user = new User(table, tun, top );
		return userDao.updateUserPass(user, tnp);
	}

	public Teacher findTeacher(Teacher user) {
		return userDao.findTeacher(user);
	}

	public int findStudent(String tsid) {
		return userDao.findStudent(tsid);
	}

	public int addStudent(Student stu) {
		return userDao.addStudent(stu);
	}
	
	public int addStudent1(Student stu) {
		return userDao.addStudent1(stu);
	}

	public int addTeacher(Teacher tea) {
		return userDao.addTeacher(tea);
	}

	public List<Student> getstuAll() {
		return userDao.getStudentAll();
	}

	public List<Teacher> getteaAll() {
		return userDao.getTeacherAll();
	}

	public int updateTeacher(Teacher tea) {
		return userDao.updateTeacher(tea);
	}

	public int deleteTeacher(String tea) {
		return userDao.deleteTeacher(tea);
	}

	public int updateStudent(Student test) {
		return userDao.updateStudent(test);
	}

	public int deleteStudent(String stuId) {
		return userDao.deleteStudent(stuId);
	}

	public Student getStudent(String sstuId) {
		return userDao.getStudent(sstuId);
	}
	
}
