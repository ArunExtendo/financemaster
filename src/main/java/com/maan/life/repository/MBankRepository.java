
package com.maan.life.repository;

import com.maan.life.bean.MBank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MBankRepository extends JpaRepository<MBank, String>, JpaSpecificationExecutor<MBank> {

	@Query(value = "select * from M_BANK where  BANK_CODE like upper(:search) OR BANK_NAME like upper(:search) OR BANK_SHORT_NAME like upper(:search) OR BANK_ADDR_01 like upper(:search)\n" +
			"OR BANK_CONT_PER_NAME like upper(:search) OR BANK_CONT_PER_PH_NO  like upper(:search) OR  BANK_CONT_PER_EMAIL like upper(:search)", nativeQuery = true)
	Page<MBank> findAll(@Param("search") String search, Pageable paging);


}
