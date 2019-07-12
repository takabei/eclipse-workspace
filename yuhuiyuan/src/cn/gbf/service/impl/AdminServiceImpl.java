package cn.gbf.service.impl;

import cn.dao.AdminDao;
import cn.gbf.dao.impl.AdminDaoImpl;
import cn.gbf.domain.Teacher;
import cn.gbf.exceptioin.AdminExistException;
import cn.gbf.service.AdminService;
import cn.gbf.utils.Md5Utils;
/**
 * 管理员服务层
 * 	提供服务
 */
public class AdminServiceImpl implements AdminService{
	private AdminDao teacherDao = new AdminDaoImpl();//数据库交互的类
	@Override
	public int addTeacher(Teacher teacher) throws AdminExistException{
		if(teacherDao.findTeacher(teacher.getId()) != null){//当id存在不为空时
			throw new AdminExistException();//抛出自定义异常
		}else{
			teacher.setPassword(Md5Utils.md5(teacher.getPassword()));//加密密码
			return teacherDao.addTeacher(teacher);
		}
		
	}

	@Override
	/*
	 * 通过用户名和密码查找某个用户
	 * 返回一个用户实体
	 */
	public Teacher findTeacher(Teacher teacher) {//Md5Utils是加密算法
		return teacherDao.findTeacher(teacher.getId(), Md5Utils.md5(teacher.getPassword()));
	}
	
}
