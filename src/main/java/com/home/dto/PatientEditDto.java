package com.home.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.home.entity.AdmissionsJournal;
import com.home.entity.Examination;
import com.home.entity.InsuranceCompany;
import com.home.entity.enums.Gender;
import com.home.entity.enums.PatientStatus;

import lombok.Data;

@Data
public class PatientEditDto {
	
	private Integer id;
	
	private String fullName;
	
	private Integer year;
	
	private Integer mounth;
	
	private Integer day;
	
	private Gender gender;
	
	private String address;
	
	private String phoneNumber;
	
	private String patientCardNumber;
	
	private PatientStatus patientStatus;
	
	private LocalDate registrationDate;
	
	private List<AdmissionsJournal> admissionsJournals = new ArrayList<>();
	
	private List<Examination> examinations = new ArrayList<>();
	
	private InsuranceCompany insuranceCompany;
	
}
