package com.home.service;

import java.util.List;

import com.home.entity.Examination;

public interface ExaminationService {

	void saveExamination(Examination examination);
	
	Examination getOneExamination(int id);
	
	List<Examination> findAllExaminations();
}
