package cn.gbf.domain;
/*
 * 对应数据库中的薪资表
 */
public class Grade {
	private int chinese;
	private int math;
	private int english;
	public int getChinese() {
		return chinese;
	}
	public void setChinese(int chinese) {
		this.chinese = chinese;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	
}
