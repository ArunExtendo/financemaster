/*
*  Copyright (c) 2019. All right reserved
* Created on 2022-05-02 ( Date ISO 2022-05-02 - Time 15:42:12 )
* Generated by Telosys Tools Generator ( version 3.3.0 )
*/
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

import com.maan.life.bean.MExchangeRate;
import com.maan.life.repository.MExchangeRateRepository;
import com.maan.life.service.MExchangeRateService;

/**
 * <h2>MExchangeRateServiceimpl</h2>
 */
@Service
@Transactional
public class MExchangeRateServiceImpl implements MExchangeRateService {

	@Autowired
	private MExchangeRateRepository repository;

	private Logger log = LogManager.getLogger(MExchangeRateServiceImpl.class);

	/*
	 * public MExchangeRateServiceImpl(MExchangeRateRepository repo) {
	 * this.repository = repo; }
	 * 
	 * 
	 */

	@Override
	public List<MExchangeRate> getAll() {
		List<MExchangeRate> list = null;
		try {
			list = repository.findAll();
		} catch (Exception ex) {
			log.error("Error in getAll" + ex);
			return Collections.emptyList();
		}
		return list;
	}

	@Override
	public void saveorupdate(MExchangeRate obj) {
		repository.saveAndFlush(obj);
	}

	@Override
	public Page<MExchangeRate> findAll(Pageable paging) {
		return repository.findAll(paging);
	}

	public Page<MExchangeRate> findSearch(String search, Pageable paging) {

		String sear = "%" + search + "%";

		return repository.findAll(sear, paging);
	}
}
