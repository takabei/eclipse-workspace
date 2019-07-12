

public class User {
	String name = "";
	String pass = "";
	String count = "";
	public String getName() {
		int i = 8;
		boolean b = i % 5 == 0; 
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", pass=" + pass + ", count=" + count + "]";
	}
	
}
