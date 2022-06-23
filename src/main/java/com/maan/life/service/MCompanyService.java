
package com.maan.life.service;

import java.util.List;

import com.maan.life.dto.Option;
import org.springframework.data.domain.Page;

import com.maan.life.bean.MCompany;
import com.maan.life.dto.ListViewParam;

public interface MCompanyService {

	List<Option> getList();
	
	public void saveorupdate(MCompany obj);

	Page<MCompany> findAllCompanyDetails(ListViewParam request);
}
