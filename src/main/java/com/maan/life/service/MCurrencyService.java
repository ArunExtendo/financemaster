package com.maan.life.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.maan.life.bean.MCurrency;

public interface MCurrencyService {
	
	List<MCurrency> getAll();

	void saveorupdate(MCurrency request);

	Page<MCurrency> findAll(Pageable paging);

	Page<MCurrency> findSearch(String search, Pageable paging);

	Page<MCurrency> findByCurrCode(String string, Pageable paging);
	

}
