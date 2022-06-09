
package com.maan.life.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maan.life.bean.MAppParameter;
import com.maan.life.bean.MAppParameterId;

public interface MAppParameterRepository
		extends JpaRepository<MAppParameter, MAppParameterId>, JpaSpecificationExecutor<MAppParameter> {

	@Query(value = "select * from M_APP_PARAMETER where upper(PARA_CODE || PARA_SUB_CODE || PARA_NAME || PARA_NAME_BL || PARA_REMARK || PARA_REMARK_BL || PARA_VALUE) like upper(:search)", nativeQuery = true)
	Page<MAppParameter> findAll(@Param("search") String search, Pageable paging);
}
