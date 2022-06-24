package com.maan.life.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.maan.life.bean.MAppCodes;
import com.maan.life.dto.ListViewParam;
import com.maan.life.dto.Option;

public interface MAppCodesService {

	List<MAppCodes> getAll();

	void saveorupdate(MAppCodes request);
	
	Page<MAppCodes> findAllAppCodesDetails(ListViewParam request);

    List<Option> getListOfValues(String code);
    
    Optional<MAppCodes> findById(ListViewParam request);

}
