/*
*  Copyright (c) 2019. All right reserved
* Created on 2022-05-02 ( Date ISO 2022-05-02 - Time 15:42:11 )
* Generated by Telosys Tools Generator ( version 3.3.0 )
*/
package com.maan.life.service.impl;

import java.util.*;

import com.maan.life.dto.MDepartmentDto;
import com.maan.life.dto.MDivisionDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maan.life.bean.MDepartment;
import com.maan.life.dto.ListViewParam;
import com.maan.life.repository.MDepartmentRepository;
import com.maan.life.service.MDepartmentService;
import com.maan.life.util.Convention;
import com.maan.life.util.ValidationUtil;

/**
 * <h2>MDepartmentServiceimpl</h2>
 */
@Service
@Transactional
public class MDepartmentServiceImpl implements MDepartmentService {

	@Autowired
	private MDepartmentRepository repository;

	@Autowired
	private Convention sorting;

	private Logger log = LogManager.getLogger(MDepartmentServiceImpl.class);

	@Override
	public void saveorupdate(MDepartment obj) {
		repository.saveAndFlush(obj);
	}

	@Override
	public List<MDepartment> getAll() {
		List<MDepartment> list = null;
		try {
			list = repository.findAll();
		} catch (Exception ex) {
			log.error("Error in getAll" + ex);
			return Collections.emptyList();
		}
		return list;
	}

	public Optional<MDepartment> findByDeptCode(String deptCode) {
		return repository.findByDeptCode(deptCode);
	}




	@Override
	public Map<String, Object> findAllDepartmentDetails(ListViewParam request) {

		Map<String, Object> response = new HashMap<>();
		List<MDepartmentDto> responseList = new ArrayList<MDepartmentDto>();
		Page<MDepartmentDto> pagingList =  null;
		try{
			Pageable paging = sorting.getPaging(sorting.getPageNumber(request.getPageNumber()),
					sorting.getPageSize(request.getPageSize()));

			if (request.getCode() != null && request.getCode().length != 0) {
				List<String> o = new ArrayList<String>();
				String sear =  request.getSearch() != null ? request.getSearch() : "" ;
				for (String ob : request.getCode()) {
					o.add(ob);
				}
				pagingList = repository.findByDeptCompCodeAndDeptDivnCode("%" + sear + "%", o.get(0), o.get(1), paging);

			} else {
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
			log.error("Error in findAllDepartmentDetails : " , e);
			throw e;
		}
		return response;
	}
}