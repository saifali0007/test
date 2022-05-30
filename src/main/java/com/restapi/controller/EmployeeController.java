package com.restapi.controller;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.sym.Name;
import com.restapi.model.Employee;
import com.restapi.service.EmployeeService;


@RestController
@RequestMapping("/login")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/security")
	public String security() {
		return "you are logged in";
	}
	
	@PostMapping("/addEmployees")
	public ResponseEntity<Employee> saveEmployee(Employee employee){
	
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getEmployees")
	public List<Employee> getAllEmployees(){
		
		return employeeService.getAllEmployees();
	}
	
	
	@GetMapping("/getEmployees/{id}")
	public ResponseEntity<Employee> getEmployeesById(@PathVariable ("id") long employeeId){
		
		return new ResponseEntity<Employee>(employeeService.getEmployeesById(employeeId),HttpStatus.OK);
	}
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable ("id") long empId, @RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, empId), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable ("id") long empId) {
		employeeService.deleteEmployee(empId);
		return new ResponseEntity<String>("deleted successfully", HttpStatus.OK);
	}

}
