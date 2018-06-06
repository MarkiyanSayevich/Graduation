package com.home.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.home.entity.Examination;
import com.home.filter.SimpleFilter;

public interface ExaminationService {

	void saveExamination(Examination examination);
	
	Examination getOneExamination(int id);
	
	List<Examination> findAllExaminations();
	
	List<Examination> findAllExaminationWherePatientId(Integer id);
	
	void deleteExaminationWithId(int id);
	
	List<Examination> findAllWhereEmployeeId(int id);
}
