package com.home.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.home.entity.gender.Gender;
import com.home.entity.gender.PatientStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="patient")
@NoArgsConstructor
@Getter
@Setter
public class Patient extends BaseEntity{

	@Column(name="full_name")
	private String fullName;
	
	@Column(name="birthday")
	private LocalDate birthday;
	
	@Column(name="gender")
	private Gender gender;
	
	@Column(name="address")
	private String address;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="patient_card_number")
	private String patientCardNumber;
	
	@Column(name="patient_status")
	private PatientStatus patientStatus;
	
	@Column(name="diagnosis")
	private String diagnosis;
	
	@Column(name="registration_date")
	private LocalDate registrationDate;
}
