package com.project.service.imple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Employee;
import com.project.repository.EmployeeRepo;
import com.project.service.EmployeeService;


@Service
public class EmployeeServiceImp implements EmployeeService {
	
	@Autowired
	EmployeeRepo repo;

	@Override
	public void saveEmployee(Employee e) {
		 repo.save(e);
		
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return repo.findAll();
	}

	@Override
	public Employee getById(int id) {
		Optional<Employee> emp=repo.findById(id);
		  if(emp.isPresent()) {
			  return emp.get();
		  }
		  return null;
	}
	
	public Employee updateStudent(Employee student, Integer id) {
		Employee result = repo.findById(id).orElse(null);
		if (result != null) {
			return repo.save(student);
		}
		return null;
	}

	@Override
	public Employee updateEmployee(Employee employee, Integer id) {
		// TODO Auto-generated method stub
		Employee result = repo.findById(id).orElse(null);
		if (result != null) {
			return repo.save(employee);
		}
		return null;
	}

	@Override
	public void deleteEmployee(int id) {
	     repo.deleteById(id);
		
	}






}
