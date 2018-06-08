package com.home.controller;

import static com.home.mapper.InsuraceCompanyMapper.dtoRegistrationToCompany;

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

import com.home.dto.InsuranceCompanyDto;
import com.home.dto.InsuranceCompanyDtoRegistration;
import com.home.entity.InsuranceCompany;
import com.home.filter.SimpleFilter;
import com.home.mapper.InsuraceCompanyMapper;
import com.home.service.AdmissionJournalService;
import com.home.service.EmployeeService;
import com.home.service.ExaminationService;
import com.home.service.InsuranceCompanyService;
import com.home.service.PatientService;

@Controller
public class InsuranceCompanyController {

	private EmployeeService employeeService;
	private PatientService patientService;
	private InsuranceCompanyService insuranceCompanyService;
	private AdmissionJournalService admissionJournalService;
	private ExaminationService examinationService;
	
	@Autowired
	public InsuranceCompanyController(EmployeeService employeeService, PatientService patientService,
			InsuranceCompanyService insuranceCompanyService, AdmissionJournalService admissionJournalService,
			ExaminationService examinationService) {
		this.employeeService = employeeService;
		this.patientService = patientService;
		this.insuranceCompanyService = insuranceCompanyService;
		this.admissionJournalService = admissionJournalService;
		this.examinationService = examinationService;
	}
	
	@GetMapping("/company")
	public String showCompanies(@PageableDefault Pageable pageable,Model model) {

		Page<InsuranceCompany> page = insuranceCompanyService.companyPage(pageable);
		
		int currentPage = page.getNumber();
		
		model.addAttribute("filterModel", new SimpleFilter());
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageModel", page);
		model.addAttribute("companiesModel", page.getContent());
		
		return "insurance-company/show";
	}
	
	@GetMapping("/company/filter")
	public String showFilter(@PageableDefault Pageable pageable ,Model model ,@ModelAttribute("filterModel") SimpleFilter filter) {
		
		
		Page<InsuranceCompany> page = insuranceCompanyService.companyPageFilter(pageable, filter);
		
		int currentPage = page.getNumber();
		
		model.addAttribute("filterModel", filter);
		model.addAttribute("sizeModel", filter.getSize());
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageModel", page);
		model.addAttribute("companiesModel", page.getContent());
		
		return "insurance-company/show";
	}
	
	@GetMapping("/company/info/edit/{companyId}")
	public String editCompany(@PathVariable("companyId")Integer id, Model model) {
	
		InsuranceCompanyDto companyDto = InsuraceCompanyMapper.companyToDto(insuranceCompanyService.getOneCompany(id));
		
		model.addAttribute("companyDtoModel", companyDto);
		
		return "insurance-company/edit";
	}
	
	@PostMapping("/company/info/edit")
	public String editCompanyConfirm(@ModelAttribute("companyDtoModel") InsuranceCompanyDto dto) {
		
		InsuranceCompany company = InsuraceCompanyMapper.editDtoToCompany(dto);
		
		insuranceCompanyService.saveInsuranceCompany(company);
		
		return "redirect:/company/info/" + company.getId();
	}
	
	@GetMapping("/company/add")
	public String showAdd(Model model) {
		
		model.addAttribute("companyDtoRegistrationModel", new InsuranceCompanyDtoRegistration());
		
		return "insurance-company/add";
	}
	
	@PostMapping("/company/add")
	public String confirmCompanyAdd(@ModelAttribute("companyDtoModel") InsuranceCompanyDtoRegistration companyDtoRegistration) {
		
		InsuranceCompany company = dtoRegistrationToCompany(companyDtoRegistration);
		insuranceCompanyService.saveInsuranceCompany(company);
		
		return "redirect:/company";
	}
	
	@GetMapping("/company/info/{companyId}")
	public String showCompanyInfo(@PathVariable("companyId")Integer id, Model model) {
		
		InsuranceCompanyDto companyDto = InsuraceCompanyMapper.companyToDto(insuranceCompanyService.getOneCompany(id));
		
		model.addAttribute("companyDtoModel", companyDto);
		
		return "/insurance-company/info";
	}
	
	@GetMapping("/company/delete/{companyId}")
	public String companyDelete(@PathVariable("companyId") Integer id) {
		
		InsuranceCompany company = insuranceCompanyService.getOneCompany(id);
		company.setPatients(null);
		insuranceCompanyService.saveInsuranceCompany(company);
		
		insuranceCompanyService.deleteCompanyWithId(id);
		
		return "redirect:/company";
	}
	
}
