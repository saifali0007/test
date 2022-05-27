package com.restapi.service;

import java.util.List;

import org.hibernate.sql.Update;

import com.restapi.model.Employee;

public interface EmployeeService {
	
	public Employee saveEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeesById(long id);
	
	public Employee updateEmployee(Employee employee,long id);

	public void deleteEmployee(long id);
	

}
