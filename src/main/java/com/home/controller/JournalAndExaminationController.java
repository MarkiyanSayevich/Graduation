package com.home.controller;

import java.math.BigDecimal;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.home.dto.AdmissionsJournalCreationDto;
import com.home.dto.ExaminationCreationDto;
import com.home.dto.ExaminationDto;
import com.home.entity.AdmissionsJournal;
import com.home.entity.Employee;
import com.home.entity.Examination;
import com.home.entity.Patient;
import com.home.filter.SimpleFilter;
import com.home.mapper.AdmissionsJournalMapper;
import com.home.mapper.ExaminationMapper;
import com.home.service.AdmissionJournalService;
import com.home.service.EmployeeService;
import com.home.service.ExaminationService;
import com.home.service.InsuranceCompanyService;
import com.home.service.PatientService;

@Controller
public class JournalAndExaminationController {

	private EmployeeService employeeService;
	private PatientService patientService;
	private InsuranceCompanyService insuranceCompanyService;
	private AdmissionJournalService admissionJournalService;
	private ExaminationService examinationService;
	
	@Autowired
	public JournalAndExaminationController(EmployeeService employeeService, PatientService patientService,
			InsuranceCompanyService insuranceCompanyService, AdmissionJournalService admissionJournalService,
			ExaminationService examinationService) {
		this.employeeService = employeeService;
		this.patientService = patientService;
		this.insuranceCompanyService = insuranceCompanyService;
		this.admissionJournalService = admissionJournalService;
		this.examinationService = examinationService;
	}
	
	
	@GetMapping("/journal")
	public String showAdmissionsJournal(@PageableDefault Pageable pageable ,Model model) {
		
//		List<AdmissionsJournal> admissionsJournals = admissionJournalService.findAllJournals();
//		List<AdmissionsJournalDto> admissionsJournalDtos = AdmissionsJournalMapper.listJournalsToDto(admissionsJournals);
//		
//		model.addAttribute("admissionsDtoModel", admissionsJournalDtos);
		
		Page<AdmissionsJournal> page = admissionJournalService.pageAdmissionJournal(pageable);
		
		int currentPage = page.getNumber();
		
		model.addAttribute("filterModel", new SimpleFilter());
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageModel", page);
		model.addAttribute("journalModel", page.getContent());
		
		return "/journal/show";
	}
	
	@GetMapping("/journal/filter")
	public String showJournalFilter(@PageableDefault Pageable pageable ,Model model ,@ModelAttribute("filterModel") SimpleFilter filter) {
		
		
		Page<AdmissionsJournal> page = admissionJournalService.pageFilterAdmissionJournal(pageable, filter);
		
		int currentPage = page.getNumber();
		
		model.addAttribute("filterModel", filter);
		model.addAttribute("sizeModel", filter.getSize());
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageModel", page);
		model.addAttribute("journalModel", page.getContent());
		
		return "/journal/show";
	}
	
	@GetMapping("/journal/create")
	public String showAddJournal(Model model) {
		
		List<Patient> patients = patientService.findAllPatients();
		
		model.addAttribute("journalDtoModel", new AdmissionsJournalCreationDto());
		model.addAttribute("patientsDtoModel", patients);
		
		return "/journal/create";
	}
	
	@PostMapping("/journal/create")
	public String confirmJournalAdd(@ModelAttribute("journalDtoModel") AdmissionsJournalCreationDto journalCreationDto) {
		
		AdmissionsJournal admissionsJournal = AdmissionsJournalMapper.dtoCreationToJournal(journalCreationDto);
		admissionJournalService.saveAdmJournal(admissionsJournal);
		
		return"redirect:/journal";
	}
	
	@GetMapping("journal/delete/{journalId}")
	public String deleteJournal(@PathVariable("journalId") Integer id) {
		
		admissionJournalService.deleteJournalWithId(id);
		
		return "redirect:/journal";
	}
	
	@GetMapping("/journal/examination/{patientId}/{journalId}")
	public String showExaminations(@PathVariable("patientId") Integer id, @PathVariable("journalId")Integer journalId,Model model) {
		
		List<Examination> examinations = examinationService.findAllExaminationWherePatientId(id);
		List<ExaminationDto> dtos = ExaminationMapper.listExaminationToDto(examinations);
		
		AdmissionsJournal admissionsJournal = admissionJournalService.getOneById(journalId);
		
		double price = 00.00;
		
		for (ExaminationDto examinationDto : dtos) {
			double onePrice = examinationDto.getPrice().longValueExact();
			price +=onePrice;
		}
		admissionsJournal.setAllPrice(new BigDecimal(price));
		
		String url = "/journal/examination/" + id + "/" + journalId;
		
		model.addAttribute("backUrl", url);
		model.addAttribute("priceModel", price);
		model.addAttribute("notesModel", admissionsJournal.getNotes());
		model.addAttribute("patientIdModel" , id);
		model.addAttribute("journalIdModel", journalId);
		model.addAttribute("examinationsDtoModel", dtos);
		
		return "/examination/show";
	}
	
	@GetMapping("/journal/examination/create/{patientId}/{journalId}")
	public String showCreateExamination(@PathVariable("patientId")Integer id, @PathVariable("journalId")Integer journalId, Model model) {
		
		List<Employee> employees = employeeService.findAllEmployee();
		
		model.addAttribute("examinationCreationDtoModel", new ExaminationCreationDto());
		model.addAttribute("employeesModel", employees);
		model.addAttribute("patientIdModel", id);
		model.addAttribute("journalIdModel", journalId);
		
		return "examination/create";
	}
	
	@PostMapping("/journal/examination/create")
	public String confirmCreateExamination(@RequestParam("patientId") Integer id,@ModelAttribute("examinationCreationDtoModel") ExaminationCreationDto creationDto) {
		
		Patient patient = patientService.getOnePatient(id);
		
		Examination examination = ExaminationMapper.CreationDtoToExamination(creationDto, patient);
		
		examinationService.saveExamination(examination);
		
		return "redirect:/journal";
	}
	
	@GetMapping("/journal/examination/info/{examinationId}/{patientId}/{journalId}")
	public String showExaminationInfo(@PathVariable("patientId")Integer patientId, @PathVariable("journalId")Integer journalId,@PathVariable("examinationId") Integer id, Model model) {
		
		ExaminationDto dto = ExaminationMapper.examinationToDto(examinationService.getOneExamination(id));
		
		model.addAttribute("examinationDtoModel", dto);
		
		model.addAttribute("patientIdModel", patientId);
		model.addAttribute("journalIdModel", journalId);
		model.addAttribute("examinationIdModel", id);
		
		return "examination/info";
	}
	
	@GetMapping("/journal/examination/info/edit/{examinationId}")
	public String editExamination(@PathVariable("examinationId")Integer id , Model model) {
		
		ExaminationDto dto = ExaminationMapper.examinationToDto(examinationService.getOneExamination(id));
		
		List<Employee> employees = employeeService.findAllEmployee();
		
		model.addAttribute("examinationDtoModel", dto);
		model.addAttribute("employeesModel", employees);
		
		return "examination/edit";
	}
	
	@PostMapping("/journal/examination/info/edit")
	public String editExaminationConfirm(@ModelAttribute("examinationDtoModel") ExaminationDto dto) {
		
		Examination examination = ExaminationMapper.editToExamination(dto);
		
		examinationService.saveExamination(examination);
		
		return "redirect:/journal/examination/info/" + examination.getId();
	}
	
	
	@GetMapping("/journal/examination/delete/{patientId}/{examinationId}")
	public String deleteExamination(@PathVariable("examinationId") Integer examId ,@PathVariable("patientId") Integer patientId) {
		
		examinationService.deleteExaminationWithId(examId);
		
		//переробити редірект 
		return "redirect:/journal";
	}
}
