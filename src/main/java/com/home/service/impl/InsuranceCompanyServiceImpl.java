package com.home.service.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.home.entity.InsuranceCompany;
import com.home.filter.SimpleFilter;
import com.home.repository.InsuranceCompanyRepository;
import com.home.service.InsuranceCompanyService;

@Service
public class InsuranceCompanyServiceImpl implements InsuranceCompanyService {


	@Autowired InsuranceCompanyRepository insuranceCompanyRepos;
	
	@Override
	public void deleteCompanyWithId(int id) {
		insuranceCompanyRepos.deleteById(id);
	}
	
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
	
	@Override
	public Page<InsuranceCompany> companyPage(Pageable pageable) {
		return insuranceCompanyRepos.findAll(pageable);
	}

	@Override
	public Page<InsuranceCompany> companyPageFilter(Pageable pageable , SimpleFilter filter) {
		return insuranceCompanyRepos.findAll(getSpecification(filter), pageable);
	}
	
	public Specification<InsuranceCompany> getSpecification(SimpleFilter filter){
		return new Specification<InsuranceCompany>() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<InsuranceCompany> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				if(filter.getName().isEmpty()) {
					return null;
				}else return criteriaBuilder.like(root.get("name"), "%" + filter.getName()+"%");
			}
		};
	}


}
