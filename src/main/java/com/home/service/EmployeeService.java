package com.home.service;

import java.util.List;

import com.home.entity.Employee;

public interface EmployeeService {

	void saveEmployee(Employee employee);
	
	Employee getOneEmployee(int id);
	
	List<Employee> findAllEmployee();
}
