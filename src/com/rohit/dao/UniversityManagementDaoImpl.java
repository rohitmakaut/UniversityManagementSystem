package com.rohit.dao;

import java.util.ArrayList;
import java.util.List;

import com.rohit.model.Student;

public class UniversityManagementDaoImpl implements UniversityManagementDao {
	
	private UniversityManagementDaoImpl() {
		super();
	}

	private static UniversityManagementDao universityManagementDao=null;
	
	public static UniversityManagementDao getInstance() {
		if(universityManagementDao==null) {
			universityManagementDao=new UniversityManagementDaoImpl();
		}
		return universityManagementDao;
	}
	
	List<Student> students=new ArrayList<Student>();
	
	@Override
	public Integer addStudent(Student student) throws Exception {
		Integer rollNo=null;
		if(students.add(student)) {
			rollNo=student.getRollNo();
		}
		return rollNo;
	}

	@Override
	public Integer updateStudent(Integer rollNo, Student student) throws Exception {
		Integer roll=null;
		for(int i=0;i<students.size();i++) {
			if(students.get(i).getRollNo().equals(rollNo)) {
				students.set(i, student);
				roll=rollNo;
				break;
			}
		}
		return roll;
	}

	@Override
	public Integer deleteStudent(Integer rollNo) throws Exception {
		Integer roll=null;
		Student student=getStudent(rollNo);
		if(student!=null) {
			students.remove(student);
			roll=student.getRollNo();
		}
		return roll;
	}

	@Override
	public Student getStudent(Integer rollNo) throws Exception {
		Student student=null;
		for(Student s : students) {
			if(s.getRollNo().equals(rollNo)) {
				student=s;
				break;
			}
		}
		return student;
	}

	@Override
	public List<Student> getStudents() throws Exception {
		return students;
	}

}
