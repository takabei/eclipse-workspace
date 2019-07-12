package cn.dao;

import cn.gbf.domain.Teacher;
/**
 * 数据库交互接口
 */
public interface AdminDao {
	int addTeacher(Teacher teacher);
	Teacher findTeacher(String id,String password);
	Teacher findTeacher(String id);
}
