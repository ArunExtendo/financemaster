package com.maan.life.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.maan.life.bean.MCustApplComp;
import com.maan.life.dto.ListViewParam;

public interface MCustApplCompService {

	void saveorupdate(MCustApplComp object);

	List<MCustApplComp> getAll();
	
	Page<MCustApplComp> findAllCustApplCompDetails(ListViewParam request);

	Optional<MCustApplComp> findById(ListViewParam request);
}
