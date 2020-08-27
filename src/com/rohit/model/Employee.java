package com.rohit.model;

public class Employee {
	
	
	private Integer id;
	private String firstName,lastName;
	private DeptName dept;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(Integer id, String firstName, String lastName, DeptName dept) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dept = dept;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public DeptName getDept() {
		return dept;
	}
	public void setDept(DeptName dept) {
		this.dept = dept;
	}
	public String toString() {
		return "Employee [Id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", deptName="
				+ dept + "]";
	}

}

