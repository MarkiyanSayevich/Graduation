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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.home.dto.EnterDto;
import com.home.service.AdmissionJournalService;
import com.home.service.EmployeeService;
import com.home.service.ExaminationService;
import com.home.service.InsuranceCompanyService;
import com.home.service.PatientService;
import com.home.service.utils.CustomFileUtils;

@Controller
@RequestMapping("/")
public class BaseController {
	
	private EmployeeService employeeService;
	private PatientService patientService;
	private InsuranceCompanyService insuranceCompanyService;
	private AdmissionJournalService admissionJournalService;
	private ExaminationService examinationService;
	
	@Autowired
	public BaseController(EmployeeService employeeService, PatientService patientService,
			InsuranceCompanyService insuranceCompanyService, AdmissionJournalService admissionJournalService,
			ExaminationService examinationService) {
		super();
		this.employeeService = employeeService;
		this.patientService = patientService;
		this.insuranceCompanyService = insuranceCompanyService;
		this.admissionJournalService = admissionJournalService;
		this.examinationService = examinationService;
	}

	@GetMapping("/main-page")
	public String showMainPage() {
		
		return "base/main";
	}
	
	@GetMapping("/")
	public String showEnter(Model model) {
		
		model.addAttribute("enterModel", new EnterDto());
		
		return "base/enter";
	}
	
	@PostMapping("/")
	public String enterConfirm(@Valid @ModelAttribute("enterModel") EnterDto enterDto,
			BindingResult br) {
		
		if(br.hasErrors()) {
			return "base/enter";
		}
		return "redirect:/main-page";
	}
}
