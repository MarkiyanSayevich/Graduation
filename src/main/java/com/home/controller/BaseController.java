package com.home.controller;

import static com.home.mapper.EmployeeMapper.ListEmployeeForDto;
import static com.home.mapper.EmployeeMapper.dtoRegistrationToEmployee;
import static com.home.mapper.InsuraceCompanyMapper.dtoRegistrationToCompany;
import static com.home.mapper.InsuraceCompanyMapper.listCompanyToDto;
import static com.home.mapper.PatientMapper.DtoRegistrationToPatient;
import static com.home.mapper.PatientMapper.patientListToDto;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.home.dto.AdmissionsJournalCreationDto;
import com.home.dto.AdmissionsJournalDto;
import com.home.dto.EmployeeDto;
import com.home.dto.EmployeeDtoRegistration;
import com.home.dto.EnterDto;
import com.home.dto.ExaminationCreationDto;
import com.home.dto.ExaminationDto;
import com.home.dto.InsuranceCompanyDto;
import com.home.dto.InsuranceCompanyDtoRegistration;
import com.home.dto.PatientDto;
import com.home.dto.PatientDtoRegistration;
import com.home.entity.AdmissionsJournal;
import com.home.entity.Employee;
import com.home.entity.Examination;
import com.home.entity.InsuranceCompany;
import com.home.entity.Patient;
import com.home.entity.enums.Gender;
import com.home.entity.enums.PatientStatus;
import com.home.filter.SimpleFilter;
import com.home.mapper.AdmissionsJournalMapper;
import com.home.mapper.EmployeeMapper;
import com.home.mapper.ExaminationMapper;
import com.home.mapper.InsuraceCompanyMapper;
import com.home.mapper.PatientMapper;
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
	
//	@GetMapping("/file")
//	public String showFileAdd() {
//		
//		return "base/file";
//	}
//	
//	@PostMapping("/file")
//	public String addFile(@RequestParam("file") MultipartFile file) throws IOException {
//		
//		System.out.println(file.getOriginalFilename());
//		CustomFileUtils.createImage("default", file);
//		
//		return "redirect:/main-page";
//	}
	
	@GetMapping("/employee")
	public String showEmployee(@PageableDefault Pageable pageable,Model model) {
		
//		List<Employee> employees = employeeService.findAllEmployee();
//		List<EmployeeDto> employeeDtos = ListEmployeeForDto(employees);
//		
//		model.addAttribute("employeesDtoModel", employeeDtos);
		
		Page<Employee> page = employeeService.pageEmployee(pageable);
		
		int currentPage = page.getNumber();
		
		model.addAttribute("filterModel", new SimpleFilter());
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageModel", page);
		model.addAttribute("employeeModel", page.getContent());
		
		return "employee/show";
	}
	
	@GetMapping("/employee/filter")
	public String showEmployeePageFilter(@ModelAttribute("filterModel") SimpleFilter filter, @PageableDefault Pageable pageable ,Model model) {
		
		
		Page<Employee> page = employeeService.pageEmployeeFilter(filter, pageable);
		int currentPage = page.getNumber();
		
		model.addAttribute("filterModel", filter);
		model.addAttribute("sizeModel", filter.getSize());
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageModel", page);
		model.addAttribute("employeeModel", page.getContent());
		
		return "employee/show";
	}
	
	@GetMapping("/employee/info/{employeeId}")
	public String showEmployeeInfo(@PathVariable("employeeId") Integer id, Model model) throws IOException {
		
		EmployeeDto employeeDto = EmployeeMapper.EmployeeForDto(employeeService.getOneEmployee(id));
		
		List<ExaminationDto> examinationDtos = ExaminationMapper.listExaminationToDto(examinationService.findAllWhereEmployeeId(id));
		
		CustomFileUtils.createFolder("employee_" + id);
		
		if(employeeDto.getEmployeeInfo().getImageName() == null) {
			String encodeFile = CustomFileUtils.getImage("default", "default.png");
			model.addAttribute("imgSrc", encodeFile);
		} else {
			String encodeFile = CustomFileUtils.getImage("employee_" + id , employeeDto.getEmployeeInfo().getImageName());
			model.addAttribute("imgSrc", encodeFile);
		}
		
		model.addAttribute("employeeDtoModel", employeeDto);
		model.addAttribute("examinationDtosModel", examinationDtos);
		
		
		return "/employee/info";
	}
	
	@PostMapping("/employee/info/{employeeId}")
	private String addPhoto(@PathVariable("employeeId") Integer id, @RequestParam("file") MultipartFile file) throws IOException {
		
		Employee employee = employeeService.getOneEmployee(id);
		employee.getEmployeeInfo().setImageName(file.getOriginalFilename());
		employeeService.saveEmployee(employee);
		
		CustomFileUtils.createImage("employee_" + id, file);
		
		return"redirect:/employee/info/" + id;
	}
	
	
	@GetMapping("/employee/add")
	public String addEmployee(Model model) {
		
		model.addAttribute("employeeDtoRegistrationModel", new EmployeeDtoRegistration());
		
		return "employee/add";
	}
	
	@PostMapping("/employee/add")
	public String confirmEmployeeAdd(@ModelAttribute("employeeDtoRegistrationModel") EmployeeDtoRegistration registrationDto) {
		
		Employee employee = new Employee();
		
		employee = dtoRegistrationToEmployee(registrationDto);
		employeeService.saveEmployee(employee);
		
		return "redirect:/employee";
	}
	
	@GetMapping("/employee/info/update/{employeeId}")
	public String showUpdateEmployee(@PathVariable("employeeId") Integer id, Model model) {
		
		EmployeeDto employeeDto = EmployeeMapper.EmployeeForDto(employeeService.getOneEmployee(id));
		
		model.addAttribute("employeeDtoModel", employeeDto);
		
		System.out.println(employeeDto.getEmployeeInfo());
		
		return "employee/update";
	}
	
	@PostMapping("/employee/info/update")
	public String updateEmployee(@ModelAttribute("employeeDtoModel") EmployeeDto dto ) {
		
		employeeService.saveEmployee(EmployeeMapper.dtoToEmployee(dto));
		
		return "redirect:/";
	}
	
	
	@GetMapping("/employee/delete/{employeeId}")
	public String deleteEmployee(@PathVariable("employeeId") Integer id) {
		
		employeeService.deleteEmployeeWithId(id);
		
		return "redirect:/employee";
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
	
	@GetMapping("/patient/delete/{patientId}")
	public String deletePatient(@PathVariable("patientId") Integer id) {
		
		patientService.deletePatientWithId(id);
		
		return "redirect:/patient";
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
		
		insuranceCompanyService.deleteCompanyWithId(id);
		
		return "redirect:/company";
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
		
		model.addAttribute("priceModel", price);
		model.addAttribute("notesModel", admissionsJournal.getNotes());
		model.addAttribute("patientIdModel" , id);
		model.addAttribute("examinationsDtoModel", dtos);
		
		return "/examination/show";
	}
	
	@GetMapping("/journal/examination/create/{patientId}")
	public String showCreateExamination(@PathVariable("patientId")Integer id ,Model model) {
		
		List<Employee> employees = employeeService.findAllEmployee();
		
		model.addAttribute("examinationCreationDtoModel", new ExaminationCreationDto());
		model.addAttribute("employeesModel", employees);
		model.addAttribute("idModel", id);
		
		return "examination/create";
	}
	
	@PostMapping("/journal/examination/create")
	public String confirmCreateExamination(@RequestParam("patientId") Integer id,@ModelAttribute("examinationCreationDtoModel") ExaminationCreationDto creationDto) {
		
		Patient patient = patientService.getOnePatient(id);
		
		Examination examination = ExaminationMapper.CreationDtoToExamination(creationDto, patient);
		
		examinationService.saveExamination(examination);
		
		return "redirect:/journal";
	}
	
	@GetMapping("/journal/examination/info/{examinationId}")
	public String showExaminationInfo(@PathVariable("examinationId") Integer id, Model model) {
		
		ExaminationDto dto = ExaminationMapper.examinationToDto(examinationService.getOneExamination(id));
		
		model.addAttribute("examinationDtoModel", dto);
		
		return "examination/info";
	}
	
	@GetMapping("/journal/examination/delete/{patientId}/{examinationId}")
	public String deleteExamination(@PathVariable("examinationId") Integer examId ,@PathVariable("patientId") Integer patientId) {
		
		examinationService.deleteExaminationWithId(examId);
		
		//переробити редірект 
		return "redirect:/journal";
	}
}
