package com.maan.life.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.maan.life.bean.MAppCodes;

public interface MAppCodesService {

	List<MAppCodes> getAll();

	void saveorupdate(MAppCodes request);

	Page<MAppCodes> findAll(Pageable paging);

	Page<MAppCodes> findSearch(String search, Pageable paging);

}
