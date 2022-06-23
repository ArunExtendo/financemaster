package com.maan.life.service.impl;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maan.life.bean.MGlTransaction;
import com.maan.life.repository.MGlTransactionRepository;
import com.maan.life.service.AccountGroupService;

@Service
@Transactional
public class AccountGroupServiceImpl implements AccountGroupService {
	
	@Autowired
	private MGlTransactionRepository repository;

	private Logger log = LogManager.getLogger(AccountGroupServiceImpl.class);

	@Override
	public void saveorupdate(@Valid MGlTransaction request) {
		repository.saveAndFlush(request);
		
	}
	
	@Override
	public List<MGlTransaction> getAll() {
		List<MGlTransaction> lst;
		try {
			lst = repository.findAll();

		} catch (Exception ex) {
			log.error("Error in findAll" +ex);
			return Collections.emptyList();
		}
		return lst;
	}
	

//	@Override
//	public Page<MDivision> findAllDivisionDetails(ListViewParam request) {
//
//		Pageable paging = sorting.getPaging(sorting.getPageNumber(request.getPageNumber()),
//				sorting.getPageSize(request.getPageSize()));
//		Page<MDivision> list = null;
//
//		if (request.getCode() != null && request.getCode().length != 0) {
//			List<String> o = new ArrayList<String>();
//			String sear = null;
//			if (request.getSearch() == null) {
//				sear = "%%";
//			} else {
//				sear = "%" + request.getSearch() + "%";
//			}
//			for (String ob : request.getCode()) {
//				o.add(ob);
//			}
//			list = repository.findBySearchAndDivnCompCode(sear, o.get(0), paging);
//
//		} else if (!ValidationUtil.isNull(request.getSearch())) {
//			String sear = "%" + request.getSearch() + "%";
//			list = repository.findAll(sear, paging);
//		} else {
//			list = repository.findAll(paging);
//		}
//
//		return list;
//
//	}
//	

	

}
