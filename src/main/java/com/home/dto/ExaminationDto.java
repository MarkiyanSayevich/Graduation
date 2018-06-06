package com.home.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.home.entity.Employee;
import com.home.entity.Patient;

import lombok.Data;

@Data
public class ExaminationDto {

	private Integer id;
	
	private LocalDate registrationDate;
	
	private Integer age;
	
	private String service;
	
	private BigDecimal price;
	
	private String instruments;
	
	private String methods;
	
	private String conclusion;
	
	private String complaints;
	
	private String factors;
	
	private String diagnosis;
	
	private Patient patient;
	
	private Employee employee;
}
