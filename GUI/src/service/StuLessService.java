package service;

import dao.impl.StuAndLessDao;

public class StuLessService {
	private  StuAndLessDao andLessDao = new StuAndLessDao();
	public void addstuandless(String stuId, String lessId) {
		andLessDao.addstuandless(stuId, lessId);
	}
}
