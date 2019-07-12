package domain;

import java.util.List;

public class Class {
	private String classId;
	private String name; 
	private College college;	//学院
	private List<Student> stuList;//学生
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	public List<Student> getStuList() {
		return stuList;
	}
	public void setStuList(List<Student> stuList) {
		this.stuList = stuList;
	}
	@Override
	public String toString() {
		return "Class [classId=" + classId + ", name=" + name + ", college=" + college + ", stuList=" + stuList + "]";
	}
	
}
