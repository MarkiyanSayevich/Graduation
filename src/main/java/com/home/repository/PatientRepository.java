package com.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.home.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> , JpaSpecificationExecutor<Patient>{

}
