package com.home.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.home.entity.Patient;

import lombok.Data;

@Data
public class AdmissionsJournalDto {

	private Integer id;
	
	private LocalDate createJourneyTime;
	
	private BigDecimal allPrice;
	
	private String notes;
	
	private Patient patient;
}
