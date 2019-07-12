package cn.dao;

import cn.gbf.domain.Student;
/**
 * 数据库交互接口
 */
public interface  GradeDao {
	int addGrade(Student student);

	int deleteGrade(String id);

	int updateGrade(Student student);

}
