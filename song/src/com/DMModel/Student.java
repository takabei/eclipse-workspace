package com.DMModel;

public class Student {
  int  id;
  String name;
  String sex;
  String yuanxi;
  String classroom;
  int dormitory=-1;
  int bed;
  
  
  
public Student(String name) {
	super();
	this.name = name;
}
public Student(int id, String name, String sex, String yuanxi,
		String classroom, int dormitory, int bed) {
	super();
	this.id = id;
	this.name = name;
	this.sex = sex;
	this.yuanxi = yuanxi;
	this.classroom = classroom;
	this.dormitory = dormitory;
	this.bed = bed;
}
public Student(String name, String sex, String yuanxi, String classroom,
		int dormitory, int bed) {
	super();
	this.name = name;
	this.sex = sex;
	this.yuanxi = yuanxi;
	this.classroom = classroom;
	this.dormitory = dormitory;
	this.bed = bed;
}
public Student() {
	super();
}
public Student(String name, String sex, String yuanxi, String classroom,
		int dormitory) {
	super();
	this.name = name;
	this.sex = sex;
	this.yuanxi = yuanxi;
	this.classroom = classroom;
	this.dormitory = dormitory;
	this.bed = bed;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getYuanxi() {
	return yuanxi;
}
public void setYuanxi(String yuanxi) {
	this.yuanxi = yuanxi;
}
public String getClassroom() {
	return classroom;
}
public void setClassroom(String classroom) {
	this.classroom = classroom;
}
public int getDormitory() {
	return dormitory;
}
public void setDormitory(int dormitory) {
	this.dormitory = dormitory;
}
public int getBed() {
	return bed;
}
public void setBed(int bed) {
	this.bed = bed;
}

  
}
