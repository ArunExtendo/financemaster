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

	@Query(value = "select curr_code as currCode, curr_name as currName, curr_bl_name as currBlName, " +
			"curr_short_name as currShortName, curr_bl_short_name as currBlShortName, curr_freez_yn as currFreezYn," +
			" curr_freez_dt as currFreezDt from M_CURRENCY " +
			"where upper(concat(concat(concat(concat(concat(concat(curr_code,curr_name),curr_bl_name),curr_short_name)," +
			"curr_bl_short_name),curr_freez_yn),curr_freez_dt)) like Upper(:sear)", nativeQuery = true)
	Page<MCurrencyDto> findBySearch(String sear, Pageable paging);


	@Query(value = "select curr_code as currCode, curr_name as currName, curr_bl_name as currBlName, curr_short_name as currShortName, curr_bl_short_name as currBlShortName, curr_freez_yn as currFreezYn, curr_freez_dt as currFreezDt from M_CURRENCY", nativeQuery = true)
	Page<MCurrencyDto> findByAll(Pageable paging);
	
	
	@Query(value = "select new com.maan.life.dto.Option(currCode,currName) from MCurrency " )
	List<Option> getList();

}
