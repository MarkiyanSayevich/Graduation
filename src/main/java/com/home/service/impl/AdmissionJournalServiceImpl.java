package com.home.service.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.home.entity.AdmissionsJournal;
import com.home.filter.SimpleFilter;
import com.home.repository.AdmissionsJournalRepository;
import com.home.service.AdmissionJournalService;

@Service
public class AdmissionJournalServiceImpl implements AdmissionJournalService {

	@Autowired
	AdmissionsJournalRepository admissionJournalRepos;

	@Override
	public void deleteJournalWithId(int id) {
		admissionJournalRepos.deleteById(id);
	}

	@Override
	public void saveAdmJournal(AdmissionsJournal admissionsJournal) {
		admissionJournalRepos.save(admissionsJournal);
	}

	@Override
	public AdmissionsJournal getOneById(int id) {
		return admissionJournalRepos.getOne(id);
	}

	@Override
	public List<AdmissionsJournal> findAllJournals() {
		return admissionJournalRepos.findAll();
	}

	@Override
	public Page<AdmissionsJournal> pageAdmissionJournal(Pageable pageable) {
		return admissionJournalRepos.findAll(pageable);
	}

	@Override
	public Page<AdmissionsJournal> pageFilterAdmissionJournal(Pageable pageable, SimpleFilter filter) {
		return admissionJournalRepos.findAll(getSpecification(filter) , pageable);
	}

	private static Specification<AdmissionsJournal> getSpecification(SimpleFilter filter) {
		return new Specification<AdmissionsJournal>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<AdmissionsJournal> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				if (filter.getName().isEmpty()) {
					return null;
				} else return criteriaBuilder.like(root.get("patient.fullName"), "%" + filter.getName() + "%");
			}
		};
	}
}
