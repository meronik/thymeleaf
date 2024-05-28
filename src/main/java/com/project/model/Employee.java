package com.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Employee {
        
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String name;
		private String email;
		private String phone;
		private String positon;
		private String department;
		
		
	public Employee() {
			
		}
	
		public Employee( String name, String email, String phone, String positon, String department) {
		
			this.name = name;
			this.email = email;
			this.phone = phone;
			this.positon = positon;
			this.department = department;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getPositon() {
			return positon;
		}
		public void setPositon(String positon) {
			this.positon = positon;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		
		
		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", positon="
					+ positon + ", department=" + department + "]";
		}
		
		
		

	}



