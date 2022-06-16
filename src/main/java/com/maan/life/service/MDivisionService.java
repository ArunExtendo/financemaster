package com.maan.life.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.maan.life.bean.MDivision;
import com.maan.life.dto.ListViewParam;

public interface MDivisionService {

	List<MDivision> getAll();

	void saveorupdate(MDivision request);

	Page<MDivision> findAllDivisionDetails(ListViewParam request);
	

}
