package com.home.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target({ FIELD, METHOD })
@Constraint(validatedBy=CheckIfEmployeeExistValidation.class)
public @interface CheckIfEmployeeExist {

	String message() default "Emoloyee is not found or you have no access to database";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default{};
}
