package com.maan.life.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.maan.life.bean.MCurrency;
import com.maan.life.dto.MCurrencyDto;
import com.maan.life.dto.Option;

@Repository
public interface MCurrencyRepository extends JpaRepository<MCurrency, String>, JpaSpecificationExecutor<MCurrency> {

	@Query(value = "select c.currCode as currCode, c.currName as currName, c.currBlName as currBlName, " +
			"c.currShortName as currShortName, c.currBlShortName as currBlShortName, c.currFreezYn as currFreezYn," +
			" c.currFreezDt as currFreezDt  from MCurrency c " +
			"where upper(concat(concat(concat(concat(concat(concat(c.currCode,c.currName),c.currBlName),c.currShortName)," +
			"c.currBlShortName),c.currFreezYn),c.currFreezDt)) like Upper(:sear)")
	Page<MCurrencyDto> findBySearch(String sear, Pageable paging);


	@Query(value = "select c.currCode as currCode, c.currName as currName, c.currBlName as currBlName, " +
			"c.currShortName as currShortName, c.currBlShortName as currBlShortName, c.currFreezYn as currFreezYn," +
			" c.currFreezDt as currFreezDt from MCurrency c" )
	Page<MCurrencyDto> findByAll(Pageable paging);
	
	
	@Query(value = "select new com.maan.life.dto.Option(currCode,currName) from MCurrency " )
	List<Option> getList();

}
