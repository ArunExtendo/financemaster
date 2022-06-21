package com.maan.life.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maan.life.bean.MGlAcntYear;
import com.maan.life.bean.MGlAcntYearId;
import com.maan.life.dto.MGlAcntYearDto;

public interface MGIAcntYearRepository extends JpaRepository<MGlAcntYear, MGlAcntYearId>, JpaSpecificationExecutor<MGlAcntYear> {


	
	@Query(value = "select * from M_GL_ACNT_YEAR where upper(AY_FM_DT || AY_TO_DT || AY_ACNT_YEAR || AY_COMP_CODE) like upper(:search)", nativeQuery = true)
	Page<MGlAcntYear> findAll(@Param("search") String search, Pageable paging);
	
	
	
	
   @Query(value="select c.compName as companyName,y.ayCompCode as ayCompCode,y.ayAcntYear as ayAcntYear,y.ayPrevCurrNext as ayPrevCurrNext,"
   		+ "y.ayFmDt as ayFmDt,y.ayToDt as ayToDt ,y.ayMainAcntCode as ayMainAcntCode,y.aySubAcntCode as aySubAcntCode,y.ayCloseOption as ayCloseOption,"
   		+ "y.ayCrUid as ayCrUid,y.ayCrDt as ayCrDt,y.ayUpdUid as ayUpdUid,y.ayUpdDt as ayUpdDt from MCompany c inner join MGlAcntYear y on c.compCode = y.ayCompCode ")
	 List<MGlAcntYearDto> findALL();
	
	
//  @Query(value="select c.COMP_NAME,y.AY_COMP_CODE,y.AY_ACNT_YEAR,y.AY_PREV_CURR_NEXT,y.AY_FM_DT,y.AY_TO_DT,y.AY_MAIN_ACNT_CODE,y.AY_SUB_ACNT_CODE,"
//  		+ "y.AY_CLOSE_OPTION,y.AY_CR_UID,y.AY_CR_DT,y.AY_UPD_UID,y.AY_UPD_DT"
//  		+ "from M_COMPANY c inner join M_GL_ACNT_YEAR y on c.COMP_CODE = y.AY_COMP_CODE",nativeQuery = true)
//   List<MGlAcntYearDto> findALL();
	

}
