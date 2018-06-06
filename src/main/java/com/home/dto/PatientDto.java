package com.home.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.home.entity.AdmissionsJournal;
import com.home.entity.Examination;
import com.home.entity.InsuranceCompany;
import com.home.entity.enums.Gender;
import com.home.entity.enums.PatientStatus;

import lombok.Data;

@Data
public class PatientDto {
	
	private Integer id;
	
	private String fullName;
	
	private LocalDate birthday;
	
	private Gender gender;
	
	private String address;
	
	private String phoneNumber;
	
	private String patientCardNumber;
	
	private PatientStatus patientStatus;
	
	private LocalDate registrationDate;
	
	List<AdmissionsJournal> admissionsJournals = new ArrayList<>();
	
	List<Examination> examinations = new ArrayList<>();
	
	private InsuranceCompany insuranceCompany;
}
