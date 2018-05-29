package com.home.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="examination")
@Getter
@Setter
@NoArgsConstructor
public class Examination extends BaseEntity {

	@Column(name="registration_date")
	private LocalDate registrationDate;
	
	@Column(name="age")
	private Integer age;
	
	@Column(name="service")
	private String service;
	
	@Column(name="price")
	private BigDecimal price;
	
	@Column(name="instruments")
	private String[] instruments;
	
	@Column(name="methods")
	private String[] methods;
	
	@Column(name="conclusion")
	private String conclusion;
	
	//Скарги
	@Column(name="complaints")
	private String complaints;
	
	@Column(name="factors")
	private String factors;
	
	@Column(name="diagnosis")
	private String diagnosis;
	
	@ManyToOne(cascade = {
			CascadeType.DETACH, 
			CascadeType.MERGE,	
			CascadeType.PERSIST,
			CascadeType.REFRESH
		})
	@JoinColumn(name="patient_id")
	private Patient patient;
}
