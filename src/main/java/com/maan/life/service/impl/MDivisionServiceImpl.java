package com.maan.life.service.impl;


import com.maan.life.bean.MDivision;
import com.maan.life.bean.MDivisionId;
import com.maan.life.dto.ListViewParam;
import com.maan.life.dto.MDivisionDto;
import com.maan.life.dto.Option;
import com.maan.life.repository.MDivisionRepository;
import com.maan.life.service.MDivisionService;
import com.maan.life.util.Convention;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class MDivisionServiceImpl implements MDivisionService {

	@Autowired
	private MDivisionRepository repository;
	@Autowired
	private Convention sorting;

	private Logger log = LogManager.getLogger(MDivisionServiceImpl.class);

	@Override
	public List<Option> getList(String code) {
		return repository.getList(code);
	}

	@Override
	public void saveorupdate(MDivision request) {
		repository.saveAndFlush(request);
	}
	


	@Override
	public Map<String, Object> findAllDivisionDetails(ListViewParam request) {

		Map<String, Object> response = new HashMap<>();
		List<MDivisionDto> responseList = new ArrayList<MDivisionDto>();
		Page<MDivisionDto> pagingList =  null;
		Pageable paging = sorting.getPaging(sorting.getPageNumber(request.getPageNumber()),
				sorting.getPageSize(request.getPageSize()));
		try{
			if (request.getCode() != null && !(request.getCode().length < 1)) {
				List<String> o = new ArrayList<String>();
				String sear =  request.getSearch() != null ? request.getSearch() : "" ;
				pagingList = repository.findBySearchAndDivnCompCode("%" + sear + "%", request.getCode()[0], paging);
			} else  {
				String sear =  request.getSearch() != null ? request.getSearch() : "" ;
				pagingList = repository.findAll("%" + sear + "%", paging);
			}

			if(pagingList!=null){
				responseList = pagingList.getContent();
				response.put("currentPage", pagingList.getNumber());
				response.put("totalItems", pagingList.getTotalElements());
				response.put("totalPages", pagingList.getTotalPages());
			}
			response.put("data", responseList);
		}catch (Exception e ){
			log.error("Error in findAllDivisionDetails : " , e);
			throw e;
		}
		return response;
	}

	@Override
	public Optional<MDivision> findById(String comp,String divn) {
		MDivisionId id = new MDivisionId(divn,comp);
		return repository.findById(id);
	}


}
