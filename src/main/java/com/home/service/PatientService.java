package com.home.service;

import java.util.List;

import com.home.entity.Patient;

public interface PatientService {

	void savePatient(Patient patient);
	
	Patient getOnePatient(int id);
	
	List<Patient> findAllPatients();
}
