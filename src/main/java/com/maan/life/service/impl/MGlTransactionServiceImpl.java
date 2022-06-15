package com.maan.life.service.impl;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maan.life.bean.MGlTransaction;
import com.maan.life.repository.MGlTransactionRepository;
import com.maan.life.service.MGlTransactionService;

@Service
@Transactional
public class MGlTransactionServiceImpl implements MGlTransactionService {
	
	@Autowired
	private MGlTransactionRepository repository;

	private Logger log = LogManager.getLogger(MGlTransactionServiceImpl.class);

	@Override
	public void saveorupdate(@Valid MGlTransaction request) {
		repository.saveAndFlush(request);
		
	}
	
	@Override
	public List<MGlTransaction> getAll() {
		List<MGlTransaction> lst;
		try {
			lst = repository.findAll();

		} catch (Exception ex) {
			log.error("Error in findAll" +ex);
			return Collections.emptyList();
		}
		return lst;
	}
	

	@Override
	public Page<MGlTransaction> findAll(Pageable paging) {
		return repository.findAll(paging);
	}
	
//	@Override
//	public Page<MGlTransaction> findSearch(String search, Pageable paging) {
//		String sear = "%" + search + "%";
//		return repository.findAll(sear, paging);
//	}
	

}
