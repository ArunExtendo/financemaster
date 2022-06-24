package com.maan.life.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.maan.life.dto.Option;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.maan.life.bean.MCurrency;
import com.maan.life.bean.MGlAcntYear;
import com.maan.life.dto.ListViewParam;
import com.maan.life.dto.MCurrencyDto;
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
	public Map<String, Object> findAll(ListViewParam request) {

		Map<String, Object> response = new HashMap<>();
		List<MGlAcntYearDto> responseList = new ArrayList<MGlAcntYearDto>();
		Page<MGlAcntYearDto> pagingList =  null;
		Pageable paging = sorting.getPaging(sorting.getPageNumber(request.getPageNumber()),
				sorting.getPageSize(request.getPageSize()));

		if (ValidationUtil.isNull(request.getSearch())) {

			pagingList = mGIAcntYearRepository.findByAll(paging);

		}else  {
			pagingList = mGIAcntYearRepository.findBySearch( "%" + request.getSearch() +"%", paging);
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
	public Optional<MGlAcntYear> findByAyCompCodeAndAyAcntYear(String ayCompCode, String ayAcntYear) {
		BigDecimal bigDecimal = new BigDecimal(ayAcntYear);
		return mGIAcntYearRepository.findByAyCompCodeAndAyAcntYear(ayCompCode,bigDecimal);
	}


	@Override
	public List<Option> getList() {
		return mGIAcntYearRepository.getList();
	}

}