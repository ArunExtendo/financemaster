package com.maan.life.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.maan.life.bean.WCustBankDtl;
import com.maan.life.dto.ListViewParam;

public interface WCustBankDtlService {

	void saveorupdate(WCustBankDtl object);
	
	Page<WCustBankDtl> findAllCustBankDtlDetails(ListViewParam request);
	
	Optional<WCustBankDtl> findById(String string);



}
