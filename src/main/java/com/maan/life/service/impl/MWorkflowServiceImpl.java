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

import com.maan.life.bean.MWorkflow;
import com.maan.life.dto.ListViewParam;
import com.maan.life.repository.MWorkflowRepository;
import com.maan.life.service.MWorkflowService;
import com.maan.life.util.Convention;
import com.maan.life.util.ValidationUtil;

@Service
@Transactional
public class MWorkflowServiceImpl implements MWorkflowService {

	@Autowired
	private MWorkflowRepository repository;

	@Autowired
	private Convention sorting;

	private Logger log = LogManager.getLogger(MWorkflowServiceImpl.class);

	@Override
	public List<MWorkflow> getAll() {
		List<MWorkflow> list = null;
		try {
			list = repository.findAll();
		} catch (Exception ex) {
			log.error("Error in getAll" + ex);
			return Collections.emptyList();
		}
		return list;
	}

	@Override
	public void saveorupdate(MWorkflow obj) {
		repository.saveAndFlush(obj);
	}
	
	@Override
	public Optional<MWorkflow> findById(String wfCode) {
		
		return repository.findById(wfCode);

		
	}

	public Page<MWorkflow> findAllWorkflowDetails(ListViewParam request) {

		Pageable paging = sorting.getPaging(sorting.getPageNumber(request.getPageNumber()),
				sorting.getPageSize(request.getPageSize()));
		Page<MWorkflow> list = null;

		if (!ValidationUtil.isNull(request.getSearch())) {
			String sear = "%" + request.getSearch() + "%";

			list = repository.findAll(sear, paging);
		} else {
			list = repository.findAll(paging);
		}
		return list;
	}

}
