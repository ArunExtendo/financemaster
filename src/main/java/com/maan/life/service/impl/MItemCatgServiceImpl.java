package com.maan.life.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maan.life.bean.MItemCatg;
import com.maan.life.dto.ListViewParam;
import com.maan.life.dto.MGlAcntYearDto;
import com.maan.life.repository.MItemCatgRepository;
import com.maan.life.service.MItemCatgService;
import com.maan.life.util.Convention;
import com.maan.life.util.ValidationUtil;

@Service
@Transactional
public class MItemCatgServiceImpl implements MItemCatgService {
	
	@Autowired
	private MItemCatgRepository repository;
	@Autowired
	private Convention sorting;

	@Override
	public void saveorupdate(@Valid MItemCatg request) {
		repository.saveAndFlush(request);
		
	}

	@Override
	public Optional<MItemCatg> findByCodes(String icCode, String icCompCode) {
		return repository.findByIcCodeAndIcCompCode(icCode,icCompCode);
	}

	@Override
	public Map<String, Object> findAll(ListViewParam request) {
		Map<String, Object> response = new HashMap<>();
		List<MItemCatg> responseList = new ArrayList<MItemCatg>();
		Page<MItemCatg> pagingList =  null;
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
