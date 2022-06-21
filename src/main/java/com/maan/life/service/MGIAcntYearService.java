package com.maan.life.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;

import com.maan.life.bean.MGlAcntYear;
import com.maan.life.dto.ListViewParam;
import com.maan.life.dto.MGlAcntYearDto;

public interface MGIAcntYearService {

	void saveorupdate(@Valid MGlAcntYear request);

	List<MGlAcntYearDto> getAll();

	Page<MGlAcntYear> findAllMGlAcntYear(ListViewParam request);

}
