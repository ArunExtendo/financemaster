
package com.maan.life.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maan.life.bean.MAppCodes;
import com.maan.life.bean.MAppCodesId;
import com.maan.life.dto.Option;

public interface MAppCodesRepository
		extends JpaRepository<MAppCodes, MAppCodesId>, JpaSpecificationExecutor<MAppCodes> {

	@Query(value = "select * from M_App_Codes where upper(concat(AC_TYPE,AC_CODE)) like upper(:search)", nativeQuery = true)
	Page<MAppCodes> findAll(@Param("search") String search, Pageable paging);

	@Query(value = "select new com.maan.life.dto.Option(c.acType,c.acCode,acDesc) from MAppCodes c where c.acType = :type " )
	List<Option> getListByType(String type);
	
	Optional<MAppCodes> findByAcTypeAndAcCode(String atcType, String acCode);
}
