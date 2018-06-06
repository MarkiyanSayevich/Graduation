package com.home.mapper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.home.dto.AdmissionsJournalCreationDto;
import com.home.dto.AdmissionsJournalDto;
import com.home.entity.AdmissionsJournal;

public interface AdmissionsJournalMapper {

	public static AdmissionsJournalDto journalToDto(AdmissionsJournal admissionsJournal) {
		AdmissionsJournalDto admissionsJournalDto = new AdmissionsJournalDto();
		
		admissionsJournalDto.setId(admissionsJournal.getId());
		admissionsJournalDto.setPatient(admissionsJournal.getPatient());
		admissionsJournalDto.setAllPrice(admissionsJournal.getAllPrice());
		admissionsJournalDto.setNotes(admissionsJournal.getNotes());
		admissionsJournalDto.setCreateJourneyTime(admissionsJournal.getCreateJourneyTime());
		
		return admissionsJournalDto;
	} 
	
	public static List<AdmissionsJournalDto> listJournalsToDto(List<AdmissionsJournal> admissionsJournals){
		List<AdmissionsJournalDto> admissionsJournalDtos = new ArrayList<>();
		
		for(int i=0; i< admissionsJournals.size();i++) {
			AdmissionsJournalDto admissionsJournalDto = new AdmissionsJournalDto();
			
			admissionsJournalDto.setId(admissionsJournals.get(i).getId());
			admissionsJournalDto.setPatient(admissionsJournals.get(i).getPatient());
			admissionsJournalDto.setAllPrice(admissionsJournals.get(i).getAllPrice());
			admissionsJournalDto.setNotes(admissionsJournals.get(i).getNotes());
			admissionsJournalDto.setCreateJourneyTime(admissionsJournals.get(i).getCreateJourneyTime());
			admissionsJournalDtos.add(admissionsJournalDto);
		}
		return admissionsJournalDtos;
	}
	
	public static AdmissionsJournal dtoCreationToJournal(AdmissionsJournalCreationDto creationDto) {
		
		AdmissionsJournal admissionsJournal = new AdmissionsJournal();
		
		admissionsJournal.setAllPrice(new BigDecimal("00"));
		admissionsJournal.setCreateJourneyTime(LocalDate.now());
		admissionsJournal.setNotes(creationDto.getNotes());
		admissionsJournal.setPatient(creationDto.getPatient());
		
		return admissionsJournal;
	}
}