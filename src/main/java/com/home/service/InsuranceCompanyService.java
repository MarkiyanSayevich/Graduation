package com.home.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.home.entity.InsuranceCompany;
import com.home.filter.SimpleFilter;

public interface InsuranceCompanyService {

	void saveInsuranceCompany(InsuranceCompany insuranceCompany);
	
	InsuranceCompany getOneCompany(int id);
	
	List<InsuranceCompany> findAllCompanies();
	
	void deleteCompanyWithId(int id);
	
	Page<InsuranceCompany> companyPage(Pageable pageable);
	
	Page<InsuranceCompany> companyPageFilter(Pageable pageable, SimpleFilter filter);
}
