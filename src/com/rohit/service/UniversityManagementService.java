package com.rohit.service;

import java.util.List;

import com.rohit.model.Student;

public interface UniversityManagementService {
	public Integer addStudent(Student student) throws Exception;
	public Integer updateStudent(Integer rollNo, Student student) throws Exception;
	public Integer deleteStudent(Integer rollNo) throws Exception;
	public Student getStudent(Integer rollNo) throws Exception;
	public List<Student> getStudents() throws Exception;
}
