package com.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.entity.Examination;
import com.home.repository.ExaminationRepository;
import com.home.service.ExaminationService;

@Service
public class ExaminationServiceImpl implements ExaminationService{

	@Autowired ExaminationRepository examinationRepos;
	
	@Override
	public void saveExamination(Examination examination) {
		examinationRepos.save(examination);
	}

	@Override
	public Examination getOneExamination(int id) {
		return examinationRepos.getOne(id);
	}

	@Override
	public List<Examination> findAllExaminations() {
		return examinationRepos.findAll();
	}

}
