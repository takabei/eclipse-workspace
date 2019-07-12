package cn.gbf.service.impl;

import java.util.List;

import cn.dao.YuangongDao;
import cn.gbf.dao.impl.YuangongDaoImpl;
import cn.gbf.domain.Student;
import cn.gbf.exceptioin.YuangongExistException;
import cn.gbf.service.YuangongService;
import cn.gbf.utils.Md5Utils;

public class YuangongServiceImpl implements YuangongService{
	private YuangongDao studentDao = new YuangongDaoImpl();
	@Override
	public int addStudent(Student student) throws YuangongExistException {
		Student queryStudent = studentDao.queryStudent(student.getId());//通过员工的id查看
		if(queryStudent == null){
			student.setPassword(Md5Utils.md5(student.getPassword()));//md5算法加密
			return studentDao.addStudent(student);
		}else{
			throw new YuangongExistException();
		}
	}

	@Override
	public int deleteStudent(String id) {
		return studentDao.deleteStudent(id);
	}

	@Override
	public int updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}

	@Override
	public Student findStudent(String id) {
		return studentDao.queryStudent(id);
	}

	@Override
	public Student findStudent(String id, String password) {
		password = Md5Utils.md5(password);
		return studentDao.queryStudent(id, password);
	}

	@Override
	public List<Student> findAllStudent() {
		return  studentDao.queryAll();
	}

}
