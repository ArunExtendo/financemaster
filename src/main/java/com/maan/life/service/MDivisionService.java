package com.maan.life.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.maan.life.bean.MDivision;

public interface MDivisionService {

	List<MDivision> getAll();

	void saveorupdate(MDivision request);

	Page<MDivision> findAll(Pageable paging);

	Page<MDivision> findSearch(String search, Pageable paging);

	Page<MDivision> findByDivnCompCode(String string, Pageable paging);

}
