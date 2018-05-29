package com.home.service;

import java.util.List;

import com.home.entity.AdmissionsJournal;

public interface AdmissionJournalService {

	void saveAdmJournal(AdmissionsJournal admissionsJournal);
	
	AdmissionsJournal getOneById(int id);
	
	List<AdmissionsJournal> findAllJournals();
}
