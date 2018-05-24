package com.home.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
}
