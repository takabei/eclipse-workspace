package service;

import java.util.List;

import dao.impl.GradeDaoImpl;
import domain.Grade;

public class GradeService {
	private GradeDaoImpl daoImpl = new GradeDaoImpl();
	
	public List<Grade> getAll(String...strs){
		if(strs.length == 0)
			return daoImpl.getAll();
		else 
			return daoImpl.getAll(strs);
	}

	public int updateGrade(String lessid, String stuid, String lgrade) {
		return daoImpl.updateGrade(lessid,stuid,lgrade);
	}

	public int delete(String lessid, String stuid) {
		return daoImpl.delete(lessid,stuid);
	}
}
