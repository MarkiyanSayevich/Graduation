package com.home.dto;

import java.util.ArrayList;
import java.util.List;

import com.home.entity.Patient;

import lombok.Data;

@Data
public class InsuranceCompanyDto {
	
	private Integer id;
	
	private String name;
	
	private String type;
	
	private String address;
	
	private String postIndex;
	
	private List<Patient> patients = new ArrayList<>();
}
