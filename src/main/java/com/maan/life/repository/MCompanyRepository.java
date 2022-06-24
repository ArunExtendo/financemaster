
package com.maan.life.repository;

import com.maan.life.dto.MCompanyDto;
import com.maan.life.dto.Option;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maan.life.bean.MCompany;

import java.util.List;

public interface MCompanyRepository extends JpaRepository<MCompany, String>, JpaSpecificationExecutor<MCompany> {

	@Query(value = "select c.COMP_CODE as compCode, c.COMP_NAME as compName, c1.CURR_NAME as compBaseCurrCode1," +
			" c2.CURR_NAME as compBaseCurrCode2,c3.CURR_NAME as compBaseCurrCode3, " +
			" c.COMP_ROUND_OFF as compRoundOff, c.COMP_UNIT_NAME as compUnitName " +
			" from M_COMPANY c LEFT JOIN M_CURRENCY c1 ON c.COMP_BASE_CURR_CODE_1 = c1.CURR_CODE " +
			" LEFT JOIN M_CURRENCY c2 ON c.COMP_BASE_CURR_CODE_2 = c2.CURR_CODE " +
			" LEFT JOIN M_CURRENCY c3 ON c.COMP_BASE_CURR_CODE_3 = c3.CURR_CODE " +
			" where upper( c.COMP_CODE || c.COMP_NAME || c1.CURR_NAME || c2.CURR_NAME || c3.CURR_NAME  " +
			" || c.COMP_UNIT_NAME  || c.COMP_ROUND_OFF ) " +
			" like upper(:search)", 
			countQuery = "select count(c.COMP_CODE) " +
					"    from M_COMPANY c LEFT JOIN M_CURRENCY c1 ON c.COMP_BASE_CURR_CODE_1 = c1.CURR_CODE  " +
					"    LEFT JOIN M_CURRENCY c2 ON c.COMP_BASE_CURR_CODE_2 = c2.CURR_CODE  " +
					"    LEFT JOIN M_CURRENCY c3 ON c.COMP_BASE_CURR_CODE_3 = c3.CURR_CODE  " +
					"    where upper( c.COMP_CODE || c.COMP_NAME || c1.CURR_NAME || c2.CURR_NAME || c3.CURR_NAME   " +
					"    || c.COMP_UNIT_NAME  || c.COMP_ROUND_OFF )  " +
					"    like upper(:search)"
			,nativeQuery = true)
	Page<MCompanyDto> findAllBySearch(@Param("search") String search, Pageable paging);


	@Query(value = "select new com.maan.life.dto.Option(c.compCode,c.compName) from MCompany c " )
	List<Option> getList();

}
