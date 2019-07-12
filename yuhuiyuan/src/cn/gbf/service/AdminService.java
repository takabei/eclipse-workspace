package cn.gbf.service;

import cn.gbf.domain.Teacher;
import cn.gbf.exceptioin.AdminExistException;

/**
 * 管理员服务接口
 * 一类规范
 *
 */
public interface AdminService {
	int addTeacher(Teacher teacher) throws AdminExistException ;
	Teacher findTeacher(Teacher teacher);
}
