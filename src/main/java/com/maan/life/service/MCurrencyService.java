package com.maan.life.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.maan.life.bean.MCurrency;
import com.maan.life.dto.MCurrencyDto;
import com.maan.life.dto.Option;


public interface MCurrencyService {

	void saveorupdate(@Valid MCurrency request);

	List<Option> getList();

	Optional<MCurrency> findById(String string);

	Page<MCurrencyDto> findAll(Pageable paging);

	Page<MCurrencyDto> findBySearch(String search, Pageable paging);

	

	
	
	
	

}
