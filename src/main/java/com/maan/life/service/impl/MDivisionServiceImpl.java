package com.maan.life.service.impl;

import java.util.ArrayList;
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
import com.maan.life.dto.ListViewParam;
import com.maan.life.repository.MDivisionRepository;
import com.maan.life.service.MDivisionService;
import com.maan.life.util.Convention;
import com.maan.life.util.ValidationUtil;

@Service
@Transactional
public class MDivisionServiceImpl implements MDivisionService {

	@Autowired
	private MDivisionRepository repository;
	@Autowired
	private Convention sorting;

	private Logger log = LogManager.getLogger(MDivisionServiceImpl.class);

	@Override
	public List<MDivision> getAll() {
		List<MDivision> lst;

		try {
			lst = repository.findAll();

		} catch (Exception ex) {
			log.error("Error in findAll" +ex);
			return Collections.emptyList();
		}
		return lst;
	}

	@Override
	public void saveorupdate(MDivision request) {
		repository.saveAndFlush(request);
	}
	
	@Override
	public Page<MDivision> findAllDivisionDetails(ListViewParam request) {

		Pageable paging = sorting.getPaging(sorting.getPageNumber(request.getPageNumber()),
				sorting.getPageSize(request.getPageSize()));
		Page<MDivision> list = null;

		if (ValidationUtil.isNull(request.getSearch())) {

			list = repository.findAll(paging);

		} else {
			String sear = "%" + request.getSearch() + "%";

			list = repository.findAll(sear, paging);
		}
		
		if (request.getCode() != null) {
			List<String> o = new ArrayList<String>();
			for (String ob : request.getCode()) {
				o.add(ob);
			}
			list = repository.findByDivnCompCode(o.get(0), paging);
		}

		return list;

	}


}
