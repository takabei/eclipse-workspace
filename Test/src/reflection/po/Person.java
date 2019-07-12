package reflection.po;

public class Person {
	static {
		System.out.println("static person");
	}
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	public Person() {
		super();
		System.out.println("person 默认构造器");
		// TODO Auto-generated constructor stub
	}
	public void show() {
		System.out.println("我是一个人");
	}
	public void display(String nation) {
		System.out.println("我的国籍是"+nation);
	}
}
