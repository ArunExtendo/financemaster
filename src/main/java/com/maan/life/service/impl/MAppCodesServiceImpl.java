
package com.maan.life.service.impl;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maan.life.bean.MAppCodes;
import com.maan.life.dto.MAppCodesDto;
import com.maan.life.repository.MAppCodesRepository;
import com.maan.life.service.MAppCodesService;

@Service
@Transactional
public class MAppCodesServiceImpl implements MAppCodesService {

	@Autowired
	private MAppCodesRepository repository;

	private Logger log = LogManager.getLogger(MAppCodesServiceImpl.class);

	@Override
	public List<MAppCodes> getAll() {
		List<MAppCodes> lst;

		try {
			lst = repository.findAll();

		} catch (Exception ex) {
			log.error(ex);
			return Collections.emptyList();
		}
		return lst;
	}


//	@Override
//	public void saveorupdate(MAppCodes object) {
//
//		repository.saveAndFlush(object);
//
//	}


	@Override
	public void saveorupdate(@Valid MAppCodesDto request) {
		repository.save(request);
		
	}
}
