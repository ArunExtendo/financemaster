
package com.maan.life.service.impl;

import com.maan.life.bean.MBank;
import com.maan.life.bean.MBankAcntDtl;
import com.maan.life.dto.ListViewParam;
import com.maan.life.repository.MBankAccountRepository;
import com.maan.life.repository.MBankRepository;
import com.maan.life.service.MBankService;
import com.maan.life.util.Convention;
import com.maan.life.util.ValidationUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MBankServiceImpl implements MBankService {

	@Autowired
	private MBankRepository repository;

	@Autowired
	private MBankAccountRepository  accountRepo;
	@Autowired
	private Convention sorting;

	private Logger log = LogManager.getLogger(MBankServiceImpl.class);


	@Override
	public void saveorupdate(MBank obj) {

		repository.saveAndFlush(obj);

	}

	@Override
	public Page<MBank> getAll(ListViewParam request) {
		
		Pageable paging = sorting.getPaging(sorting.getPageNumber(request.getPageNumber()),
				sorting.getPageSize(request.getPageSize()));
		
		Page<MBank> list = null;
		if (!ValidationUtil.isNull(request.getSearch())) {
			String sear = "%" + request.getSearch() + "%";
			list = repository.findAll(sear, paging);
		} else {
			list = repository.findAll(paging);
		}
		return list;
	}

	@Override
	public Page<MBankAcntDtl> getBankAccountList(ListViewParam request) {
		Pageable paging = sorting.getPaging(sorting.getPageNumber(request.getPageNumber()),
				sorting.getPageSize(request.getPageSize()));

		Page<MBankAcntDtl> list = null;
		if (!ValidationUtil.isNull(request.getSearch())) {
			String sear = "%" + request.getSearch() + "%";
			list = accountRepo.findAll(sear, paging);
		} else {
			list = accountRepo.findAll(paging);
		}
		return list;
	}

	@Override
	public void createOrUpdateAccount(MBankAcntDtl request) {
		accountRepo.saveAndFlush(request);
	}
}
