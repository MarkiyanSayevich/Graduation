package com.home.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="admission_journal")
@Getter
@Setter
@NoArgsConstructor
public class AdmissionsJournal extends BaseEntity {

	@Column(name="create_journey_time")
	private LocalDate createJourneyTime;
	
	@Column(name="all_price")
	private BigDecimal allPrice;
	
	@Column(name="notes")
	private String notes;
}
