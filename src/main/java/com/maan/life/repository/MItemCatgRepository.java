package com.maan.life.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.maan.life.bean.MItemCatg;
import com.maan.life.bean.MItemCatgId;

@Repository
public interface MItemCatgRepository extends JpaRepository<MItemCatg, MItemCatgId>, JpaSpecificationExecutor<MItemCatg> {

	Optional<MItemCatg> findByIcCodeAndIcCompCode(String icCode, String icCompCode);

	@Query(value = "select a.icCode as icCode, a.icDesc as icDesc, a.icDeprPerc as icDeprPerc from MItemCatg a")
	Page<MItemCatg> findByAll(Pageable paging);

	@Query(value = "select a.icCode as icCode, a.icDesc as icDesc, a.icDeprPerc as icDeprPerc from MItemCatg a "
			+ "where upper(a.icCode || a.icDesc || a.icDeprPerc) like upper(:search)")
	Page<MItemCatg> findBySearch(String search, Pageable paging);

}
