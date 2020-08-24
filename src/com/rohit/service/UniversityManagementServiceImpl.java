package com.rohit.service;

import java.util.List;

import com.rohit.dao.UniversityManagementDao;
import com.rohit.dao.UniversityManagementDaoImpl;
import com.rohit.exception.NotAddedException;
import com.rohit.exception.NotDeletedException;
import com.rohit.exception.NotFoundException;
import com.rohit.exception.NotUpdatedException;
import com.rohit.model.Student;

public class UniversityManagementServiceImpl implements UniversityManagementService {

	UniversityManagementDao universityManagementDao=UniversityManagementDaoImpl.getInstance(); 
	
	private UniversityManagementServiceImpl() {
		super();
	}
	
	private static UniversityManagementService universityManagementService=null;
	
	public static UniversityManagementService getInstance() {
		if(universityManagementService==null) {
			universityManagementService=new UniversityManagementServiceImpl();
		}
		return universityManagementService;
	}
	
	@Override
	public Integer addStudent(Student student) throws Exception {
		Integer rollNo=universityManagementDao.addStudent(student);
		if(rollNo==null) throw new NotAddedException("Student Not Added!");
		else return rollNo;
	}

	@Override
	public Integer updateStudent(Integer rollNo, Student student) throws Exception {
		Integer roll=universityManagementDao.updateStudent(rollNo, student);
		if(roll==null) throw new NotUpdatedException("Student Not Updated!");
		else return roll;
	}

	@Override
	public Integer deleteStudent(Integer rollNo) throws Exception {
		Integer roll=universityManagementDao.deleteStudent(rollNo);
		if(roll==null) throw new NotDeletedException("Student Not Deleted!");
		else return roll;
	}

	@Override
	public Student getStudent(Integer rollNo) throws Exception {
		Student student=universityManagementDao.getStudent(rollNo);
		if(student==null) throw new NotFoundException("Student Not Found!");
		else return student;
	}

	@Override
	public List<Student> getStudents() throws Exception {
		List<Student> students=universityManagementDao.getStudents();
		if(students==null || students.isEmpty()) throw new NotFoundException("No Student Found!");
		else return students;
	}

}
