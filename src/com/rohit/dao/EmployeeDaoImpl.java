package com.rohit.dao;

import java.util.ArrayList;
import java.util.List;

import com.rohit.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	private EmployeeDaoImpl() {
		super();
	}

	private static EmployeeDao employeeDao=null;
	
	public static EmployeeDao getInstance() {
		if(employeeDao==null) {
			employeeDao=new EmployeeDaoImpl();
		}
		return employeeDao;
	}
	
	private List<Employee> employees=new ArrayList<Employee>();

	@Override
	public Integer addEmployee(Employee employee) throws Exception {
		Integer id=null;
		if(employees.add(employee)) {
			id=employee.getId();
		}
		return id;
	}
	
	@Override
	public Integer updateEmployee(Integer id, Employee employee) throws Exception {
		Integer id1=null;
		for(int i=0;i<employees.size();i++) {
			if(employees.get(i).getId().equals(id)) {
				employees.set(i,employee);
				id1=id;
				break;
			}
		}
		return id1;
	}

	@Override
	public Integer deleteEmployee(Integer id) throws Exception {
		Integer id1=null;
		Employee employee=getEmployee(id);
		if(employee!=null) {
			employees.remove(employee);
			id1=employee.getId();
		}
		return id1;
	}
	
	@Override
	public Employee getEmployee(Integer id) throws Exception {
		Employee employee=null;
		for(Employee s : employees) {
			if(s.getId().equals(id)) {
				employee=s;
				break;
			}
		}
		return employee;
	}

	@Override
	public List<Employee> getEmployees() throws Exception {
		return employees;
	}
}
