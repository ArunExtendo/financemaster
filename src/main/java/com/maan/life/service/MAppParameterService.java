package com.maan.life.service;

import java.util.List;

import com.maan.life.dto.LOVRequest;
import com.maan.life.dto.Option;
import org.springframework.data.domain.Page;

import com.maan.life.bean.MAppParameter;
import com.maan.life.dto.ListViewParam;

public interface MAppParameterService {

	List<MAppParameter> getAll();

	public void saveorupdate(MAppParameter request);

	Page<MAppParameter> findAllAppParameterDetails(ListViewParam request);

    List<Option> getListOfValues(LOVRequest request);
}
