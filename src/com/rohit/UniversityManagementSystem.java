package com.rohit;

import java.util.List;
import java.util.Scanner;

import com.rohit.model.DeptName;
import com.rohit.model.Student;
import com.rohit.service.UniversityManagementService;
import com.rohit.service.UniversityManagementServiceImpl;

public class UniversityManagementSystem {
	Scanner sc=new Scanner(System.in);
	UniversityManagementService universityManagementService=UniversityManagementServiceImpl.getInstance();
	
	public static void main(String[] args) {
		new UniversityManagementSystem().myFunc();
	}
	
	public void myFunc() {
		while(true) {
			System.out.println("Enter:- \n 1.) Add Student \n 2.) Update Student \n 3.) Delete Student \n 4.) Get Student \n 5.) Get Students \n 0.) Exit \n");
			int option=sc.nextInt();
			switch(option) {
				case 0: System.exit(0);
				break;
				case 1: addStudent();
				break;
				case 2: updateStudent();
				break;
				case 3: deleteStudent();
				break;
				case 4: getStudent();
				break;
				case 5: getStudents();
				break;
				default : System.out.println("Please Select Correct Option.");
			}
		}
	}
	
	public void addStudent() {
		Student student=new Student(1, "Rohit", "Kumar", DeptName.IT);
		try {
			Integer rollNo=universityManagementService.addStudent(student);
			System.out.println("Student Added Successfully with RollNo : "+rollNo);
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public void updateStudent() {
		Student student=new Student(2, "Gautam", "Bharadwaj", DeptName.CSE);
		try {
			System.out.println("Enter RollNo : ");
			Integer rollNo=universityManagementService.updateStudent(sc.nextInt(), student);
			System.out.println("Student Updated Successfully with RollNo : "+rollNo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteStudent() {
		try {
			System.out.println("Enter RollNo : ");
			Integer rollNo=universityManagementService.deleteStudent(sc.nextInt());
			System.out.println("Student Deleted Successfully with RollNo : "+rollNo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void getStudent() {
		try {
			System.out.println("Enter RollNo : ");
			Student student=universityManagementService.getStudent(sc.nextInt());
			System.out.println(student);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void getStudents() {
		try {
			List<Student> students=universityManagementService.getStudents();
			for(Student student : students) {
				System.out.println(student);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
