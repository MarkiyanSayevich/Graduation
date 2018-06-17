package com.home.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class EmployeeDtoRegistration {
	
	@NotEmpty(message="Поле не повинне бути пустим")
	private String fullName;
	
	private String email;
	
	@NotEmpty(message="Поле не повинне бути пустим")
	private String phoneNumber;
	
	private String cabinet;
	
	private String scientificRank;
	
	@NotEmpty(message="Поле не повинне бути пустим")
	private String position;
	
	private boolean theRightToWorkWithDatabase;
	
	private String login;
	
	private String password;
}
