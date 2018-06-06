package com.home.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.home.entity.AdmissionsJournal;
import com.home.filter.SimpleFilter;

public interface AdmissionJournalService {

	void saveAdmJournal(AdmissionsJournal admissionsJournal);
	
	AdmissionsJournal getOneById(int id);
	
	List<AdmissionsJournal> findAllJournals();
	
	void deleteJournalWithId(int id);
	
	Page<AdmissionsJournal> pageAdmissionJournal(Pageable pageable);
	
	Page<AdmissionsJournal> pageFilterAdmissionJournal(Pageable pageable , SimpleFilter filter);
}
