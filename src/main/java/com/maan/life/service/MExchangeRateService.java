package com.maan.life.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.maan.life.bean.MExchangeRate;
import com.maan.life.dto.ListViewParam;

public interface MExchangeRateService {

	void saveorupdate(MExchangeRate object);

	List<MExchangeRate> getAll();
	
	Page<MExchangeRate> findAllMExchangeRate(ListViewParam request);

}
