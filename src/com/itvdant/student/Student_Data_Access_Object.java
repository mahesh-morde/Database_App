package com.itvdant.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Student_Data_Access_Object {
	static Connection con = Database_Connection.getConnection();
	
	public List<Student> getRecord(){
		List <Student> student = new ArrayList <Student>();
		String Query = "Select * from student";
		
		try {
			Statement stats = con.createStatement();
			ResultSet rs = stats.executeQuery(Query);
			
			while (rs.next()) {
				Student s = new Student();
				
				s.setID(rs.getInt("ID"));
				s.setAge(rs.getInt("Age"));
				s.setName(rs.getString("name"));
				s.setMarks(rs.getFloat("Marks"));
				student.add(s);
			}	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return student;		
	}		

		public boolean Createecord (String name, int age, float marks) {
			String query = "insert into student(name, Age, Marks) values(?,?,?)";
		
			try {
				PreparedStatement ps = con.prepareStatement(query);
				
				ps.setString(1, name);
				ps.setInt(2, age);
				ps.setFloat(3, marks);
				
				int i = ps.executeUpdate();
				
				if(i>0) {
					return true;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return(false);
		}
		
		public boolean DeleteRecord(int id) {
			String query = "delete from student where ID = ?";
			
			try {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1,id);
				
				int i = ps.executeUpdate();
				
				if(i>0) {
					return true;
				}
	
			}catch(Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		
		public Student SearchRecord(String name) {
			Student s = null;
			
			String query = "select * from Student where name = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				s = new Student();
				s.setAge(rs.getInt("Age"));
				s.setMarks(rs.getInt("Marks"));
				s.setName(rs.getString("name"));
				s.setID(rs.getInt("ID"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}return s;
		
		}
		
		public boolean UpdateRecord(Student s) {
			String query = "update student set name =?, Age = ?, Marks= ? where ID = ?";
			
			try {
				PreparedStatement ps = con.prepareStatement(query);
				
				ps.setString(1, s.getName());
				ps.setInt(2, s.getAge());
				ps.setFloat(3, s.getMarks());
				ps.setInt(4, s.getID());
				
				int i = ps.executeUpdate();
				
				if(i>0) {
					return true;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return(false);
		}
		
		
	}
