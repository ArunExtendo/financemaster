package com.maan.life.service;

import java.util.List;

import javax.validation.Valid;

import com.maan.life.bean.MAppCodes;
import com.maan.life.dto.MAppCodesDto;

public interface MAppCodesService {

	//void saveorupdate(MAppCodes object);

	List<MAppCodes> getAll();

	void saveorupdate(@Valid MAppCodesDto request);
}
