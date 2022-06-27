/*
*  Copyright (c) 2019. All right reserved
* Created on 2022-05-02 ( Date ISO 2022-05-02 - Time 15:42:12 )
* Generated by Telosys Tools Generator ( version 3.3.0 )
*/
package com.maan.life.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maan.life.bean.MGlAccountComp;
import com.maan.life.dto.ListViewParam;
import com.maan.life.repository.MGlAccountCompRepository;
import com.maan.life.service.MGlAccountCompService;
import com.maan.life.util.Convention;
import com.maan.life.util.ValidationUtil;

/**
 * <h2>MGlAccountCompServiceImpl</h2>
 */
@Service
@Transactional
public class MGlAccountCompServiceImpl implements MGlAccountCompService {

	@Autowired
	private MGlAccountCompRepository repository;

	@Autowired
	private Convention sorting;

	@Override
	public void saveorupdate(MGlAccountComp obj) {
		repository.saveAndFlush(obj);
	}

	public Page<MGlAccountComp> findAllMGlAccountCompDetails(ListViewParam request) {

		Pageable paging = sorting.getPaging(sorting.getPageNumber(request.getPageNumber()),
				sorting.getPageSize(request.getPageSize()));
		Page<MGlAccountComp> list = null;

		if (!ValidationUtil.isNull(request.getSearch())) {
			String sear = "%" + request.getSearch() + "%";

			list = repository.findAll(sear, paging);
		} else {
			list = repository.findAll(paging);
		}
		return list;
	}

	@Override
	public Optional<MGlAccountComp> findById(String currCode) {

		return repository.findById(currCode);

	}

}
