package com.maan.life.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.maan.life.bean.MWfSteps;
import com.maan.life.dto.ListViewParam;

public interface MWfStepsService {

	void saveorupdate(MWfSteps object);
	
	Page<MWfSteps> findAllWfStepsDetails(ListViewParam request);

	Optional<MWfSteps> findById(ListViewParam request);

}
