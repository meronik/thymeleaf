package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
