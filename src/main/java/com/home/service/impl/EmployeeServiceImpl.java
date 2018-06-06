package com.home.service.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.home.entity.Employee;
import com.home.filter.SimpleFilter;
import com.home.repository.EmployeeRepository;
import com.home.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired EmployeeRepository employeeRepos;
	
	@Override
	public void deleteEmployeeWithId(int id) {
		employeeRepos.deleteById(id);
	}
	
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
	
	@Override
	public Page<Employee> pageEmployee(Pageable pageable) {
		return employeeRepos.findAll(pageable);
	}
	
	@Override
	public Page<Employee> pageEmployeeFilter(SimpleFilter filter, Pageable pageable) {
		return employeeRepos.findAll(getSpecification(filter), pageable);
	}
	
	private static Specification<Employee> getSpecification(SimpleFilter filter){
		return new Specification<Employee>() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				if(filter.getName().isEmpty()) {
					return null;
				} else return criteriaBuilder.like(root.get("fullName"), "%" + filter.getName() +"%" ); 
			}
		};
	}
}

