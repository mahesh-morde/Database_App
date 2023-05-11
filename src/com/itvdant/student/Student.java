package com.itvdant.student;

public class Student {
	private int ID;
	private String name;
	private int Age;
	private float Marks;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public float getMarks() {
		return Marks;
	}
	public void setMarks(float marks) {
		Marks = marks;
	}
	
	
	@Override
	public String toString() {
		return "Student [ID=" + ID + ", name=" + name + ", Age=" + Age + ", Marks=" + Marks + "]";
	}
	
	

}
