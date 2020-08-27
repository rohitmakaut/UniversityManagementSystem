package com.rohit.service;

import java.util.List;

import com.rohit.model.Employee;

public interface EmployeeService {
	public Integer addEmployee(Employee employee) throws Exception;
	public Integer updateEmployee(Integer id, Employee employee) throws Exception;
	public Integer deleteEmployee(Integer id) throws Exception;
	public Employee getEmployee(Integer id) throws Exception;
	public List<Employee> getEmployees() throws Exception;
}
