package com.maan.life.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.maan.life.bean.MWfSteps;
import com.maan.life.bean.MWfStepsId;

@Repository
public interface MWfStepsRepository extends JpaRepository<MWfSteps, MWfStepsId>, JpaSpecificationExecutor<MWfSteps> {

	@Query(value = "select * from M_WF_STEPS where upper(WS_WORK_STEP_CODE || WS_WORK_STEP_NAME || WS_WORK_STEP_OWNER || WS_WORK_STEP_HANDLER) like upper(:search) order by WS_WORK_STEP_CODE ASC", nativeQuery = true)
	Page<MWfSteps> findAll(String search, Pageable paging);

	Optional<MWfSteps> findByWsWorkStepCodeAndWsWfCode(String wsWorkStepCode, String wsWfCode);

}