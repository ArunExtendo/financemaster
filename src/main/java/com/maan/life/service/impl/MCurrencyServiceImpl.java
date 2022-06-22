package com.maan.life.service.impl;

import java.util.*;

import javax.validation.Valid;

import com.maan.life.dto.ListViewParam;
import com.maan.life.util.Convention;
import com.maan.life.util.ValidationUtil;
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

	@Autowired
	private Convention sorting;
	
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
	public Map<String, Object> findAll(ListViewParam request) {

		Map<String, Object> response = new HashMap<>();
		List<MCurrencyDto> responseList = new ArrayList<MCurrencyDto>();
		Page<MCurrencyDto> pagingList =  null;
		Pageable paging = sorting.getPaging(sorting.getPageNumber(request.getPageNumber()),
				sorting.getPageSize(request.getPageSize()));

		if (ValidationUtil.isNull(request.getSearch())) {

			pagingList = repository.findByAll(paging);

		}else  {
			pagingList = repository.findBySearch( "%" + request.getSearch() +"%", paging);
		}
		if(pagingList!=null){
			responseList = pagingList.getContent();
			response.put("currentPage", pagingList.getNumber());
			response.put("totalItems", pagingList.getTotalElements());
			response.put("totalPages", pagingList.getTotalPages());
		}

		response.put("data", responseList);
		return response;
	}

}
