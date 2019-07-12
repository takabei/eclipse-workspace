package domain;

import java.util.List;

public class StuANDLess {
	private String slId;
	private Student stu;
	private Lesson less;
	public String getSlId() {
		return slId;
	}
	public void setSlId(String slId) {
		this.slId = slId;
	}
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	public Lesson getLess() {
		return less;
	}
	public void setLess(Lesson less) {
		this.less = less;
	}
	@Override
	public String toString() {
		return "StuANDLess [slId=" + slId + ", stu=" + stu + ", less=" + less + "]";
	}
	
	
}
