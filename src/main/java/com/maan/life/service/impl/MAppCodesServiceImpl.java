
package com.maan.life.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maan.life.bean.MAppCodes;
import com.maan.life.dto.ListViewParam;
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
			log.error("Error in findAll" +ex);
			return Collections.emptyList();
		}
		return lst;
	}

	@Override
	public void saveorupdate(MAppCodes request) {
		repository.saveAndFlush(request);
	}

	@Override
	public Page<MAppCodes> findSearch(String search, Pageable paging) {
		String sear = "%" + search + "%";
		return repository.findAll(sear, paging);
	}

	@Override
	public Page<MAppCodes> findAll(Pageable paging) {
		return repository.findAll(paging);
	}
	
	@Override
	public Optional<MAppCodes> findById(ListViewParam request){
		return repository.findAcTypeAndAcCode(request.getCode()[0],request.getCode()[1]);
		
	}

}
