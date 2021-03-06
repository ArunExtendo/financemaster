
package com.maan.life.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.maan.life.dto.Option;
import org.springframework.data.domain.Page;

import com.maan.life.bean.MCompany;
import com.maan.life.dto.ListViewParam;

public interface MCompanyService {

	List<Option> getList();
	
	public void saveorupdate(MCompany obj);

	Map<String, Object> findAllCompanyDetails(ListViewParam request);

    Optional<MCompany> findById(String compCode);
}
