package com.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.entity.AdmissionsJournal;
import com.home.repository.AdmissionsJournalRepository;
import com.home.service.AdmissionJournalService;

@Service
public class AdmissionJournalServiceImpl implements AdmissionJournalService{

	@Autowired AdmissionsJournalRepository admissionJournalRepos;
	
	@Override
	public void saveAdmJournal(AdmissionsJournal admissionsJournal) {
		admissionJournalRepos.save(admissionsJournal);
	}

	@Override
	public AdmissionsJournal getOneById(int id) {
		return admissionJournalRepos.getOne(id);
	}

	@Override
	public List<AdmissionsJournal> findAllJournals() {
		return admissionJournalRepos.findAll();
	}

}
