package com.maan.life.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maan.life.bean.MDivision;
import com.maan.life.bean.MDivisionId;

public interface MDivisionRepository
		extends JpaRepository<MDivision, MDivisionId>, JpaSpecificationExecutor<MDivision> {

	@Query(value = "select * from M_DIVISION where upper(concat(divn_code,divn_comp_code)) like upper(:search)", nativeQuery = true)
	Page<MDivision> findAll(@Param("search") String search, Pageable paging);

	Page<MDivision> findByDivnCompCode(String string, Pageable paging);

}
