package com.maan.life.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.maan.life.bean.MAppCodes;
import com.maan.life.dto.ListViewParam;

public interface MAppCodesService {

	List<MAppCodes> getAll();

	void saveorupdate(MAppCodes request);

	Page<MAppCodes> findAll(Pageable paging);

	Page<MAppCodes> findSearch(String search, Pageable paging);

	Optional<MAppCodes> findById(ListViewParam request);

}
