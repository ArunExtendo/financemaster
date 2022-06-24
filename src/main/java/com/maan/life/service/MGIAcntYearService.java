package com.maan.life.service;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import com.maan.life.bean.MGlAcntYear;
import com.maan.life.dto.ListViewParam;

public interface MGIAcntYearService {

	void saveorupdate(@Valid MGlAcntYear request);

	Map<String, Object> findAll(ListViewParam request);

	Optional<MGlAcntYear> findByAyCompCodeAndAyAcntYear(String string, String string2);

	

	
	
	

}