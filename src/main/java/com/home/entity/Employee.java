package com.home.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	@OneToMany(mappedBy="employee",
			cascade = {
			CascadeType.DETACH, 
			CascadeType.MERGE,	
			CascadeType.PERSIST,
			CascadeType.REFRESH
		})
	private List<AdmissionsJournal> admissionsJournals = new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	@JoinColumn(name = "employee_info_id")
	private EmployeeInfo employeeInfo;
}
