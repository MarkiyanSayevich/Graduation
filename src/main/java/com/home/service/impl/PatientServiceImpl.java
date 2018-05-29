package com.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.entity.Patient;
import com.home.repository.PatientRepository;
import com.home.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired PatientRepository patientRepos;
	
	@Override
	public void savePatient(Patient patient) {
		patientRepos.save(patient);
	}

	@Override
	public Patient getOnePatient(int id) {
		return patientRepos.getOne(id);
	}

	@Override
	public List<Patient> findAllPatients() {
		return patientRepos.findAll();
	}

}
