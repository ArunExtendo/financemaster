
package com.maan.life.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.maan.life.bean.MCompany;

public interface MCompanyService {

	MCompany create(MCompany d);

	MCompany update(MCompany d);

//MCompany getOne(long id) ;
	List<MCompany> getAll();

	long getTotal();

//boolean delete(long id);
	Optional<MCompany> findByCompCode(String compCode);

	public void saveorupdate(MCompany obj);

	Page<MCompany> findAll(Pageable paging);

	Page<MCompany> findSearch(String search, Pageable paging);

}
