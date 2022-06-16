/*
*  Copyright (c) 2019. All right reserved
* Created on 2022-05-02 ( Date ISO 2022-05-02 - Time 15:42:11 )
* Generated by Telosys Tools Generator ( version 3.3.0 )
*/
package com.maan.life.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.maan.life.bean.MDepartment;
import com.maan.life.dto.ListViewParam;

/**
 * <h2>MDepartmentServiceimpl</h2>
 */
public interface MDepartmentService {

	void saveorupdate(MDepartment d);

	List<MDepartment> getAll();

	Optional<MDepartment> findByDeptCode(String deptCode);

	Page<MDepartment> findByDeptCompCodeAndDeptDivnCode(String depotCompCode, String deptDivnCode, Pageable paging);

	Page<MDepartment> findAllDepartmentDetails(ListViewParam request);

}
