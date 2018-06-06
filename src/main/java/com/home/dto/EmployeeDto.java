package com.home.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.home.entity.EmployeeInfo;
import com.home.entity.Examination;

import lombok.Data;

@Data
public class EmployeeDto {

	private Integer id;
	
	private String fullName;
	
	private String email;
	
	private String phoneNumber;
	
	private String cabinet;
	
	private String scientificRank;
	
	private String position;
	
	private LocalDate registrationDate;
	
	private boolean theRightToWorkWithDatabase;
	
	private List<Examination> examinations = new ArrayList<>();
	
	private EmployeeInfo employeeInfo;
}
