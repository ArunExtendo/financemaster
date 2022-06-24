package com.maan.life.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.maan.life.bean.MWfRoles;
import com.maan.life.dto.ListViewParam;

public interface MWfRolesService {

	void saveorupdate(MWfRoles object);

	Page<MWfRoles> findAllWfRolesDetails(ListViewParam request);

	Optional<MWfRoles> findById(ListViewParam request);

}
