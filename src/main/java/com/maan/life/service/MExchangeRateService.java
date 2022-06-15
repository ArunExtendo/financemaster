package com.maan.life.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.maan.life.bean.MExchangeRate;

public interface MExchangeRateService {

	void saveorupdate(MExchangeRate object);

	List<MExchangeRate> getAll();

	Page<MExchangeRate> findAll(Pageable paging);

	Page<MExchangeRate> findSearch(String search, Pageable paging);

}
