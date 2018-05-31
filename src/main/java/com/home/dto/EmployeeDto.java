package com.home.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.home.entity.AdmissionsJournal;

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
	
	private String department;
	
	private String[] wards;
	
	private LocalDate registrationDate;
	
	private boolean theRightToWorkWithDatabase;
	
	private List<AdmissionsJournal> admissionsJournals = new ArrayList<>();
	
	private String imageName;
	
	private String login;
	
	private String password;
}
