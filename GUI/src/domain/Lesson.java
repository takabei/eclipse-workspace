package domain;

import java.util.List;

public class Lesson {
	private String lessId;
	private String name;
	private Teacher teacher;
	public String getLessId() {
		return lessId;
	}
	public void setLessId(String lessId) {
		this.lessId = lessId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
}
