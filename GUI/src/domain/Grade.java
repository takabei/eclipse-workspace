package domain;

public class Grade {
	private String gradeId;
	private String core;
	private StuANDLess sLess;	//学生-课程
	public String getGradeId() {
		return gradeId;
	}
	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}
	public String getCore() {
		return core;
	}
	public void setCore(String core) {
		this.core = core;
	}
	public StuANDLess getsLess() {
		return sLess;
	}
	public void setsLess(StuANDLess sLess) {
		this.sLess = sLess;
	}
	@Override
	public String toString() {
		return "Grade [gradeId=" + gradeId + ", core=" + core + ", sLess=" + sLess + "]";
	}
	
	
}
