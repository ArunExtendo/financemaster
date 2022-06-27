package com.maan.life.service;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import com.maan.life.bean.MItemCatg;
import com.maan.life.dto.ListViewParam;

public interface MItemCatgService {

	void saveorupdate(@Valid MItemCatg request);

	Optional<MItemCatg> findByCodes(String string, String string2);

	Map<String, Object> findAll(ListViewParam request);

}
