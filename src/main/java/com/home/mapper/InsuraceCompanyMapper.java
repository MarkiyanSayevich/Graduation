package com.home.mapper;

import java.util.ArrayList;
import java.util.List;

import com.home.dto.InsuranceCompanyDto;
import com.home.dto.InsuranceCompanyDtoRegistration;
import com.home.entity.InsuranceCompany;

public interface InsuraceCompanyMapper {

	public static InsuranceCompanyDto companyToDto(InsuranceCompany company) {
		
		InsuranceCompanyDto companyDto = new InsuranceCompanyDto();
		
		companyDto.setId(company.getId());
		companyDto.setName(company.getName());
		companyDto.setAddress(company.getAddress());
		companyDto.setPostIndex(company.getPostIndex());
		companyDto.setType(company.getType());
		companyDto.setPatients(company.getPatients());
		
		return companyDto;
	}
	
	public static List<InsuranceCompanyDto> listCompanyToDto(List<InsuranceCompany> companies){
		
		List<InsuranceCompanyDto> companyDtos = new ArrayList<>();
		
		for(int i = 0;i <companies.size();i++) {
			
			InsuranceCompanyDto companyDto = new InsuranceCompanyDto();
			companyDto.setId(companies.get(i).getId());
			companyDto.setName(companies.get(i).getName());
			companyDto.setAddress(companies.get(i).getAddress());
			companyDto.setPostIndex(companies.get(i).getPostIndex());
			companyDto.setType(companies.get(i).getType());
			companyDto.setPatients(companies.get(i).getPatients());
			companyDtos.add(companyDto);
		}
		
		return companyDtos;
	}
	
	public static InsuranceCompany dtoRegistrationToCompany(InsuranceCompanyDtoRegistration companyDtoRegistration) {
		
		InsuranceCompany company = new InsuranceCompany();
		
		company.setName(companyDtoRegistration.getName());
		company.setAddress(companyDtoRegistration.getAddress());
		company.setPostIndex(companyDtoRegistration.getPostIndex());
		company.setType(companyDtoRegistration.getType());
		
		return company;
	}
}
