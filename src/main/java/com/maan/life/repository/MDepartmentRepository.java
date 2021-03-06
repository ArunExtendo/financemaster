/*
 * Java domain class for entity "MDepartment" 
 * Created on 2022-05-02 ( Date ISO 2022-05-02 - Time 15:42:11 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
* Created on 2022-05-02 ( 15:42:11 )
* Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
*/

package com.maan.life.repository;

import java.util.List;
import java.util.Optional;


import com.maan.life.dto.Option;
import com.maan.life.dto.MDepartmentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maan.life.bean.MDepartment;
import com.maan.life.bean.MDepartmentId;

/**
 * <h2>MDepartmentRepository</h2>
 *
 * createdAt : 2022-05-02 - Time 15:42:11
 * <p>
 * Description: "MDepartment" Repository
 */

public interface MDepartmentRepository
		extends JpaRepository<MDepartment, MDepartmentId>, JpaSpecificationExecutor<MDepartment> {

	@Query(value = "select   d.deptCode as deptCode,   d.deptName as deptName" +
			" from MDepartment d where upper(deptCode || deptName) like upper(:search)")
	Page<MDepartmentDto> findAll(String search, Pageable paging);

	Optional<MDepartment> findByDeptCode(String deptCode);

	@Query(value = "select  d.deptCode as deptCode,  d.deptName as deptName" +
			" from MDepartment  d where upper(  deptCode || deptName ) " +
			" like upper(:search) and deptCompCode = :deptCompCode " +
			"and deptDivnCode =:deptDivnCode ")
	Page<MDepartmentDto> findByDeptCompCodeAndDeptDivnCode(@Param("search") String search,@Param("deptCompCode") String deptCompCode, @Param("deptDivnCode") String deptDivnCode, Pageable paging);


	@Query(value = "select new com.maan.life.dto.Option(c.deptCode,c.deptDivnCode,c.deptCompCode,c.deptName) from MDepartment c where c.deptDivnCode =:divnCode and c.deptCompCode = :compCode" )
	List<Option> getList(String compCode,String divnCode);

}
