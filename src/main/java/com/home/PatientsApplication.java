package com.home;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import com.home.entity.Employee;
import com.home.entity.EmployeeInfo;
import com.home.repository.EmployeeRepository;

@SpringBootApplication
public class PatientsApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(PatientsApplication.class);
	}
	
	public static void main(String[] args) {
			ConfigurableApplicationContext ctx = SpringApplication.run(PatientsApplication.class, args);
			addAdmin(ctx);
	}
	
	private static void addAdmin(ConfigurableApplicationContext ctx) {
		EmployeeRepository employeeRepos = ctx.getBean(EmployeeRepository.class);
		long count = employeeRepos.count();
		
		if(count == 0) {
			Employee employee = new Employee();
			employee.setFullName("Василів Андрій Михайлович");
			employee.setEmail("vasiliv@gmail.com");
			employee.setPhoneNumber("+380675435612");
			employee.setCabinet("каб. 34");
			employee.setScientificRank("Магістр");
			employee.setPosition("Головний лікар");
			employee.setRegistrationDate(LocalDate.now());
			employee.setTheRightToWorkWithDatabase(true);
			employee.setEmployeeInfo(new EmployeeInfo());
			employee.getEmployeeInfo().setLogin("administrator");
			employee.getEmployeeInfo().setPassword("1111");
			employeeRepos.save(employee);
		}
		
	}
}


