package com.home.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="employee_info")
public class EmployeeInfo extends BaseEntity {

	private String imageName;
	
	private String login;
	
	private String password;
}
