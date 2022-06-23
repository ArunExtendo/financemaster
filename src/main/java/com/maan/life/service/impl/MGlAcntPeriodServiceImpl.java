package com.maan.life.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.NumberUtils;

import com.maan.life.bean.MGlAcntPeriod;
import com.maan.life.dto.ListViewParam;
import com.maan.life.dto.MGIAccountPeriodDto;
import com.maan.life.dto.MGlAcntYearDto;
import com.maan.life.repository.MGlAcntPeriodRepository;
import com.maan.life.service.MGlAcntPeriodService;
import com.maan.life.util.Convention;
import com.maan.life.util.ValidationUtil;

@Service
@Transactional
public class MGlAcntPeriodServiceImpl implements MGlAcntPeriodService {
	
	private Logger log = LogManager.getLogger(MGlAcntPeriodServiceImpl.class);
	
	@Autowired
	private MGlAcntPeriodRepository mGlAcntPeriodRepository;
	
	@Autowired
	private Convention sorting;

	@Override
	public void saveorupdate(@Valid MGlAcntPeriod request) {
		mGlAcntPeriodRepository.saveAndFlush(request);

	}
	
	@Override
	public Map<String, Object> findAll(ListViewParam request) {

		Map<String, Object> response = new HashMap<>();
		List<MGIAccountPeriodDto> responseList = new ArrayList<MGIAccountPeriodDto>();
		Page<MGIAccountPeriodDto> pagingList =  null;
		Pageable paging = sorting.getPaging(sorting.getPageNumber(request.getPageNumber()),
				sorting.getPageSize(request.getPageSize()));

		if (ValidationUtil.isNull(request.getSearch())) {

			pagingList = mGlAcntPeriodRepository.findByAll(paging);

		}else  {
			pagingList = mGlAcntPeriodRepository.findBySearch( "%" + request.getSearch() +"%", paging);
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

	@Override
	public Optional<MGlAcntPeriod> findById(String apCompCode, String apAcntYear,
			String apCalYear, String apCalMonth) {
		BigDecimal apAcntYearbd = new BigDecimal(apAcntYear);
		BigDecimal apCalYearbd = new BigDecimal(apCalYear);
		BigDecimal apCalMonthbd = new BigDecimal(apCalMonth);

		
		return mGlAcntPeriodRepository.findByApCompCodeAndApAcntYearAndApCalYearAndApCalMonth(apCompCode,apAcntYearbd,apCalYearbd,apCalMonthbd);
	}

}
