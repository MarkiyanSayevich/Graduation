package com.home.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.home.entity.Employee;
import com.home.service.EmployeeService;

public class CheckIfEmployeeExistValidation implements ConstraintValidator<CheckIfEmployeeExist, String> {

	@Autowired EmployeeService employeeService;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		Employee employee = employeeService.findEmployeeByLogin(value.toLowerCase());
		
		if(employee == null) {
			return false;
		} else if(employee.isTheRightToWorkWithDatabase() == true){
			return true;
		} else return false;
	}
}
