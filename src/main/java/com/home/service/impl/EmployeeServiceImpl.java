package com.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.entity.Employee;
import com.home.repository.EmployeeRepository;
import com.home.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {


	@Autowired EmployeeRepository employeeRepos;
	
	@Override
	public void saveEmployee(Employee employee) {
		employeeRepos.save(employee);
	}

	@Override
	public Employee getOneEmployee(int id) {
		return employeeRepos.getOne(id);
	}

	@Override
	public List<Employee> findAllEmployee() {
		return employeeRepos.findAll();
	}

	@Override
	public Employee findEmployeeByLogin(String login) {
		return employeeRepos.findEmployeeByLogin(login);
	}
}
