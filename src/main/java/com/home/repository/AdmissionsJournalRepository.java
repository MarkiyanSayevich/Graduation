package com.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.home.entity.AdmissionsJournal;

@Repository
public interface AdmissionsJournalRepository extends JpaRepository<AdmissionsJournal, Integer>, JpaSpecificationExecutor<AdmissionsJournal>{

}
