package com.itvdant.student;

import java.lang.invoke.SwitchPoint;
import java.lang.runtime.SwitchBootstraps;
import java.util.List;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		
		Scanner Mahesh = new Scanner(System.in);
		
		System.out.println("Welcome to Student Database Management System");
		
		while(true) {
			System.out.println("\n Please select your choice from below");
			System.out.println("1 Display All Record");
			System.out.println("2 Insert new Record in database");
			System.out.println("3 Update Previous record from Database");
			System.out.println("4 Delete Record from Database");
			System.out.println("5 Display particular record");
			System.out.println("6 Quit");
			
			int choice = Mahesh.nextInt();
			
			if (choice == 6) {
				break;
			}else if (choice >=1 && choice<= 5) {
				
				Student_Data_Access_Object stud1 = new Student_Data_Access_Object();
				
				int id = 0;
				String Name = "";
				int Age = 0;
				float Marks = 0.0f;
				
				switch (choice) {
				case 1: {
					List<Student> student = stud1.getRecord();
					student.forEach(n->System.out.println(n));
					
					break;
				}
				case 2: {
					System.out.println("Please Enter Name");
					Name = Mahesh.next();
					System.out.println("Please Enter Age");
					Age = Mahesh.nextInt();
					System.out.println("Please Enter Marks");
					Marks = Mahesh.nextFloat();
					
					boolean b = stud1.Createecord(Name, Age, Marks);
					
					if(b) {
						System.out.println("Record Sucessfully Updated");
					}
					
					break;
				}
				case 3: {
					List<Student> student = stud1.getRecord();
					student.forEach(n->System.out.println(n));
					
					System.out.println("Provide name of student to update record");
					Name = Mahesh.next();
					
					Student s2 = stud1.SearchRecord(Name);
					
					if(s2 == null) {
						System.out.println("Record not found");
					}else {
						
					System.out.println("Please Enter the choice you want to update");
					System.out.println("a --> Name");
					System.out.println("b --> Age");
					System.out.println("c --> Marks");
					char updateChoice = Mahesh.next().charAt(0);
					
					switch (updateChoice) {
					case 'a': System.out.println("Enter new Name");
								Name = Mahesh.next();
								s2.setName(Name);
								break;
					
					case 'b': System.out.println("Enter new Age");
								Age = Mahesh.nextInt();
								s2.setAge(Age);
								break;
								
					case 'c': System.out.println("Enter new Marks");
								Marks = Mahesh.nextInt();
								s2.setMarks(Marks);
								break;
					}
					
					boolean b2 = stud1.UpdateRecord(s2);
					
				if(updateChoice == 'a'|| updateChoice =='b'|| updateChoice =='c') {
					if(b2) {
						System.out.println("Successfully Updated record");
					}else {
						System.out.println("Error to update record");
					}
				}else {System.out.println("Invalid Input");}
			}
				}break;
				case 4: {
					List <Student> student = stud1.getRecord();
					student.forEach(n->System.out.println(n));
					
					System.out.println("Enter Student ID to delet record");
					id= Mahesh.nextInt();
					
					boolean b = stud1.DeleteRecord(id);
					
					if (b) {
						System.out.println("Record Deleted");
					}else {
						System.out.println("Error");
						}
					break;
				}
				case 5: {
					System.out.println("Provide name of student to get his record");
					Name = Mahesh.next();
					
					Student s1 = stud1.SearchRecord(Name);
					System.out.println(s1);
					break;
				}
			}
		}
			else {
				System.out.println("Please enter valid input from above");
			}
		}
	}
}
