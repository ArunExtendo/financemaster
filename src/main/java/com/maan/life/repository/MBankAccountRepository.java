
package com.maan.life.repository;

import com.maan.life.bean.MBank;
import com.maan.life.bean.MBankAcntDtl;
import com.maan.life.bean.MBankAcntDtlId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MBankAccountRepository extends JpaRepository<MBankAcntDtl, MBankAcntDtlId>, JpaSpecificationExecutor<MBank> {


	@Query(value = "select * from M_BANK_ACNT_DTL where  BAD_ACNT_NO like upper(:search) OR BAD_IBAN_NO like upper(:search) OR BAD_ACNT_NAME like upper(:search) OR BAD_ACNT_BRANCH like upper(:search) " +
			"OR BAD_SORT_CODE like upper(:search) ", nativeQuery = true)
	Page<MBankAcntDtl> findAll(@Param("search") String search, Pageable paging);


}
