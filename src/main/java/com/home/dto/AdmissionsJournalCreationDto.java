package com.home.dto;

import com.home.entity.Patient;

import lombok.Data;

@Data
public class AdmissionsJournalCreationDto {

	private Patient patient;
	
	private String notes;
}
