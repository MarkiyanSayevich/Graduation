package com.home.controller;

import static com.home.mapper.EmployeeMapper.dtoRegistrationToEmployee;

import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

import com.home.dto.EmployeeDto;
import com.home.dto.EmployeeDtoRegistration;
import com.home.dto.EmployeeEditDto;
import com.home.dto.ExaminationDto;
import com.home.entity.Employee;
import com.home.filter.SimpleFilter;
import com.home.mapper.EmployeeMapper;
import com.home.mapper.ExaminationMapper;
import com.home.service.AdmissionJournalService;
import com.home.service.EmployeeService;
import com.home.service.ExaminationService;
import com.home.service.InsuranceCompanyService;
import com.home.service.PatientService;
import com.home.service.utils.CustomFileUtils;

@Controller
public class EmployeeController {

	private EmployeeService employeeService;
	private PatientService patientService;
	private InsuranceCompanyService insuranceCompanyService;
	private AdmissionJournalService admissionJournalService;
	private ExaminationService examinationService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService, PatientService patientService,
			InsuranceCompanyService insuranceCompanyService, AdmissionJournalService admissionJournalService,
			ExaminationService examinationService) {
		this.employeeService = employeeService;
		this.patientService = patientService;
		this.insuranceCompanyService = insuranceCompanyService;
		this.admissionJournalService = admissionJournalService;
		this.examinationService = examinationService;
	}
	
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
	public String addPhoto(@PathVariable("employeeId") Integer id, @RequestParam("file") MultipartFile file) throws IOException {
		
		Employee employee = employeeService.getOneEmployee(id);
		employee.getEmployeeInfo().setImageName(file.getOriginalFilename());
		employeeService.saveEmployee(employee);
		
		CustomFileUtils.createImage("employee_" + id, file);
		
		return"redirect:/employee/info/" + id;
	}
	
	@GetMapping("/employee/edit/{employeeId}")
	public String editEmployee(@PathVariable("employeeId") Integer id , Model model) {
		
		EmployeeEditDto employeeEditDto = EmployeeMapper.employeeToEdit(employeeService.getOneEmployee(id));
		model.addAttribute("employeeDtoModel", employeeEditDto);
		

		return"employee/edit";
	}
	
	@PostMapping("/employee/edit")
	public String editConfirm(@ModelAttribute("employeeDtoModel") EmployeeEditDto employeeEditDto) {
		
		Employee employee = EmployeeMapper.editToEmployee(employeeEditDto);
		
		employeeService.saveEmployee(employee);
		
		return "redirect:/employee/info/" + employee.getId();
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
	
	@GetMapping("/employee/info/edit/{employeeId}")
	public String showUpdateEmployee(@PathVariable("employeeId") Integer id, Model model) {
		
		EmployeeDto employeeDto = EmployeeMapper.EmployeeForDto(employeeService.getOneEmployee(id));
		
		model.addAttribute("employeeDtoModel", employeeDto);
		
		System.out.println(employeeDto.getEmployeeInfo());
		
		return "employee/update";
	}
	
	@PostMapping("/employee/info/edit")
	public String updateEmployee(@ModelAttribute("employeeDtoModel") EmployeeDto dto ) {
		
		employeeService.saveEmployee(EmployeeMapper.dtoToEmployee(dto));
		
		return "redirect:/";
	}
	
	
	@GetMapping("/employee/delete/{employeeId}")
	public String deleteEmployee(@PathVariable("employeeId") Integer id) {
		
		employeeService.deleteEmployeeWithId(id);
		
		return "redirect:/employee";
	}
}
