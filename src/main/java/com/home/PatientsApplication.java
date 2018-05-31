package com.home;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import com.home.entity.AdmissionsJournal;
import com.home.entity.Employee;
import com.home.entity.EmployeeInfo;
import com.home.entity.Examination;
import com.home.entity.InsuranceCompany;
import com.home.entity.Patient;
import com.home.entity.enums.Gender;
import com.home.entity.enums.PatientStatus;
import com.home.repository.AdmissionsJournalRepository;
import com.home.repository.EmployeeRepository;
import com.home.repository.ExaminationRepository;
import com.home.repository.InsuranceCompanyRepository;
import com.home.repository.PatientRepository;

@SpringBootApplication
public class PatientsApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(PatientsApplication.class);
	}
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(PatientsApplication.class, args);
		addCompany(ctx);
		addPatient(ctx);
		addEmployee(ctx);
		addExamination(ctx);
		addAdmissionJournal(ctx);
	}
	
	private static void addCompany(ConfigurableApplicationContext ctx) {
		
		InsuranceCompanyRepository insuranceCompanyRepository = ctx.getBean(InsuranceCompanyRepository.class);
		Long companies = insuranceCompanyRepository.count();
		
		if(companies == 0) {
			InsuranceCompany company = new InsuranceCompany();
			company.setName("MedInsurance");
			company.setAddress("c.Lviv , Ivana Franka streat");
			company.setPostIndex("79685");
			company.setType("InsuranceCompany");
			insuranceCompanyRepository.save(company);
		}
	}
	
	private static void addPatient(ConfigurableApplicationContext ctx) {
		PatientRepository patientRepository = ctx.getBean(PatientRepository.class);
		Long patients = patientRepository.count();
		
		if(patients == 0) {
			Patient patient = new Patient();
			patient.setFullName("Novosad Oleg Petrovich");
			patient.setBirthday(LocalDate.of(1998, 3, 9));
			patient.setGender(Gender.ЧОЛОВІК);
			patient.setAddress("Zalupna street");
			patient.setPhoneNumber("+380975645342");
			patient.setPatientCardNumber("678");
			patient.setPatientStatus(PatientStatus.СТАЦІОНАРНИЙ);
			patient.setDiagnosis("Rak");
			patient.setRegistrationDate(LocalDate.now());
			patientRepository.save(patient);
		}
	}
	
	private static void addAdmissionJournal(ConfigurableApplicationContext ctx) {
		AdmissionsJournalRepository admissionsJournalRepository = ctx.getBean(AdmissionsJournalRepository.class);
		
		Long journals = admissionsJournalRepository.count();
		
		if(journals == 0) {
			AdmissionsJournal admissionsJournal = new AdmissionsJournal();
			
			admissionsJournal.setCreateJourneyTime(LocalDate.now());
			admissionsJournal.setAllPrice(new BigDecimal("20"));
			admissionsJournal.setNotes("Курс лікування.");
			admissionsJournalRepository.save(admissionsJournal);
		}
	}
	
	private static void addExamination(ConfigurableApplicationContext ctx) {
		ExaminationRepository examinationRepository = ctx.getBean(ExaminationRepository.class);
		Long examinations = examinationRepository.count();
		
		if(examinations == 0) {
			
			String[] instruments = {"pincet","klisma"};
			String[] methods = {"clear"};
			
			Examination examination = new Examination();
			examination.setRegistrationDate(LocalDate.now());
			examination.setAge(18);
			examination.setService("klizma");
			examination.setPrice(new BigDecimal("20"));
			examination.setInstruments(instruments);
			examination.setMethods(methods);
			examination.setComplaints("Запор");
			examination.setConclusion("лікування успішне");
			examination.setFactors("No factors");
			examination.setDiagnosis("Здоровий");
			examinationRepository.save(examination);
		}
		
	}
	
	private static void addEmployee(ConfigurableApplicationContext ctx) {
		EmployeeRepository employeeRepository = ctx.getBean(EmployeeRepository.class);
		Long employeers = employeeRepository.count();
		
		if (employeers == 0) {
			Employee employee = new Employee();
			
			String[] wards = {"пал.34","пал.78","пал.56"};
			
			employee.setFullName("Klumko Oleksandr Olegovich");
			employee.setEmail("email@gmail.com");
			employee.setPhoneNumber("+380674958650");
			employee.setCabinet("каб.44");
			employee.setScientificRank("magistr");
			employee.setPosition("Hirurh");
			employee.setDepartment("Hirurhiya");
			employee.setWards(wards);
			employee.setRegistrationDate(LocalDate.now());
			employee.setTheRightToWorkWithDatabase(true);
			employee.setEmployeeInfo(new EmployeeInfo());
			employee.getEmployeeInfo().setLogin("klumko");
			employee.getEmployeeInfo().setPassword("1111");
			employeeRepository.save(employee);
		}
		
	}
}
