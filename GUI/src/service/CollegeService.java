package service;

import java.util.List;

import dao.impl.ClassDaoImpl;
import dao.impl.CollegeDaoImpl;
import domain.Class;
import domain.College;

public class CollegeService {
	private CollegeDaoImpl  classDao = new CollegeDaoImpl();
	
	public int addColl(College coll) {
		return classDao.addColl(coll);
	}
}
