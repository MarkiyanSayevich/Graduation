package com.home.dto;

import javax.validation.constraints.NotEmpty;

import com.home.validation.CheckIfEmployeeExist;

import lombok.Data;

@Data
public class EnterDto {

	@NotEmpty(message = "This area cannot be empty")
	@CheckIfEmployeeExist
	private String login;
	
	@NotEmpty(message = "This area cannot be empty ")
	private String password;
}
