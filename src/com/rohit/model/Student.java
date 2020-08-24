package com.rohit.model;

public class Student {
	private Integer rollNo;
	private String firstName;
	private String lastName;
	private DeptName depName;
	
	public Student() {
		super();
	}
	
	public Student(Integer rollNo, String firstName, String lastName, DeptName depName) {
		super();
		this.rollNo = rollNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.depName = depName;
	}

	public Integer getRollNo() {
		return rollNo;
	}
	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
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
	public DeptName getDepName() {
		return depName;
	}
	public void setDepName(DeptName depName) {
		this.depName = depName;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", firstName=" + firstName + ", lastName=" + lastName + ", depName="
				+ depName + "]";
	}

}
