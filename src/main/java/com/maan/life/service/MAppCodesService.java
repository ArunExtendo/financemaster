package com.maan.life.service;

import java.util.List;
import java.util.Optional;

import com.maan.life.dto.Option;
import org.springframework.data.domain.Page;

import com.maan.life.bean.MAppCodes;
import com.maan.life.dto.ListViewParam;

public interface MAppCodesService {

	List<MAppCodes> getAll();

	void saveorupdate(MAppCodes request);
	
	Page<MAppCodes> findAllAppCodesDetails(ListViewParam request);

	Page<MAppCodes> findAll(Pageable paging);

	Page<MAppCodes> findSearch(String search, Pageable paging);
  
  List<Option> getListOfValues(String code);
  
  Optional<MAppCodes> findById(ListViewParam request);

}
