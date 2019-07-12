package service;

import java.util.List;

import dao.impl.ClassDaoImpl;
import dao.impl.LessonDaoImple;
import domain.Class;
import domain.Lesson;

public class LessonService {
	private LessonDaoImple  lessDao = new LessonDaoImple();

	public int addLesson(Lesson less) {
		return lessDao.addLess(less);
	}
}
