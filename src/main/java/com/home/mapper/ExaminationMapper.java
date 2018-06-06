package com.home.mapper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.home.dto.ExaminationCreationDto;
import com.home.dto.ExaminationDto;
import com.home.entity.Examination;
import com.home.entity.Patient;

public interface ExaminationMapper {

	public static ExaminationDto examinationToDto(Examination examination) {
		
		ExaminationDto examinationDto = new ExaminationDto();
		
		examinationDto.setId(examination.getId());
		examinationDto.setRegistrationDate(examination.getRegistrationDate());
		examinationDto.setAge(examination.getAge());
		examinationDto.setService(examination.getService());
		examinationDto.setPrice(examination.getPrice());
		examinationDto.setInstruments(examination.getInstruments());
		examinationDto.setMethods(examination.getMethods());
		examinationDto.setComplaints(examination.getComplaints());
		examinationDto.setConclusion(examination.getConclusion());
		examinationDto.setFactors(examination.getFactors());
		examinationDto.setPatient(examination.getPatient());
		examinationDto.setEmployee(examination.getEmployee());
		
		return examinationDto;
	}
	
	public static List<ExaminationDto> listExaminationToDto(List<Examination> examinations){
		List<ExaminationDto> dtos = new ArrayList<>();
		
		for(int i =0;i<examinations.size();i++) {
			ExaminationDto examinationDto = new ExaminationDto();
			
			examinationDto.setId(examinations.get(i).getId());
			examinationDto.setRegistrationDate(examinations.get(i).getRegistrationDate());
			examinationDto.setAge(examinations.get(i).getAge());
			examinationDto.setService(examinations.get(i).getService());
			examinationDto.setPrice(examinations.get(i).getPrice());
			examinationDto.setInstruments(examinations.get(i).getInstruments());
			examinationDto.setMethods(examinations.get(i).getMethods());
			examinationDto.setComplaints(examinations.get(i).getComplaints());
			examinationDto.setConclusion(examinations.get(i).getConclusion());
			examinationDto.setFactors(examinations.get(i).getFactors());
			examinationDto.setPatient(examinations.get(i).getPatient());
			examinationDto.setEmployee(examinations.get(i).getEmployee());
			dtos.add(examinationDto);
		}
		return dtos;
	}
	
	public static Examination CreationDtoToExamination(ExaminationCreationDto creationDto , Patient patient) {
		
		Examination examination = new Examination();
		
		examination.setPatient(patient);
		examination.setRegistrationDate(LocalDate.now());
		examination.setAge(LocalDate.now().getYear() - patient.getBirthday().getYear());
		examination.setService(creationDto.getService());
		examination.setPrice(new BigDecimal(creationDto.getPrice()));
		examination.setInstruments(creationDto.getInstruments());
		examination.setMethods(creationDto.getMethods());
		examination.setComplaints(creationDto.getComplaints());
		examination.setConclusion(creationDto.getConclusion());
		examination.setFactors(creationDto.getFactors());
		examination.setDiagnosis(creationDto.getDiagnosis());
		examination.setEmployee(creationDto.getEmployee());
		
		return examination;
	}
	
}
