package com.home.dto;

import com.home.entity.Employee;

import lombok.Data;

@Data
public class ExaminationCreationDto {
	
	private String service;
	
	private String price;
	
	private String instruments;
	
	private String methods;
	
	private String conclusion;
	
	private String complaints;
	
	private String factors;
	
	private String diagnosis;
	
	private Employee employee;
}
