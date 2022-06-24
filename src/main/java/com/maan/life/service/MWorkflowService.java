package com.maan.life.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.maan.life.bean.MWorkflow;
import com.maan.life.dto.ListViewParam;

public interface MWorkflowService {

	void saveorupdate(MWorkflow object);

	List<MWorkflow> getAll();

	Page<MWorkflow> findAllWorkflowDetails(ListViewParam request);

	Optional<MWorkflow> findById(String wfCode);

}
