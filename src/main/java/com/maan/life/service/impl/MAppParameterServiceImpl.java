
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

import com.maan.life.bean.MAppParameter;
import com.maan.life.repository.MAppParameterRepository;
import com.maan.life.service.MAppParameterService;

@Service
@Transactional
public class MAppParameterServiceImpl implements MAppParameterService {

	@Autowired
	private MAppParameterRepository repository;

	private Logger log = LogManager.getLogger(MAppParameterServiceImpl.class);

	@Override
	public List<MAppParameter> getAll() {
		List<MAppParameter> lst;

		try {
			lst = repository.findAll();

		} catch (Exception ex) {
			log.error("Error in findAll" +ex);
			return Collections.emptyList();
		}
		return lst;
	}

	@Override
	public void saveorupdate(@Valid MAppParameter request) {
		repository.saveAndFlush(request);

	}

	@Override
	public Page<MAppParameter> findAll(Pageable paging) {

		return repository.findAll(paging);
	}

	@Override
	public Page<MAppParameter> findSearch(String search, Pageable paging) {

		String sear = "%" + search + "%";

		return repository.findAll(sear, paging);
	}
}
