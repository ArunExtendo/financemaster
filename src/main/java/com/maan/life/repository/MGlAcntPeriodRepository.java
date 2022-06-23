package com.maan.life.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.maan.life.bean.MGlAcntPeriod;
import com.maan.life.bean.MGlAcntPeriodId;
import com.maan.life.dto.MGIAccountPeriodDto;

public interface MGlAcntPeriodRepository extends JpaRepository<MGlAcntPeriod, MGlAcntPeriodId>, JpaSpecificationExecutor<MGlAcntPeriod> {


	@Query(value = "select p.apCompCode as apCompCode,p.apAcntYear as apAcntYear,p.apCalYear as apCalYear,p.apCalMonth as apCalMonth,"
			+ "p.apFmDt as apFmDt ,p.apToDt as apToDt,p.apQtly as apQtly  from MGlAcntPeriod p ")
	Page<MGIAccountPeriodDto> findByAll(Pageable paging);

	@Query(value = "select p.apCompCode as apCompCode,p.apAcntYear as apAcntYear,p.apCalYear as apCalYear,p.apCalMonth as apCalMonth,"
			+ "p.apFmDt as apFmDt ,p.apToDt as apToDt,p.apQtly as apQtly  from MGlAcntPeriod p where "
			+ "upper(p.apCalYear || p.apCompCode || p.apQtly || p.apFmDt || p.apToDt) like upper(:search)")
	Page<MGIAccountPeriodDto> findBySearch(String search, Pageable paging);

	Optional<MGlAcntPeriod> findByApCompCodeAndApAcntYearAndApCalYearAndApCalMonth(String apCompCode,
			BigDecimal apAcntYearbd, BigDecimal apCalYearbd, BigDecimal apCalMonthbd);

}
