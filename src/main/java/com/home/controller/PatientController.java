package com.home.controller;

import static com.home.mapper.PatientMapper.DtoRegistrationToPatient;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.home.dto.PatientDto;
import com.home.dto.PatientDtoRegistration;
import com.home.dto.PatientEditDto;
import com.home.entity.InsuranceCompany;
import com.home.entity.Patient;
import com.home.entity.enums.Gender;
import com.home.entity.enums.PatientStatus;
import com.home.filter.SimpleFilter;
import com.home.mapper.PatientMapper;
import com.home.service.AdmissionJournalService;
import com.home.service.EmployeeService;
import com.home.service.ExaminationService;
import com.home.service.InsuranceCompanyService;
import com.home.service.PatientService;

@Controller
public class PatientController {

	private EmployeeService employeeService;
	private PatientService patientService;
	private InsuranceCompanyService insuranceCompanyService;
	private AdmissionJournalService admissionJournalService;
	private ExaminationService examinationService;
	
	@Autowired
	public PatientController(EmployeeService employeeService, PatientService patientService,
			InsuranceCompanyService insuranceCompanyService, AdmissionJournalService admissionJournalService,
			ExaminationService examinationService) {
		this.employeeService = employeeService;
		this.patientService = patientService;
		this.insuranceCompanyService = insuranceCompanyService;
		this.admissionJournalService = admissionJournalService;
		this.examinationService = examinationService;
	}
	
	@GetMapping("/patient")
	public String showPatients(@PageableDefault Pageable pageable ,Model model) {
		
//		List<Patient> patients = patientService.findAllPatients();
//		List<PatientDto> patientDtos = patientListToDto(patients);
//		
//		model.addAttribute("patientsDtoModel", patientDtos);
		
		Page<Patient> page = patientService.pagePatient(pageable);
		
		int currentPage = page.getNumber();
		
		model.addAttribute("filterModel", new SimpleFilter());
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageModel", page);
		model.addAttribute("patientModel", page.getContent());
		
		return "patient/show";
	}
	
	@GetMapping("/patient/filter")
	public String showpatientFilter(@PageableDefault Pageable pageable, Model model, @ModelAttribute("filterModel") SimpleFilter filter) {
		
		Page<Patient> page = patientService.pagePatientFilter(pageable, filter);
		
		int currentPage = page.getNumber();
		
		model.addAttribute("filterModel", filter);
		model.addAttribute("sizeModel", filter.getSize());
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageModel", page);
		model.addAttribute("patientModel", page.getContent());
		
		return "/patient/show";
	}
	
	@GetMapping("/patient/add")
	public String showAddPatient(Model model) {
		
		List<Gender> genders = Arrays.asList(Gender.ЧОЛОВІК,Gender.ЖІНКА,Gender.НЕВИЗНАЧЕНИЙ);
		List<InsuranceCompany> insuranceCompanies = insuranceCompanyService.findAllCompanies();
		List<PatientStatus> status = Arrays.asList(PatientStatus.АМБУЛАТОРНИЙ,PatientStatus.БЮДЖЕТНИЙ,PatientStatus.ГОСПРОЗРАХУНКОВИЙ,PatientStatus.СТАЦІОНАРНИЙ);
		
		model.addAttribute("patientDtoRegistrationModel", new PatientDtoRegistration());
		model.addAttribute("genderModel", genders);
		model.addAttribute("companyModel", insuranceCompanies);
		model.addAttribute("statusModel", status);
		
		return "patient/add";
	}
	
	@PostMapping("/patient/add")
	public String ConfirmAddPatient(@ModelAttribute("patientDtoRegistrationModel") PatientDtoRegistration dtoRegistration) {
		
		Patient patient = DtoRegistrationToPatient(dtoRegistration);
		patientService.savePatient(patient);
		
		return"redirect:/patient";
	}
	
	@GetMapping("/patient/info/{patientId}")
	public String showPatientInfo(@PathVariable("patientId")Integer id, Model model) {
		
		PatientDto dto = PatientMapper.patientToDto(patientService.getOnePatient(id));
		
		model.addAttribute("patientDtoModel", dto);
		
		return "/patient/info";
	}
	
	@GetMapping("/patient/info/edit/{patientId}")
	public String editPatient(@PathVariable("patientId")Integer id, Model model) {
		
		PatientEditDto dto = PatientMapper.patientToEdit(patientService.getOnePatient(id));
		
		List<InsuranceCompany> insuranceCompanies = insuranceCompanyService.findAllCompanies();
		
		model.addAttribute("companiesModel", insuranceCompanies);
		model.addAttribute("patientEditRegistration", dto);
		
		return "/patient/edit";
	}
	
	@PostMapping("/patient/info/edit")
	public String editPatientConfirm(@ModelAttribute("patientEditRegistration")PatientEditDto dto) {
		
		Patient patient = PatientMapper.editToPatient(dto);
		
		
		patientService.savePatient(patient);
		
		return "redirect:/patient/info/" + patient.getId();
	}
	
	
	@GetMapping("/patient/delete/{patientId}")
	public String deletePatient(@PathVariable("patientId") Integer id) {
		
		patientService.deletePatientWithId(id);
		
		return "redirect:/patient";
	}
	
}
