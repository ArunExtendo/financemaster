package com.maan.life.repository;


import java.util.Optional;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.maan.life.bean.MTranDocNo;
import com.maan.life.dto.MTranDocNoDto;

@Repository
public interface MTranDocNoRepository
		extends JpaRepository<MTranDocNo, String>, JpaSpecificationExecutor<MTranDocNo> {

	Optional<MTranDocNo> findByTdnCodeAndTdnCompCodeAndTdnDocTypeAndTdnYear(String tdnCode, String tdnCompCode,
			String tdnDocType, Double db);

	@Query(value = "select tdn_doc_type as tdnDocType, tdn_comp_code as tdnCompCode,tdn_code as tdnCode,tdn_year as tdnYear,"
			+ "tdn_first_no as tdnFirstNo,tdn_last_no as tdnLastNo,tdn_curr_no as tdnCurrNo,tdn_divn_code as tdnDivnCode,"
			+ "tdn_dept_code as tdnDeptCode from M_TRAN_DOC_NO", nativeQuery = true)
	Page<MTranDocNoDto> findByAll(Pageable paging);

	@Query(value = "select tdn_doc_type as tdnDocType, tdn_comp_code as tdnCompCode,tdn_code as tdnCode,tdn_year as tdnYear,"
			+ "tdn_first_no as tdnFirstNo,tdn_last_no as tdnLastNo,tdn_curr_no as tdnCurrNo,tdn_divn_code as tdnDivnCode,"
			+ "tdn_dept_code as tdnDeptCode from M_TRAN_DOC_NO where upper(TDN_CODE || TDN_DOC_TYPE || TDN_COMP_CODE || TDN_YEAR ) like Upper(:search)", nativeQuery = true)
	Page<MTranDocNoDto> findBySearch(@Param("search")String string, Pageable paging);




}
