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

import com.maan.life.bean.MCurrency;
import com.maan.life.repository.MCurrencyRepository;
import com.maan.life.service.MCurrencyService;


@Service
@Transactional
public class MCurrencyServiceImpl implements MCurrencyService {

	@Autowired
	private MCurrencyRepository repository;
	
	private Logger log = LogManager.getLogger(MCurrencyServiceImpl.class);
	
	@Override
	public List<MCurrency> getAll() {
		List<MCurrency> lst;
		try {
			lst = repository.findAll();

		} catch (Exception ex) {
			log.error("Error in findAll" +ex);
			return Collections.emptyList();
		}
		return lst;
	}

	@Override
	public void saveorupdate(MCurrency request) {
		repository.saveAndFlush(request);
	}

	@Override
	public Page<MCurrency> findSearch(String search, Pageable paging) {
    	String sear = "%" + search + "%";
		return repository.findAll(sear, paging);
		
	}

	@Override
	public Page<MCurrency> findAll(Pageable paging) {
		return repository.findAll(paging);
	}

	@Override
	public Page<MCurrency> findByCurrCode(String string, Pageable paging) {
		
		return repository.findByCurrCode(string,paging);
	}
}
