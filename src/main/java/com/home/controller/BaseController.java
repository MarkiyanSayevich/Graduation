package com.home.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.home.dto.EnterDto;
import com.home.entity.AdmissionsJournal;
import com.home.entity.Employee;
import com.home.entity.Examination;
import com.home.entity.InsuranceCompany;
import com.home.entity.Patient;
import com.home.repository.AdmissionsJournalRepository;
import com.home.repository.EmployeeRepository;
import com.home.repository.ExaminationRepository;
import com.home.repository.InsuranceCompanyRepository;
import com.home.repository.PatientRepository;

@Controller
@RequestMapping("/")
public class BaseController {
	
	private EmployeeRepository employeeRepos;
	private ExaminationRepository examinationRepos;
	private PatientRepository patientRepos;
	private AdmissionsJournalRepository admisJournalRepos;
	private InsuranceCompanyRepository companyRepos;
	
	
	@Autowired
	public BaseController(EmployeeRepository employeeRepos, ExaminationRepository examinationRepos,
			PatientRepository patientRepos, AdmissionsJournalRepository admisJournalRepos,
			InsuranceCompanyRepository companyRepos) {
		this.employeeRepos = employeeRepos;
		this.examinationRepos = examinationRepos;
		this.patientRepos = patientRepos;
		this.admisJournalRepos = admisJournalRepos;
		this.companyRepos = companyRepos;
	}

	@GetMapping("/")
	public String showMainPage() {
		
		return "base/main";
	}
	
	@GetMapping("/enter")
	public String showEnter(Model model) {
		
		model.addAttribute("enterModel", new EnterDto());
		
		return "base/enter";
	}
	
	@PostMapping("/enter")
	public String enterConfirm(@Valid @ModelAttribute("enterModel") EnterDto enterDto,
			BindingResult br) {
		
		if(br.hasErrors()) {
			return "base/enter";
		}
		return "redirect:/";
	}
	
//	@GetMapping("/persist")
//	public String addPersists() {
//		
//		Patient patient = patientRepos.getOne(1);
//		InsuranceCompany company = companyRepos.getOne(1);
//		Employee employee = employeeRepos.getOne(1);
//		Examination examination = examinationRepos.getOne(1);
//		AdmissionsJournal admissionsJournal = admisJournalRepos.getOne(1);
//		
//		patient.setInsuranceCompany(company);
//		admissionsJournal.setPatient(patient);
//		admissionsJournal.setEmployee(employee);
//		examination.setPatient(patient);
//		patientRepos.save(patient);
//		admisJournalRepos.save(admissionsJournal);
//		examinationRepos.save(examination);
//		
//		return "base/persists";
//	}
	
}
