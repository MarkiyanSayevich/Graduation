package com.home.service;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.home.entity.Patient;
import com.home.filter.SimpleFilter;

public interface PatientService {

	void savePatient(Patient patient);
	
	Patient getOnePatient(int id);
	
	List<Patient> findAllPatients();
	
	void deletePatientWithId(int id);
	
	Page<Patient> pagePatient(Pageable pageable);
	
	Page<Patient> pagePatientFilter(Pageable pageable , SimpleFilter filter);
}
