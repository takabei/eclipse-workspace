package domain;

import java.util.List;

public class Teacher extends User {
	private String teaId;
	private List<Lesson> lessList;
	private String sex;
	private String major;
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Teacher(String table, String username, String password) {
		super(table,username,password);
	}

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTeaId() {
		return teaId;
	}

	public void setTeaId(String teaId) {
		this.teaId = teaId;
	}

	public List<Lesson> getLessList() {
		return lessList;
	}

	public void setLessList(List<Lesson> lessList) {
		this.lessList = lessList;
	}

	@Override
	public String toString() {
		return "Teacher [teaId=" + teaId + ", lessList=" + lessList + ", sex=" + sex + ", major=" + major + "] " + super.toString();
	}
	
	
}
