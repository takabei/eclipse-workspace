package com.DMModel;

public class Room {
  String id;
  String member;
  String leader;
  
 
  
public Room(String member) {
	super();
	this.member = member;
}

public Room() {
	super();
}
public Room(String id, String member, String leader) {
	super();
	this.id = id;
	this.member = member;
	this.leader = leader;
}
public Room(String member, String leader) {
	super();
	this.member = member;
	this.leader = leader;
}
public String getMember() {
	return member;
}
public void setMember(String member) {
	this.member = member;
}
public String getLeader() {
	return leader;
}
public void setLeader(String leader) {
	this.leader = leader;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String toString() {
	return this.getMember();
}
  
  
}
