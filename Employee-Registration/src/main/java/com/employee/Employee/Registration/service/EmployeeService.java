package com.employee.Employee.Registration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.Employee.Registration.model.Employee;
import com.employee.Employee.Registration.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeerepository;
	
	public Employee saveemployee(Employee e) {
		return employeerepository.save(e);
	}
	public List<Employee> getAllEmployees(){
		return employeerepository.findAll();
	}
	public Employee getEmployeeById(Long id) {
		return employeerepository.findById(id).orElse(null);
	}
	
	public Employee getEmployeeByName(String name) {
		return employeerepository.findByName(name).orElse(null);
	}
	
	public Employee updateEmployee(Long id,Employee updated) {
		Employee e = employeerepository.findById(id).orElseThrow();
		e.setName(updated.getName());
		e.setId(updated.getId());
		e.setDept(updated.getDept());
		e.setEmail(updated.getEmail());
		e.setSalary(updated.getSalary());
		return employeerepository.save(e);

    }
	public void deleteEmployee(Long id) {
		employeerepository.deleteById(id);
	}
	}
