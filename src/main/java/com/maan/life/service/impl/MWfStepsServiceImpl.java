package com.maan.life.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maan.life.bean.MWfSteps;
import com.maan.life.dto.ListViewParam;
import com.maan.life.repository.MWfStepsRepository;
import com.maan.life.service.MWfStepsService;
import com.maan.life.util.Convention;
import com.maan.life.util.ValidationUtil;

@Service
@Transactional
public class MWfStepsServiceImpl implements MWfStepsService {

	@Autowired
	private MWfStepsRepository repository;

	@Autowired
	private Convention sorting;

	@Override
	public void saveorupdate(MWfSteps obj) {
		repository.saveAndFlush(obj);
	}

	public Page<MWfSteps> findAllWfStepsDetails(ListViewParam request) {

		Pageable paging = sorting.getPaging(sorting.getPageNumber(request.getPageNumber()),
				sorting.getPageSize(request.getPageSize()));
		Page<MWfSteps> list = null;

		if (!ValidationUtil.isNull(request.getSearch())) {
			String sear = "%" + request.getSearch() + "%";

			list = repository.findAll(sear, paging);
		} else {
			list = repository.findAll(paging);
		}
		return list;
	}
	
	public Optional<MWfSteps> findById(ListViewParam request){
		return repository.findByWsWorkStepCodeAndWsWfCode(request.getCode()[0],request.getCode()[1]);
	}

}
