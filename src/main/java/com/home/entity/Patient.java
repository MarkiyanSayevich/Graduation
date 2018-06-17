package com.home.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.home.entity.enums.Gender;
import com.home.entity.enums.PatientStatus;

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
	
	@Column(name="registration_date")
	private LocalDate registrationDate;
	
	@OneToMany(mappedBy="patient")
	List<AdmissionsJournal> admissionsJournals = new ArrayList<>();
	
	@OneToMany(mappedBy="patient")
	List<Examination> examinations = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="insuranceCompany_id")
	private InsuranceCompany insuranceCompany;
}
