package domain;

public class User {
	private String table;
	private String name;
	private String password;
	public User(String table, String name, String password) {
		this.table = table;
		this.name = name;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	
	@Override
	public String toString() {
		return "User [table=" + table + ", name=" + name + ", password=" + password + "]";
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
