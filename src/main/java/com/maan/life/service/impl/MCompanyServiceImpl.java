
package com.maan.life.service.impl;

import com.maan.life.bean.MCompany;
import com.maan.life.dto.ListViewParam;
import com.maan.life.dto.MCompanyDto;
import com.maan.life.dto.Option;
import com.maan.life.repository.MCompanyRepository;
import com.maan.life.service.MCompanyService;
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
public class MCompanyServiceImpl implements MCompanyService {

	@Autowired
	private MCompanyRepository repository;
	@Autowired
	private Convention sorting;

	private Logger log = LogManager.getLogger(MCompanyServiceImpl.class);

	@Override
	public List<Option> getList() {

		return repository.getList();
	}

	@Override
	public void saveorupdate(MCompany obj) {

		repository.saveAndFlush(obj);

	}

	@Override
	public Map<String, Object> findAllCompanyDetails(ListViewParam request) {
		Map<String, Object> response = new HashMap<>();
		List<MCompanyDto> responseList = new ArrayList<MCompanyDto>();
		try{
			Pageable paging = sorting.getPaging(sorting.getPageNumber(request.getPageNumber()),
					sorting.getPageSize(request.getPageSize()));

			Page<MCompanyDto> pagingList = null;
			String sear =  request.getSearch() != null ? request.getSearch() : "" ;
			pagingList = repository.findAllBySearch("%" + sear + "%", paging);

			if(pagingList!=null){
				responseList = pagingList.getContent();
				response.put("currentPage", pagingList.getNumber());
				response.put("totalItems", pagingList.getTotalElements());
				response.put("totalPages", pagingList.getTotalPages());
			}
			response.put("data", responseList);
		}catch (Exception e ){
			log.error("Error in findAllCompanyDetails : " , e);
			throw e;
		}

		return response;
	}


	@Override
	public Optional<MCompany> findById(String code) {
		return repository.findById(code);
	}
}
