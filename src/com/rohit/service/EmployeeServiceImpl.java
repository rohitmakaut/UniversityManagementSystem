package com.rohit.service;

import java.util.List;

import com.rohit.dao.EmployeeDao;
import com.rohit.dao.EmployeeDaoImpl;
import com.rohit.exception.NotAddedException;
import com.rohit.exception.NotDeletedException;
import com.rohit.exception.NotFoundException;
import com.rohit.exception.NotUpdatedException;
import com.rohit.model.Employee;

public class EmployeeServiceImpl implements EmployeeService  {
	EmployeeDao employeeDao=EmployeeDaoImpl.getInstance();
	
	private EmployeeServiceImpl() {
		super();
	}
	
	private static EmployeeService employeeService=null;
	
	public static EmployeeService getInstance() {
		if(employeeService==null) {
			employeeService=new EmployeeServiceImpl();
		}
		return employeeService;
	}

	@Override
	public Integer addEmployee(Employee employee) throws Exception {
		Integer id=employeeDao.addEmployee(employee);
		if(id==null) throw new NotAddedException("Employee Not Added!");
		else return id;
	}

	@Override
	public Integer updateEmployee(Integer id, Employee employee) throws Exception {
		Integer id1=employeeDao.updateEmployee(id, employee);
		if(id1==null) throw new NotUpdatedException("Employee Not Updated!");
		else return id1;
	}

	@Override
	public Integer deleteEmployee(Integer id) throws Exception {
		Integer id1=employeeDao.deleteEmployee(id);
		if(id1==null) throw new NotDeletedException("Eployee Not Deleted!");
		else return id1;
	}

	@Override
	public Employee getEmployee(Integer id) throws Exception {
		Employee employee=employeeDao.getEmployee(id);
		if(employee==null) throw new NotFoundException("Employee Not Found!");
		else return employee;
	}

	@Override
	public List<Employee> getEmployees() throws Exception {
		List<Employee> employees=employeeDao.getEmployees();
		if(employees==null || employees.isEmpty()) throw new NotFoundException("No Employee Found!");
		else return employees;
	}
	
}
