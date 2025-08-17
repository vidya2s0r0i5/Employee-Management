package com.employee.Employee.Registration.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.Employee.Registration.model.Employee;
import com.employee.Employee.Registration.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeservice;
	
	
	@GetMapping("/health-check")
	public String healthCheck() {
		return "application is working fyn";
	}
	@PostMapping("/save-employee")
	public Employee add(@RequestBody Employee employee)
	{	return employeeservice.saveemployee(employee);
	
	}
	@GetMapping("all-employees")
	public List<Employee> getAll(){
		return employeeservice.getAllEmployees();
	}
	@GetMapping("/{id}")
	public Employee getById(@PathVariable Long id) {
		return employeeservice.getEmployeeById(id);
		
	}
	@GetMapping("/by-name/{name}")
	public Employee getByName(@PathVariable String name){
		return employeeservice.getEmployeeByName(name);
	}
	@PutMapping("/update/{id}")
	public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee e) {
		return employeeservice.updateEmployee(id, e);
	}
	@DeleteMapping("/delete/{id}")
   public void deleteEmployee(@PathVariable Long id) {
	   employeeservice.deleteEmployee(id);
   }
	}
