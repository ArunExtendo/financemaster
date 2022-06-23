package com.maan.life.repository;

import com.maan.life.dto.Option;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.maan.life.bean.MDivision;
import com.maan.life.bean.MDivisionId;

import java.util.List;

@Repository
public interface MDivisionRepository
		extends JpaRepository<MDivision, MDivisionId>, JpaSpecificationExecutor<MDivision> {

	@Query(value = "select * from M_DIVISION where upper(concat(divn_code,divn_comp_code)) like upper(:search)", nativeQuery = true)
	Page<MDivision> findAll(@Param("search") String search, Pageable paging);

	@Query(value = "select * from M_DIVISION where upper(concat(divn_code,divn_comp_code)) like upper(:search) and divn_comp_code = :code", nativeQuery = true)
	//Page<MDivision> findBySearchAndDivnCompCode(String string, Pageable paging);
	Page<MDivision> findBySearchAndDivnCompCode(@Param("search") String search, @Param("code") String code,Pageable paging);

	@Query(value = "select new com.maan.life.dto.Option(c.divnCode,c.divnCompCode,c.divnName) from MDivision c where c.divnCompCode = :compCode" )
	List<Option> getList(String compCode);
}