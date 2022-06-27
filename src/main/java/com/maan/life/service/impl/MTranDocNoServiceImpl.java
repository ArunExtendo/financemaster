package com.maan.life.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maan.life.bean.MTranDocNo;
import com.maan.life.dto.ListViewParam;
import com.maan.life.dto.MTranDocNoDto;
import com.maan.life.repository.MTranDocNoRepository;
import com.maan.life.service.MTranDocNoService;
import com.maan.life.util.Convention;
import com.maan.life.util.ValidationUtil;

@Service
@Transactional
public class MTranDocNoServiceImpl implements MTranDocNoService {

	@Autowired
	private MTranDocNoRepository repository;

	@Autowired
	private Convention sorting;

	private Logger log = LogManager.getLogger(MTranDocNoServiceImpl.class);

	@Override
	public void saveorupdate(MTranDocNo request) {
		repository.saveAndFlush(request);

	}

	@Override
	public Optional<MTranDocNo> findByTdnCodeAndTdnCompCode(String tdnCode, String tdnCompCode, String tdnDocType,
			String tdnYear) {
		Double db = Double.parseDouble(tdnYear);
		return repository.findByTdnCodeAndTdnCompCodeAndTdnDocTypeAndTdnYear(tdnCode, tdnCompCode, tdnDocType, db);
	}

	@Override
	public Map<String, Object> findAll(ListViewParam request) {

		Map<String, Object> response = new HashMap<>();
		List<MTranDocNoDto> responseList = new ArrayList<MTranDocNoDto>();
		Page<MTranDocNoDto> pagingList =  null;
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
