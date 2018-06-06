package com.home.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.home.dto.PatientDto;
import com.home.dto.PatientDtoRegistration;
import com.home.entity.Patient;

public interface PatientMapper {

	public static PatientDto patientToDto(Patient patient) {
		PatientDto dto = new PatientDto();
		
		dto.setId(patient.getId());
		dto.setFullName(patient.getFullName());
		dto.setBirthday(patient.getBirthday());
		dto.setGender(patient.getGender());
		dto.setAddress(patient.getAddress());
		dto.setPhoneNumber(patient.getPhoneNumber());
		dto.setPatientCardNumber(patient.getPatientCardNumber());
		dto.setPatientStatus(patient.getPatientStatus());
		dto.setRegistrationDate(patient.getRegistrationDate());
		dto.setAdmissionsJournals(patient.getAdmissionsJournals());
		dto.setExaminations(patient.getExaminations());
		dto.setInsuranceCompany(patient.getInsuranceCompany());
		
		return dto;
	}
	
	public static List<PatientDto> patientListToDto(List<Patient> patients){
		
		List<PatientDto> patientDtos = new ArrayList<>();
		
		for(int i = 0;i< patients.size();i++) {
			
			PatientDto dto = new PatientDto();
			
			dto.setId(patients.get(i).getId());
			dto.setFullName(patients.get(i).getFullName());
			dto.setBirthday(patients.get(i).getBirthday());
			dto.setGender(patients.get(i).getGender());
			dto.setAddress(patients.get(i).getAddress());
			dto.setPhoneNumber(patients.get(i).getPhoneNumber());
			dto.setPatientCardNumber(patients.get(i).getPatientCardNumber());
			dto.setPatientStatus(patients.get(i).getPatientStatus());
			dto.setRegistrationDate(patients.get(i).getRegistrationDate());
			dto.setAdmissionsJournals(patients.get(i).getAdmissionsJournals());
			dto.setExaminations(patients.get(i).getExaminations());
			dto.setInsuranceCompany(patients.get(i).getInsuranceCompany());
			patientDtos.add(dto);
		}
		
		return patientDtos;
	}
	
	
	public static Patient DtoRegistrationToPatient(PatientDtoRegistration dtoRegistration) {
		Patient patient = new Patient();
		
		patient.setFullName(dtoRegistration.getFullName());
		patient.setBirthday(LocalDate.of(dtoRegistration.getYear(), dtoRegistration.getMounth(), dtoRegistration.getDay()));
		patient.setGender(dtoRegistration.getGender());
		patient.setAddress(dtoRegistration.getAddress());
		patient.setPhoneNumber(dtoRegistration.getPhoneNumber());
		patient.setPatientCardNumber(dtoRegistration.getPatientCardNumber());
		patient.setPatientStatus(dtoRegistration.getPatientStatus());
		patient.setRegistrationDate(LocalDate.now());
		patient.setInsuranceCompany(dtoRegistration.getInsuranceCompany());
		
		return patient;
	}
	
	public static Patient DtoToPatient(PatientDto dto) {
		
		Patient patient = new Patient();
		
		patient.setId(dto.getId());
		patient.setFullName(dto.getFullName());
		patient.setBirthday(dto.getBirthday());
		patient.setGender(dto.getGender());
		patient.setAddress(dto.getAddress());
		patient.setPhoneNumber(dto.getPhoneNumber());
		patient.setPatientCardNumber(dto.getPatientCardNumber());
		patient.setPatientStatus(dto.getPatientStatus());
		patient.setRegistrationDate(dto.getRegistrationDate());
		patient.setAdmissionsJournals(dto.getAdmissionsJournals());
		patient.setExaminations(dto.getExaminations());
		patient.setInsuranceCompany(dto.getInsuranceCompany());
		
		return patient;
	}
}
