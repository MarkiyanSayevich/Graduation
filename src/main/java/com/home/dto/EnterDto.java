package com.home.dto;

import javax.validation.constraints.NotEmpty;

import com.home.validation.CheckIfEmployeeExist;
import com.home.validation.CheckPassword;

import lombok.Data;

@Data
public class EnterDto {

	@NotEmpty(message = "Це поле не повинне бути пусте")
	@CheckIfEmployeeExist
	private String login;
	
//	@NotEmpty(message = "Це поле не повинне бути пусте")
	@CheckPassword
	private Integer password;
}
