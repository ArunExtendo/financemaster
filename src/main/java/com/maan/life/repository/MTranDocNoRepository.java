package com.maan.life.repository;


import java.util.Optional;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.maan.life.bean.MTranDocNo;
import com.maan.life.dto.MTranDocNoDto;

@Repository
public interface MTranDocNoRepository
		extends JpaRepository<MTranDocNo, String>, JpaSpecificationExecutor<MTranDocNo> {

	Optional<MTranDocNo> findByTdnCodeAndTdnCompCodeAndTdnDocTypeAndTdnYear(String tdnCode, String tdnCompCode,
			String tdnDocType, Double db);

	@Query(value = "select a.tdnDocType as tdnDocType, a.tdnCompCode as tdnCompCode,a.tdnCode as tdnCode,a.tdnYear as tdnYear,"
			+ "a.tdnFirstNo as tdnFirstNo,a.tdnLastNo as tdnLastNo,a.tdnCurrNo as tdnCurrNo,a.tdnDivnCode as tdnDivnCode,"
			+ "a.tdnDeptCode as tdnDeptCode from MTranDocNo a")
	Page<MTranDocNoDto> findByAll(Pageable paging);

	@Query(value = "select a.tdnDocType as tdnDocType, a.tdnCompCode as tdnCompCode,a.tdnCode as tdnCode,a.tdnYear as tdnYear,"
			+ "a.tdnFirstNo as tdnFirstNo,a.tdnLastNo as tdnLastNo,a.tdnCurrNo as tdnCurrNo,a.tdnDivnCode as tdnDivnCode,"
			+ "a.tdnDeptCode as tdnDeptCode from MTranDocNo a where upper(a.tdnCode || a.tdnDocType || a.tdnCompCode || a.tdnYear ) like Upper(:search)")
	Page<MTranDocNoDto> findBySearch(String search, Pageable paging);




}
