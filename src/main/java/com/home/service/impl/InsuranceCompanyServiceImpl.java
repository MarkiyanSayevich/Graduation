package com.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.entity.InsuranceCompany;
import com.home.repository.InsuranceCompanyRepository;
import com.home.service.InsuranceCompanyService;

@Service
public class InsuranceCompanyServiceImpl implements InsuranceCompanyService {

	@Autowired InsuranceCompanyRepository insuranceCompanyRepos;
	
	@Override
	public void saveInsuranceCompany(InsuranceCompany insuranceCompany) {
		insuranceCompanyRepos.save(insuranceCompany);
	}

	@Override
	public InsuranceCompany getOneCompany(int id) {
		return insuranceCompanyRepos.getOne(id);
	}

	@Override
	public List<InsuranceCompany> findAllCompanies() {
		return insuranceCompanyRepos.findAll();
	}

}
