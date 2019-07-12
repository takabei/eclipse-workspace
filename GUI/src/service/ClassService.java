package service;

import java.util.List;

import dao.impl.ClassDaoImpl;
import domain.Class;

public class ClassService {
	private ClassDaoImpl  classDao = new ClassDaoImpl();

	public List<String> getList() {
		return classDao.getNameAll();
	}
	
	public int addClass(Class clazz) {
		return classDao.addClass(clazz);
	}

	public Class findClass(String obj) {
		return classDao.findClass(obj);
	}
}
