
package com.maan.life.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maan.life.bean.MAppCodes;
import com.maan.life.bean.MAppCodesId;

public interface MAppCodesRepository
		extends JpaRepository<MAppCodes, MAppCodesId>, JpaSpecificationExecutor<MAppCodes> {

	@Query(value = "select * from M_App_Codes where upper(concat(AC_TYPE,AC_CODE)) like upper(:search)", nativeQuery = true)
	Page<MAppCodes> findAll(@Param("search") String search, Pageable paging);

}
