package com.maan.life.repository;

import com.maan.life.dto.MDivisionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.maan.life.bean.MDivision;
import com.maan.life.bean.MDivisionId;

@Repository
public interface MDivisionRepository
		extends JpaRepository<MDivision, MDivisionId>, JpaSpecificationExecutor<MDivision> {

//	@Query(value = "select d.DIVN_CODE as divnCode, d.DIVN_NAME as divnName,c1.CURR_NAME as divnBaseCurrCode1," +
//			" c2.CURR_NAME as divnBaseCurrCode2,c3.CURR_NAME as divnBaseCurrCode3, " +
//			" d.DIVN_ROUND_OFF as divnRoundOff, d.DIVN_UNIT_NAME as divnUnitName " +
//			" from M_DIVISION d LEFT JOIN M_CURRENCY c1 ON d.DIVN_BASE_CURR_CODE_1 = c1.CURR_CODE " +
//			" LEFT JOIN M_CURRENCY c2 ON d.DIVN_BASE_CURR_CODE_2 = c2.CURR_CODE " +
//			" LEFT JOIN M_CURRENCY c3 ON d.DIVN_BASE_CURR_CODE_3 = c3.CURR_CODE " +
//			" where upper( d.DIVN_CODE || d.DIVN_NAME || c1.CURR_NAME || c2.CURR_NAME || c3.CURR_NAME  " +
//			" || d.DIVN_UNIT_NAME  || d.DIVN_ROUND_OFF )  " +
//			" like upper(:search) ", nativeQuery = true)
//	Page<MDivisionDto> findAll(@Param("search") String search, Pageable paging);
//
//
//	@Query(value = "select d.DIVN_CODE as divnCode, d.DIVN_NAME as divnName,c1.CURR_NAME as divnBaseCurrCode1," +
//			" c2.CURR_NAME as divnBaseCurrCode2,c3.CURR_NAME as divnBaseCurrCode3, " +
//			" d.DIVN_ROUND_OFF as divnRoundOff, d.DIVN_UNIT_NAME as divnUnitName " +
//			" from M_DIVISION d LEFT JOIN M_CURRENCY c1 ON d.DIVN_BASE_CURR_CODE_1 = c1.CURR_CODE " +
//			" LEFT JOIN M_CURRENCY c2 ON d.DIVN_BASE_CURR_CODE_2 = c2.CURR_CODE " +
//			" LEFT JOIN M_CURRENCY c3 ON d.DIVN_BASE_CURR_CODE_3 = c3.CURR_CODE " +
//			" where upper( d.DIVN_CODE || d.DIVN_NAME || c1.CURR_NAME || c2.CURR_NAME || c3.CURR_NAME  " +
//			" || d.DIVN_UNIT_NAME  || d.DIVN_ROUND_OFF )  " +
//			" like upper(:search) AND DIVN_COMP_CODE = :code", nativeQuery = true)
//	Page<MDivisionDto> findBySearchAndDivnCompCode(@Param("search") String search, @Param("code") String code, Pageable paging);


	@Query(value = "select d.divnCode as divnCode, d.divnName as divnName,d.divnBaseCurrCode1 as divnBaseCurrCode1," +
			" d.divnBaseCurrCode2 as divnBaseCurrCode2,d.divnBaseCurrCode3 as divnBaseCurrCode3, " +
			" d.divnRoundOff as divnRoundOff, d.divnUnitName as divnUnitName " +
			" from MDivision d " +
			" where upper( d.divnCode || d.divnName || d.divnBaseCurrCode1" +
			" || d.divnBaseCurrCode2 || d.divnBaseCurrCode3  " +
			" || d.divnUnitName  || d.divnRoundOff )  " +
			" like upper(:search) " )
	Page<MDivisionDto> findAll(@Param("search") String search, Pageable paging);


	@Query(value =  "select d.divnCode as divnCode, d.divnName as divnName,d.divnBaseCurrCode1 as divnBaseCurrCode1," +
			" d.divnBaseCurrCode2 as divnBaseCurrCode2,d.divnBaseCurrCode3 as divnBaseCurrCode3, " +
			" d.divnRoundOff as divnRoundOff, d.divnUnitName as divnUnitName " +
			" from MDivision d   " +
			" where upper( d.divnCode || d.divnName || d.divnBaseCurrCode1" +
			" || d.divnBaseCurrCode2 || d.divnBaseCurrCode3  " +
			" || d.divnUnitName  || d.divnRoundOff )  " +
			" like upper(:search) AND d.divnCompCode = :code" )
	Page<MDivisionDto> findBySearchAndDivnCompCode(@Param("search") String search, @Param("code") String code, Pageable paging);


}