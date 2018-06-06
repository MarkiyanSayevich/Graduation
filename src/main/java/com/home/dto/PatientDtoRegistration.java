package com.home.dto;

import com.home.entity.InsuranceCompany;
import com.home.entity.enums.Gender;
import com.home.entity.enums.PatientStatus;

import lombok.Data;

@Data
public class PatientDtoRegistration {
	
	private String fullName;
	
	private int year;
	
	private int mounth;
	
	private int day;
	
	private Gender gender;
	
	private String address;
	
	private String phoneNumber;
	
	private String patientCardNumber;
	
	private PatientStatus patientStatus;
	
	private InsuranceCompany insuranceCompany;
}
