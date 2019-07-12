package project;

public class Outter {
	private String name;
	private Integer Oage;
	private Inner inner;
	class Inner{
		private String name;
		private Integer age;
	}
	public void play() {
		System.out.println(inner.name);
	}
}
