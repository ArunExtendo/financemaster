
package com.maan.life.service;

import java.util.List;

import com.maan.life.dto.Option;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.maan.life.bean.MCompany;

public interface MCompanyService {

	MCompany create(MCompany d);

	MCompany update(MCompany d);

    //MCompany getOne(long id) ;
	List<Option> getList();

	long getTotal();

	public void saveorupdate(MCompany obj);

	Page<MCompany> getAll(String search, Pageable paging);

}
