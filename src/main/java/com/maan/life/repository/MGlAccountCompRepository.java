/*
 * Java domain class for entity "MExchangeRate" 
 * Created on 2022-05-02 ( Date ISO 2022-05-02 - Time 15:42:12 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
* Created on 2022-05-02 ( 15:42:12 )
* Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
*/

package com.maan.life.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.maan.life.bean.MGlAccountComp;

/**
 * <h2>MGlAccountCompRepository</h2>
 *
 * createdAt : 2022-05-02 - Time 15:42:12
 * <p>
 * Description: "MGlAccountComp" Repository
 */
public interface MGlAccountCompRepository
		extends JpaRepository<MGlAccountComp, String>, JpaSpecificationExecutor<MGlAccountComp> {

	@Query(value = "select * from M_GL_ACCOUNT_COMP where upper(ACOMP_MAIN_ACNT_CODE || ACOMP_COMP_CODE || ACOMP_SUB_ACNT_CODE || ACOMP_DIVN_CODE_FM) like upper(:search) order by ACOMP_MAIN_ACNT_CODE ASC", nativeQuery = true)
	Page<MGlAccountComp> findAll(String search, Pageable paging);

}
