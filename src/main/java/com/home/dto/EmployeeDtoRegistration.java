package com.home.dto;

import lombok.Data;

@Data
public class EmployeeDtoRegistration {

	private String fullName;
	
	private String email;
	
	private String phoneNumber;
	
	private String cabinet;
	
	private String scientificRank;
	
	private String position;
	
	private boolean theRightToWorkWithDatabase;
	
	private String login;
	
	private String password;
}
