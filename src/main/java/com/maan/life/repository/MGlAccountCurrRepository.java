
package com.maan.life.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.maan.life.bean.MGlAccountCurr;
import com.maan.life.bean.MGlAccountCurrId;

/**
 * <h2>MGlAccountCurrRepository</h2>
 *
 * createdAt : 2022-05-02 - Time 15:42:12
 * <p>
 * Description: "MGlAccountCurr" Repository
 */
public interface MGlAccountCurrRepository
		extends JpaRepository<MGlAccountCurr, MGlAccountCurrId>, JpaSpecificationExecutor<MGlAccountCurr> {

	@Query(value = "select * from M_GL_ACCOUNT_CURR where upper(ACURR_MAIN_ACNT_CODE || ACURR_SUB_ACNT_CODE || ACURR_CURR_CODE ) like upper(:search) order by ACURR_MAIN_ACNT_CODE ASC", nativeQuery = true)
	Page<MGlAccountCurr> findAll(String search, Pageable paging);

	Optional<MGlAccountCurr> findByAcurrMainAcntCodeAndAcurrSubAcntCode(String acurrMainAcntCode,
			String acurrSubAcntCode);

}
