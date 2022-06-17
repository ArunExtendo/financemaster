package com.maan.life.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;

import com.maan.life.bean.MAppParameter;
import com.maan.life.dto.ListViewParam;

public interface MAppParameterService {

	List<MAppParameter> getAll();

	void saveorupdate(@Valid MAppParameter request);

	Page<MAppParameter> findAllAppParameterDetails(ListViewParam request);
}
