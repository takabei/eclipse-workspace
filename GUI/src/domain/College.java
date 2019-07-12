package domain;

import java.util.List;

public class College {
	private String name;
	private String collegeId;
	private List<Class> clazzList;//班级
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}
	public List<Class> getClazzList() {
		return clazzList;
	}
	public void setClazzList(List<Class> clazzList) {
		this.clazzList = clazzList;
	}
	
}
