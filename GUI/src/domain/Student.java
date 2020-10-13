package domain;

import java.util.List;

public class Student extends User{
	private String stuId;
	private Class clazz;
	private String sex;
	private String tel;
	private String email;
	private String address;
	
	
	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", clazz=" + clazz + ", sex=" + sex + ", tel=" + tel + ", email=" + email
				+ ", address=" + address + "]";
	}

	public Student(String table, String username, String password) {
		super(table,username,password);
	}

	public Student() {
		super();
	}
	
}