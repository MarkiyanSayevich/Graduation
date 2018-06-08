package com.home.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.home.dto.EmployeeDto;
import com.home.dto.EmployeeDtoRegistration;
import com.home.dto.EmployeeEditDto;
import com.home.entity.Employee;
import com.home.entity.EmployeeInfo;

public interface EmployeeMapper {

	public static EmployeeDto EmployeeForDto(Employee employee) {
		
		EmployeeDto dto = new EmployeeDto();
		
		dto.setId(employee.getId());
		dto.setFullName(employee.getFullName());
		dto.setEmail(employee.getEmail());
		dto.setPhoneNumber(employee.getPhoneNumber());
		dto.setCabinet(employee.getCabinet());
		dto.setScientificRank(employee.getScientificRank());
		dto.setPosition(employee.getPosition());
		dto.setRegistrationDate(employee.getRegistrationDate());
		dto.setTheRightToWorkWithDatabase(employee.isTheRightToWorkWithDatabase());
		dto.setExaminations(employee.getExaminations());
		dto.setEmployeeInfo(employee.getEmployeeInfo());
		
		return dto;
	}
	
	public static List<EmployeeDto> ListEmployeeForDto(List<Employee> employees){
		
		List<EmployeeDto> dtos = new ArrayList<>();
		
		for(int i = 0; i < employees.size(); i++) {
			
			EmployeeDto dto = new EmployeeDto();
			
			dto.setId(employees.get(i).getId());
			dto.setFullName(employees.get(i).getFullName());
			dto.setEmail(employees.get(i).getEmail());
			dto.setPhoneNumber(employees.get(i).getPhoneNumber());
			dto.setCabinet(employees.get(i).getCabinet());
			dto.setScientificRank(employees.get(i).getScientificRank());
			dto.setPosition(employees.get(i).getPosition());
			dto.setRegistrationDate(employees.get(i).getRegistrationDate());
			dto.setTheRightToWorkWithDatabase(employees.get(i).isTheRightToWorkWithDatabase());
			dto.setExaminations(employees.get(i).getExaminations());
			dto.setEmployeeInfo(employees.get(i).getEmployeeInfo());
			
			dtos.add(dto);
		}
		
		return dtos;
	}
	
	
	public static Employee dtoRegistrationToEmployee(EmployeeDtoRegistration dtoRegistration) {
		
		Employee employee = new Employee();
		
		employee.setFullName(dtoRegistration.getFullName());
		employee.setEmail(dtoRegistration.getEmail());
		employee.setPhoneNumber(dtoRegistration.getPhoneNumber());
		employee.setCabinet(dtoRegistration.getCabinet());
		employee.setScientificRank(dtoRegistration.getScientificRank());
		employee.setPosition(dtoRegistration.getPosition());
		employee.setRegistrationDate(LocalDate.now());
		employee.setTheRightToWorkWithDatabase(dtoRegistration.isTheRightToWorkWithDatabase());
		employee.setEmployeeInfo(new EmployeeInfo());
		employee.getEmployeeInfo().setLogin(dtoRegistration.getLogin());
		employee.getEmployeeInfo().setPassword(dtoRegistration.getPassword());
		
		return employee;
	}
	
	public static Employee dtoToEmployee(EmployeeDto dto) {
		
		Employee employee = new Employee();
		
		employee.setId(dto.getId());
		employee.setFullName(dto.getFullName());
		employee.setEmail(dto.getEmail());
		employee.setPhoneNumber(dto.getPhoneNumber());
		employee.setCabinet(dto.getCabinet());
		employee.setScientificRank(dto.getScientificRank());
		employee.setPosition(dto.getPosition());
		employee.setRegistrationDate(dto.getRegistrationDate());
		employee.setTheRightToWorkWithDatabase(dto.isTheRightToWorkWithDatabase());
		employee.setEmployeeInfo(new EmployeeInfo());
		employee.setEmployeeInfo(dto.getEmployeeInfo());
		
		return employee;
	}
	
	
	public static EmployeeEditDto employeeToEdit(Employee employee) {
		
		EmployeeEditDto dto = new EmployeeEditDto();
	
		dto.setId(employee.getId());
		dto.setFullName(employee.getFullName());
		dto.setEmail(employee.getEmail());
		dto.setCabinet(employee.getCabinet());
		dto.setPhoneNumber(employee.getPhoneNumber());
		dto.setScientificRank(employee.getScientificRank());
		dto.setPosition(employee.getPosition());
		dto.setRegistrationDate(employee.getRegistrationDate());
		dto.setTheRightToWorkWithDatabase(employee.isTheRightToWorkWithDatabase());
		dto.setImageName(employee.getEmployeeInfo().getImageName());
		dto.setExaminations(employee.getExaminations());
		dto.setLogin(employee.getEmployeeInfo().getLogin());
		dto.setPassword(employee.getEmployeeInfo().getPassword());
		
		return dto;
	}
	
	public static Employee editToEmployee(EmployeeEditDto dto) {
		
		Employee employee = new Employee();
		
		employee.setId(dto.getId());
		employee.setFullName(dto.getFullName());
		employee.setEmail(dto.getEmail());
		employee.setPhoneNumber(dto.getPhoneNumber());
		employee.setCabinet(dto.getCabinet());
		employee.setScientificRank(dto.getScientificRank());
		employee.setPosition(dto.getPosition());
		employee.setRegistrationDate(dto.getRegistrationDate());
		employee.setTheRightToWorkWithDatabase(dto.isTheRightToWorkWithDatabase());
		employee.setExaminations(dto.getExaminations());
		employee.setEmployeeInfo(new EmployeeInfo());
		employee.getEmployeeInfo().setImageName(dto.getImageName());
		employee.getEmployeeInfo().setLogin(dto.getLogin());
		employee.getEmployeeInfo().setPassword(dto.getPassword());
		
		return employee;
	}
}
