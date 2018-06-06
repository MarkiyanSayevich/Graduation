package com.home.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.home.entity.Employee;
import com.home.filter.SimpleFilter;

public interface EmployeeService {

	void saveEmployee(Employee employee);
	
	Employee getOneEmployee(int id);
	
	List<Employee> findAllEmployee();
	
	Employee findEmployeeByLogin(String login);
	
	void deleteEmployeeWithId(int id);
	
	Page<Employee> pageEmployee(Pageable pageable);
	
	Page<Employee> pageEmployeeFilter(SimpleFilter filter, Pageable pageable);
}
