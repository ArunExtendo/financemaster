package com.maan.life.service.impl;

import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maan.life.bean.MDivision;
import com.maan.life.repository.MDivisionRepository;
import com.maan.life.service.MDivisionService;

@Service
@Transactional
public class MDivisionServiceImpl implements MDivisionService {

	@Autowired
	private MDivisionRepository repository;

	private Logger log = LogManager.getLogger(MDivisionServiceImpl.class);

	@Override
	public List<MDivision> getAll() {
		List<MDivision> lst;
		try {
			lst = repository.findAll();

		} catch (Exception ex) {
			log.error("Error in findAll"+ex);
			return Collections.emptyList();
		}
		return lst;
	}

	@Override
	public void saveorupdate(MDivision request) {
		repository.saveAndFlush(request);
	}

	@Override
	public Page<MDivision> findSearch(String search, Pageable paging) {
		String sear = "%" + search + "%";
		return repository.findAll(sear, paging);
	}

	@Override
	public Page<MDivision> findAll(Pageable paging) {
		return repository.findAll(paging);
	}
	
	@Override
	public Page<MDivision> findByDivnCompCode(String string, Pageable paging){
		return repository.findByDivnCompCode(string,paging);
	}
	

}
