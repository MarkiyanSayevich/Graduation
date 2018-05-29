package com.home.service;

import java.util.List;

import com.home.entity.InsuranceCompany;

public interface InsuranceCompanyService {

	void saveInsuranceCompany(InsuranceCompany insuranceCompany);
	
	InsuranceCompany getOneCompany(int id);
	
	List<InsuranceCompany> findAllCompanies();
	
}
