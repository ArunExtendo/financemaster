package com.maan.life.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.maan.life.bean.MWfStepsApplRoles;
import com.maan.life.dto.ListViewParam;

public interface MWfStepsApplRolesService {

	void saveorupdate(MWfStepsApplRoles object);

	List<MWfStepsApplRoles> getAll();

	Page<MWfStepsApplRoles> findAllWfStepsApplRolesDetails(ListViewParam request);

	Optional<MWfStepsApplRoles> findById(ListViewParam request);

}
