package com.maan.life.service;

import com.maan.life.bean.MBank;
import com.maan.life.bean.MBankAcntDtl;
import com.maan.life.dto.ListViewParam;
import org.springframework.data.domain.Page;

public interface MBankService {
	

	void saveorupdate(MBank request);

	Page<MBank> getAll(ListViewParam request);


	Page<MBankAcntDtl> getBankAccountList(ListViewParam request);

	void createOrUpdateAccount(MBankAcntDtl request);
}
