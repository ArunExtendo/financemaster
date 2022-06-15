package com.maan.life.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.maan.life.bean.MGlTransaction;

@Repository
public interface MGlTransactionRepository extends JpaRepository<MGlTransaction, String>, JpaSpecificationExecutor<MGlTransaction> {

//	@Query(value = "select * from M_GL_TRANSACTION where upper(concat(TRAN_CODE || TRAN_TYPE)) like upper(:search)", nativeQuery = true)
//	Page<MGlTransaction> findAll(@Param("search") String search, Pageable paging);
}
