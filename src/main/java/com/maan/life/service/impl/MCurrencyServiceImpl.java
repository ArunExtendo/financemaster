package com.maan.life.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maan.life.bean.MCurrency;
import com.maan.life.dto.ListViewParam;
import com.maan.life.dto.Option;
import com.maan.life.repository.MCurrencyRepository;
import com.maan.life.service.MCurrencyService;
import com.maan.life.util.Convention;
import com.maan.life.util.ValidationUtil;


@Service
@Transactional
public class MCurrencyServiceImpl implements MCurrencyService {

	@Autowired
	private MCurrencyRepository repository;
	@Autowired
	private Convention sorting;
	
	private Logger log = LogManager.getLogger(MCurrencyServiceImpl.class);
	
	public List<Option> getAll() {
		List<Option> list = new ArrayList<Option>();
		Option responseObj = null;
		for (MCurrency mCurr : repository.findAll()) {
			responseObj = new Option(mCurr, toString());
			responseObj.setCode(mCurr.getCurrCode());
			responseObj.setValue(mCurr.getCurrName());
			list.add(responseObj);
		}
		return list;
	}

	@Override
	public void saveorupdate(MCurrency request) {
		repository.saveAndFlush(request);
	}
	
	@Override
	public Page<MCurrency> findAllCurrencyDetails(ListViewParam request) {

		Pageable paging = sorting.getPaging(sorting.getPageNumber(request.getPageNumber()),
				sorting.getPageSize(request.getPageSize()));
		Page<MCurrency> list = null;

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
			list = repository.findByCurrCode(o.get(0), paging);
		}

		return list;

	}

}
