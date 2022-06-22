package com.maan.life.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maan.life.bean.MCompany;
import com.maan.life.bean.MCurrency;
import com.maan.life.dto.MCurrencyDto;
import com.maan.life.dto.Option;
import com.maan.life.repository.MCurrencyRepository;
import com.maan.life.service.MCurrencyService;

@Service
@Transactional
public class MCurrencyServiceImpl implements MCurrencyService {

	@Autowired
	private MCurrencyRepository repository;
	
	private Logger log = LogManager.getLogger(MCurrencyServiceImpl.class);

	@Override
	public void saveorupdate(@Valid MCurrency request) {

		repository.saveAndFlush(request);

	}

	@Override
	public List<Option> getList() {

		return repository.getList();

	}

	@Override
	public Optional<MCurrency> findById(String currCode) {
		
		return repository.findById(currCode);

		
	}

	@Override
	public Page<MCurrencyDto> findBySearch(String search, Pageable paging) {

		String sear = "%" + search + "%";

		return repository.findBySearch(sear, paging);
	}

	@Override
	public Page<MCurrencyDto> findAll(Pageable paging) {

		return repository.findByAll(paging);
	}

}
