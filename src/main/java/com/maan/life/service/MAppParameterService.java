package com.maan.life.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.maan.life.bean.MAppParameter;

public interface MAppParameterService {

	List<MAppParameter> getAll();

	void saveorupdate(@Valid MAppParameter request);

	Page<MAppParameter> findSearch(String search, Pageable paging);

	Page<MAppParameter> findAll(Pageable paging);
}
