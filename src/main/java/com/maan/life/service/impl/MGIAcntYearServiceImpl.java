package com.maan.life.service.impl;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.maan.life.bean.MGlAcntYear;
import com.maan.life.dto.ListViewParam;
import com.maan.life.dto.MGlAcntYearDto;
import com.maan.life.repository.MGIAcntYearRepository;
import com.maan.life.service.MGIAcntYearService;
import com.maan.life.util.Convention;
import com.maan.life.util.ValidationUtil;

@Service
@Transactional
public class MGIAcntYearServiceImpl implements MGIAcntYearService {

	private Logger log = LogManager.getLogger(MGIAcntYearServiceImpl.class);

	@Autowired
	private MGIAcntYearRepository mGIAcntYearRepository;
	
	@Autowired
	private Convention sorting;

	@Override
	public void saveorupdate(@Valid MGlAcntYear request) {
		mGIAcntYearRepository.saveAndFlush(request);

	}
	
	@Override
	public List<MGlAcntYearDto> getAll() {
		List<MGlAcntYearDto> list;
		try {
			list = mGIAcntYearRepository.findALL();

		} catch (Exception ex) {
			log.error("Error in findAll" +ex);
			return Collections.emptyList();
		}
		return list;
	}

	
	public Page<MGlAcntYear> findAllMGlAcntYear(ListViewParam request) {

		Pageable paging = sorting.getPaging(sorting.getPageNumber(request.getPageNumber()),
				sorting.getPageSize(request.getPageSize()));
		Page<MGlAcntYear> list = null;

		if (!ValidationUtil.isNull(request.getSearch())) {
			String sear = "%" + request.getSearch() + "%";

			list = mGIAcntYearRepository.findAll(sear, paging);
		} else {
			list = mGIAcntYearRepository.findAll(paging);
		}
		return list;
	}
}
