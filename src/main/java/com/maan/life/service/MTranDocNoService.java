package com.maan.life.service;

import java.util.Map;
import java.util.Optional;

import com.maan.life.bean.MTranDocNo;
import com.maan.life.dto.ListViewParam;

public interface MTranDocNoService {

	void saveorupdate(MTranDocNo request);

	Optional<MTranDocNo> findByCodes(String string, String string2, String string3, String string4);

	Map<String, Object> findAll(ListViewParam request);








}
