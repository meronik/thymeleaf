package com.project.service;

import java.util.List;
import java.util.Optional;

import com.project.model.Employee;

public interface EmployeeService {
	
	public void saveEmployee(Employee e);
	
	public List<Employee> getAllEmployee();
	
	public Employee getById(int id) ;
	
	public Employee updateEmployee(Employee employee, Integer id);
	
	public void deleteEmployee(int id);
}
