package com.rohit.service;

import java.util.List;

import com.rohit.dao.StudentDao;
import com.rohit.dao.StudentDaoImpl;
import com.rohit.exception.NotAddedException;
import com.rohit.exception.NotDeletedException;
import com.rohit.exception.NotFoundException;
import com.rohit.exception.NotUpdatedException;
import com.rohit.model.Student;

public class StudentServiceImpl implements StudentService {

	StudentDao studentDao=StudentDaoImpl.getInstance(); 
	
	private StudentServiceImpl() {
		super();
	}
	
	private static StudentService studentService=null;
	
	public static StudentService getInstance() {
		if(studentService==null) {
			studentService=new StudentServiceImpl();
		}
		return studentService;
	}
	
	@Override
	public Integer addStudent(Student student) throws Exception {
		Integer rollNo=studentDao.addStudent(student);
		if(rollNo==null) throw new NotAddedException("Student Not Added!");
		else return rollNo;
	}

	@Override
	public Integer updateStudent(Integer rollNo, Student student) throws Exception {
		Integer roll=studentDao.updateStudent(rollNo, student);
		if(roll==null) throw new NotUpdatedException("Student Not Updated!");
		else return roll;
	}

	@Override
	public Integer deleteStudent(Integer rollNo) throws Exception {
		Integer roll=studentDao.deleteStudent(rollNo);
		if(roll==null) throw new NotDeletedException("Student Not Deleted!");
		else return roll;
	}

	@Override
	public Student getStudent(Integer rollNo) throws Exception {
		Student student=studentDao.getStudent(rollNo);
		if(student==null) throw new NotFoundException("Student Not Found!");
		else return student;
	}

	@Override
	public List<Student> getStudents() throws Exception {
		List<Student> students=studentDao.getStudents();
		if(students==null || students.isEmpty()) throw new NotFoundException("No Student Found!");
		else return students;
	}

}
