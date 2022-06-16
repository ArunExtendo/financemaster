
package com.maan.life.repository;

import com.maan.life.dto.Option;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maan.life.bean.MCompany;

import java.util.List;

public interface MCompanyRepository extends JpaRepository<MCompany, String>, JpaSpecificationExecutor<MCompany> {

	@Query(value = "select * from M_company where upper(concat(comp_code,comp_name)) like upper(:search)", nativeQuery = true)
	Page<MCompany> findAll(@Param("search") String search, Pageable paging);


	@Query(value = "select new com.maan.life.dto.Option(c.compCode,c.compName) from MCompany c " )
	List<Option> getList();

}
