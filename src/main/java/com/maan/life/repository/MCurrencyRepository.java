package com.maan.life.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maan.life.bean.MCurrency;

public interface MCurrencyRepository extends JpaRepository<MCurrency, String>, JpaSpecificationExecutor<MCurrency> {

	@Query(value = "select * from M_CURRENCY where upper (CURR_CODE || CURR_NAME || CURR_BL_NAME || CURR_SHORT_NAME || CURR_UNIT_NAME) like upper(:search)", nativeQuery = true)
	Page<MCurrency> findAll(@Param("search") String search, Pageable paging);

	Page<MCurrency> findByCurrCode(String string, Pageable paging);


}