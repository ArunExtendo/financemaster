package com.maan.life.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;


import com.maan.life.bean.MGlAcntYear;
import com.maan.life.bean.MGlAcntYearId;
import com.maan.life.dto.MGlAcntYearDto;

public interface MGIAcntYearRepository
		extends JpaRepository<MGlAcntYear, MGlAcntYearId>, JpaSpecificationExecutor<MGlAcntYear> {


	
	
	@Query(value = "select c.compName as companyName,y.ayCompCode as tayCompCode,y.ayAcntYear as ayAcntYear,y.ayPrevCurrNext as ayPrevCurrNext,"
			+ "y.ayFmDt as ayFmDt,y.ayToDt as ayToDt,y.ayMainAcntCode as ayMainAcntCode,y.aySubAcntCode as aySubAcntCode,"
			+ "y.ayCloseOption as ayCloseOption,y.ayCrUid as ayCrUid ,y.ayCrDt as ayCrDt ,y.ayUpdUid as ayUpdUid,y.ayUpdDt as ayUpdDt from MCompany c inner join MGlAcntYear y on c.compCode = y.ayCompCode")
	Page<MGlAcntYearDto> findByAll(Pageable paging);

	
	@Query(value = "select c.compName as companyName,y.ayCompCode as tayCompCode,y.ayAcntYear as ayAcntYear,y.ayPrevCurrNext as ayPrevCurrNext,"
			+ "y.ayFmDt as ayFmDt,y.ayToDt as ayToDt,y.ayMainAcntCode as ayMainAcntCode,y.aySubAcntCode as aySubAcntCode,"
			+ "y.ayCloseOption as ayCloseOption,y.ayCrUid as ayCrUid ,y.ayCrDt as ayCrDt ,y.ayUpdUid as ayUpdUid,"
			+ "y.ayUpdDt as ayUpdDt from MCompany c inner join MGlAcntYear y on c.compCode = y.ayCompCode where "
			+ "upper(y.ayFmDt || y.ayToDt || y.ayAcntYear || y.ayCompCode) like upper(:search)")
	Page<MGlAcntYearDto> findBySearch(String search, Pageable paging);


	Optional<MGlAcntYear> findByAyCompCodeAndAyAcntYear(String ayCompCode, BigDecimal bigDecimal);


	


	



}