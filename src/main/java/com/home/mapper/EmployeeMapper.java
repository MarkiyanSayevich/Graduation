package com.home.mapper;

import java.util.ArrayList;
import java.util.List;

import com.home.dto.EmployeeDto;
import com.home.entity.Employee;

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
		dto.setDepartment(employee.getDepartment());
		dto.setWards(employee.getWards());
		dto.setRegistrationDate(employee.getRegistrationDate());
		dto.setTheRightToWorkWithDatabase(employee.isTheRightToWorkWithDatabase());
		dto.setAdmissionsJournals(employee.getAdmissionsJournals());
		dto.setImageName(employee.getEmployeeInfo().getImageName());
		dto.setLogin(employee.getEmployeeInfo().getLogin());
		dto.setPassword(employee.getEmployeeInfo().getPassword());
		
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
			dto.setDepartment(employees.get(i).getDepartment());
			dto.setWards(employees.get(i).getWards());
			dto.setRegistrationDate(employees.get(i).getRegistrationDate());
			dto.setTheRightToWorkWithDatabase(employees.get(i).isTheRightToWorkWithDatabase());
			dto.setAdmissionsJournals(employees.get(i).getAdmissionsJournals());
			dto.setImageName(employees.get(i).getEmployeeInfo().getImageName());
			dto.setLogin(employees.get(i).getEmployeeInfo().getLogin());
			dto.setPassword(employees.get(i).getEmployeeInfo().getPassword());
			
			dtos.add(dto);
		}
		return dtos;
	}
}
