package com.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.entity.Examination;

@Repository
public interface ExaminationRepository extends JpaRepository<Examination, Integer> {

}
