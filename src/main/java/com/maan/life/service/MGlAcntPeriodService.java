package com.maan.life.service;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import com.maan.life.bean.MGlAcntPeriod;
import com.maan.life.dto.ListViewParam;

public interface MGlAcntPeriodService {

	void saveorupdate(@Valid MGlAcntPeriod request);


	Map<String, Object> findAll(ListViewParam request);


	Optional<MGlAcntPeriod> findById(String string, String string2,
			String string3, String string4);

}
