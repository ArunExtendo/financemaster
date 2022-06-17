
package com.maan.life.service.impl;

import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maan.life.bean.MAppParameter;
import com.maan.life.dto.ListViewParam;
import com.maan.life.repository.MAppParameterRepository;
import com.maan.life.service.MAppParameterService;
import com.maan.life.util.Convention;
import com.maan.life.util.ValidationUtil;

@Service
@Transactional
public class MAppParameterServiceImpl implements MAppParameterService {

	@Autowired
	private MAppParameterRepository repository;
	@Autowired
	private Convention sorting;

	private Logger log = LogManager.getLogger(MAppParameterServiceImpl.class);

	@Override
	public List<MAppParameter> getAll() {
		List<MAppParameter> lst;
		try {
			lst = repository.findAll();

		} catch (Exception ex) {
			log.error("Error in findAll" + ex);
			return Collections.emptyList();
		}
		return lst;
	}

	@Override
	public void saveorupdate(MAppParameter request) {
		repository.saveAndFlush(request);

	}

	public Page<MAppParameter> findAllAppParameterDetails(ListViewParam request) {

		Pageable paging = sorting.getPaging(sorting.getPageNumber(request.getPageNumber()),
				sorting.getPageSize(request.getPageSize()));
		
		Page<MAppParameter> list = null;
		if (!ValidationUtil.isNull(request.getSearch())) {
			String sear = "%" + request.getSearch() + "%";
			list = repository.findAll(sear, paging);
		} else {
			list = repository.findAll(paging);
		}
		return list;

	}

}
