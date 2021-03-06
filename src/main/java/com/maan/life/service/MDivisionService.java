package com.maan.life.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.maan.life.dto.Option;
import org.springframework.data.domain.Page;

import com.maan.life.bean.MDivision;
import com.maan.life.dto.ListViewParam;

public interface MDivisionService {

	List<Option> getList(String code);

	void saveorupdate(MDivision request);

	Map<String, Object> findAllDivisionDetails(ListViewParam request);

    Optional<MDivision> findById(String comp,String divn);
}
