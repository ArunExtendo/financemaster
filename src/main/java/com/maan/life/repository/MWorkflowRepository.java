package com.maan.life.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.maan.life.bean.MWorkflow;

@Repository
public interface MWorkflowRepository extends JpaRepository<MWorkflow, String>, JpaSpecificationExecutor<MWorkflow> {

	@Query(value = "select * from M_WORKFLOW where upper(WF_CODE || WF_DESC || WF_PRODUCT_CODE || WF_MODULE_CODE || WF_TAT_FREQ || WF_TAT) like upper(:search)", nativeQuery = true)
	Page<MWorkflow> findAll(@Param("search") String search, Pageable paging);

}
