package com.home.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.home.entity.Examination;

@Repository
public interface ExaminationRepository extends JpaRepository<Examination, Integer> , JpaSpecificationExecutor<Examination>{

	@Query("SELECT e FROM Examination e JOIN e.patient p WHERE p.id = :id")
	List<Examination> findAllFithPatientId(@Param("id") Integer id);
	
	@Query("SELECT e FROM Examination e JOIN e.employee em WHERE em.id = :id")
	List<Examination> findAllWithEmployeeId(@Param("id") Integer id);
}
