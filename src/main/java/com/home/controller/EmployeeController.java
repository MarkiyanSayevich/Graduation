package com.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.home.mapper.EmployeeMapper.*;

import java.util.List;

import com.home.dto.EmployeeDto;
import com.home.entity.Employee;
import com.home.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired EmployeeService employeeService;
	
	
	@GetMapping("/show")
	public String showEmployee(Model model) {
		
		List<Employee> employees = employeeService.findAllEmployee();
		List<EmployeeDto> employeeDtos = ListEmployeeForDto(employees);
		
		model.addAttribute("employeesDtoModel", employeeDtos);
		
		return "employee/show";
	}
	
	@GetMapping("/add")
	public String addEmployee() {
		
		return "employee/add";
	}
}
