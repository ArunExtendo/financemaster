package com.maan.life.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.maan.life.bean.MCurrency;
import com.maan.life.dto.ListViewParam;
import com.maan.life.dto.Option;

public interface MCurrencyService {
	
	List<Option> getAll();

	void saveorupdate(MCurrency request);

	Page<MCurrency> findAllCurrencyDetails(ListViewParam request);
	

}
