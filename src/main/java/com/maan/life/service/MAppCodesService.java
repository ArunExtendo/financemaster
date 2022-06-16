package com.maan.life.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.maan.life.bean.MAppCodes;
import com.maan.life.dto.ListViewParam;

public interface MAppCodesService {

	List<MAppCodes> getAll();

	void saveorupdate(MAppCodes request);
	
	Page<MAppCodes> findAllAppCodesDetails(ListViewParam request);


}
