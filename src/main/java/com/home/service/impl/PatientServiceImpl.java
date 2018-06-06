package com.home.service.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.home.entity.Patient;
import com.home.filter.SimpleFilter;
import com.home.repository.PatientRepository;
import com.home.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {



	@Autowired PatientRepository patientRepos;
	
	
	@Override
	public void deletePatientWithId(int id) {
		patientRepos.deleteById(id);
	}
	
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

	@Override
	public Page<Patient> pagePatient(Pageable pageable) {
		return patientRepos.findAll(pageable);
	}
	
	@Override
	public Page<Patient> pagePatientFilter(Pageable pageable, SimpleFilter filter) {
		return patientRepos.findAll(getSpecification(filter), pageable);
	}
	
	private static Specification<Patient> getSpecification(SimpleFilter filter){
		return new Specification<Patient>() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Patient> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				if(filter.getName().isEmpty()) {
					return null;
				} else return criteriaBuilder.like(root.get("fullName"), "%" + filter.getName() + "%");
			}
		};
	}
}
