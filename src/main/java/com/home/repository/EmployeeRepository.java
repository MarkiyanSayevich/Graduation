package com.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.home.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> , JpaSpecificationExecutor<Employee>{

	@Query("SELECT e FROM Employee e Join e.employeeInfo ei WHERE LOWER (ei.login) = :login")
	Employee findEmployeeByLogin(@Param("login") String login);
}
