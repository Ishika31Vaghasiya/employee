package com.employee.employee_managmet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.employee.employee_managmet.serviceimpl.EmployeeServiceImpl;

@SpringBootApplication
public class EmployeeManagmetApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagmetApplication.class, args);
		System.out.println("started------------");
	}


	@Bean
	public EmployeeServiceImpl getEmployeeServiceImpl() {
		return new EmployeeServiceImpl();
	}
}
