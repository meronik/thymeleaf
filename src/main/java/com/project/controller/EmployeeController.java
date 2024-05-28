package com.project.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.Employee;
import com.project.model.User;
import com.project.service.EmployeeService;

import jakarta.servlet.http.HttpSession;





@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("/checkUser")
	public String loginCheck(@RequestParam(required = false, name = "user") String name,
			                  @RequestParam(required = false, name = "pass")String password,Model model) {
		User user=new User();
		if(user.getUsername().equals(name) && user.getPassword().equals(password)) {
			return "redirect:/employee";
		}
		else {
			model.addAttribute("error", "Incorrect username and password");
		return "index";
		}
	}
	

	@GetMapping("/employee")
	public String employeePage(Model m) {
		List<Employee> e=service.getAllEmployee();
		m.addAttribute("employee", e);
		return "Employee";
	}
	
	@GetMapping("/add")
	public String addEmpPage() {
		return "AddEmp";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmp(@ModelAttribute Employee e,HttpSession session) {
		service.saveEmployee(e);
	    session.setAttribute("msg", "Employee added succesfully");
	  
		return "redirect:/employee";
		
		
	}
	
	@GetMapping("/edit/{id}")
	public String editPage(@PathVariable int id,Model m) {
		Employee e=service.getById(id);
		m.addAttribute("emp", e);
		return "edit";
	}
	
	@PostMapping("/update/{id}")
	public String updateEmployee(@ModelAttribute Employee e,@PathVariable int id) {
	   service.updateEmployee(e, id);
		return "redirect:/employee";
		
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		service.deleteEmployee(id);
		return "redirect:/employee";
	}
			
	
	
	
}
