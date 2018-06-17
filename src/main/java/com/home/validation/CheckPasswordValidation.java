package com.home.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckPasswordValidation implements ConstraintValidator<CheckPassword, Integer> {

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		
		System.out.println(value);
		
		if(value == null) {
			return false;
		} else if(value == 1111) {
			return true;
		} else {
			return false;
		}
	}
}
