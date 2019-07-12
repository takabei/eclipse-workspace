package cn.gbf.service;

import java.util.List;

import cn.gbf.domain.Student;
import cn.gbf.exceptioin.YuangongExistException;

public interface YuangongService {
	int addStudent(Student student) throws YuangongExistException;
	int deleteStudent(String id);
	int updateStudent(Student student);
	Student findStudent(String id);
	Student findStudent(String id,String password);
	List<Student> findAllStudent();
}
