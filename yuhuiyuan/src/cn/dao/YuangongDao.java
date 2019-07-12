package cn.dao;

import java.util.List;

import cn.gbf.domain.Student;
/**
 * 数据库交互接口
 */
public interface YuangongDao {
	int addStudent(Student student);

	int deleteStudent(String id);

	int updateStudent(Student student);

	Student queryStudent(String id);

	Student queryStudent(String id, String password);

	List<Student> queryAll();
}
