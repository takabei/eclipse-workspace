package cn.gbf.service.impl;

import cn.dao.GradeDao;
import cn.gbf.dao.impl.GradeDaoImpl;
import cn.gbf.domain.Student;
import cn.gbf.service.GradeService;

public class GradeServiceImpl implements GradeService{
	GradeDao gradeDao = new GradeDaoImpl();
	@Override
	public int add(Student student) {
		return gradeDao.addGrade(student);
	}

	@Override
	public int delete(String id) {
		return gradeDao.deleteGrade(id);
	}

	@Override
	public int update(Student student) {
		return gradeDao.updateGrade(student);
	}
		
}
