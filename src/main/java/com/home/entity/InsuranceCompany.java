package com.home.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="insurance_company")
@Getter
@Setter
@NoArgsConstructor
public class InsuranceCompany extends BaseEntity{

	@Column(name="name")
	private String name;
	
	@Column(name="type")
	private String type;
	
	@Column(name="address")
	private String address;
	
	@Column(name="post_index")
	private String postIndex;
	
	@OneToMany(mappedBy="insuranceCompany",
			cascade = {
			CascadeType.DETACH, 
			CascadeType.MERGE,	
			CascadeType.PERSIST,
			CascadeType.REFRESH
		})
	private List<Patient> patients = new ArrayList<>();
}
