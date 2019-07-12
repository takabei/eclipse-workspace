package cn.gbf.service;

import cn.gbf.domain.Student;

public interface GradeService {
	int add(Student student);
	int delete(String id);
	int update(Student student);
}
