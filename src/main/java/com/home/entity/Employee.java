package com.home.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="employee")
@Getter
@Setter
@NoArgsConstructor
public class Employee extends BaseEntity{

	@Column(name="full_name")
	private String fullName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="cabinet")
	private String cabinet;
	
	//Наукове звання
	@Column(name="scientific_rank")
	private String scientificRank;
	
	//Посада
	@Column(name="position")
	private String position;
	
	//Відділення
	@Column(name="department")
	private String department;
	
	//Палати
	@Column(name="wards")
	private String[] wards;
	
	@Column(name="registration_date")
	private LocalDate registrationDate;
	
	@Column(name="the_right_to_work_with_database")
	private boolean theRightToWorkWithDatabase;
}
