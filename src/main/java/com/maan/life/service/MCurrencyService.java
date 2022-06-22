package com.maan.life.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import com.maan.life.dto.ListViewParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.maan.life.bean.MCurrency;
import com.maan.life.dto.MCurrencyDto;
import com.maan.life.dto.Option;


public interface MCurrencyService {

	void saveorupdate(@Valid MCurrency request);

	List<Option> getList();

	Optional<MCurrency> findById(String string);

	Map<String, Object> findAll(ListViewParam paging);


	

	
	
	
	

}
