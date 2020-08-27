package com.rohit;

import java.util.List;
import java.util.Scanner;

import com.rohit.model.DeptName;
import com.rohit.model.Employee;
import com.rohit.model.Student;
import com.rohit.service.EmployeeService;
import com.rohit.service.EmployeeServiceImpl;
import com.rohit.service.StudentService;
import com.rohit.service.StudentServiceImpl;

public class UniversityManagementSystem {
	Scanner sc=new Scanner(System.in);
	StudentService studentService=StudentServiceImpl.getInstance();
	EmployeeService employeeService=EmployeeServiceImpl.getInstance();
	
	public static void main(String[] args) {
		new UniversityManagementSystem().myFunc();
	}
	
	public void myFunc() {
		while(true) {
			System.out.println("Enter:- \n 1.) Add Student \n 2.) Update Student \n 3.) Delete Student \n 4.) Get Student \n 5.) Get Students \n 6.) Add Employee\n 7.) Update Employee \n 8.) Delete Employee \n 9.) Get Employee \n 10.) Get Employees \n 0.) Exit \n");
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
				case 6: addEmployee();
				break;
				case 7: updateEmployee();
				break;
				case 8: deleteEmployee();
				break;
				case 9: getEmployee();
				break;
				case 10: getEmployees();
				break;
				default : System.out.println("Please Select Correct Option.");
			}
		}
	}
	
	public void addStudent() {
		Student student=new Student(1, "Rohit", "Kumar", DeptName.IT);
		try {
			Integer rollNo=studentService.addStudent(student);
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
			Integer rollNo=studentService.updateStudent(sc.nextInt(), student);
			System.out.println("Student Updated Successfully with RollNo : "+rollNo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteStudent() {
		try {
			System.out.println("Enter RollNo : ");
			Integer rollNo=studentService.deleteStudent(sc.nextInt());
			System.out.println("Student Deleted Successfully with RollNo : "+rollNo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void getStudent() {
		try {
			System.out.println("Enter RollNo : ");
			Student student=studentService.getStudent(sc.nextInt());
			System.out.println(student);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void getStudents() {
		try {
			List<Student> students=studentService.getStudents();
			for(Student student : students) {
				System.out.println(student);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void addEmployee() {
		Employee employee=new Employee(1, "ROHIT", "KUMAR", DeptName.FINANCE);
		try {
			Integer id=employeeService.addEmployee(employee);
			System.out.println("Employee Added Successfully with id : "+id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updateEmployee() {
		Employee employee=new Employee(2, "GAUTAM", "KUMAR", DeptName.IT);
		try {
			System.out.println("Enter ID : ");
			Integer id=employeeService.updateEmployee(sc.nextInt(), employee);
			System.out.println("Employee Updated Successfully with id : "+id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteEmployee() {
		try {
			System.out.println("Enter id : ");
			Integer id=employeeService.deleteEmployee(sc.nextInt());
			System.out.println("Employee Deleted Successfully with id : "+id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void getEmployee() {
		try {
			System.out.println("Enter id : ");
			Employee employee=employeeService.getEmployee(sc.nextInt());
			System.out.println(employee);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void getEmployees() {
		try {
			List<Employee> employees=employeeService.getEmployees();
			for(Employee employee : employees) {
				System.out.println(employee);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
