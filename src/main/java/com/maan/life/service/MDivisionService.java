package com.maan.life.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.maan.life.bean.MDivision;
import com.maan.life.dto.ListViewParam;

public interface MDivisionService {

	List<MDivision> getAll();

	void saveorupdate(MDivision request);

	Map<String, Object> findAllDivisionDetails(ListViewParam request);
	

}
