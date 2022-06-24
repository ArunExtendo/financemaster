
package com.maan.life.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.maan.life.bean.MCompany;
import com.maan.life.dto.ListViewParam;

public interface MCompanyService {

	List<MCompany> getList();
	
	public void saveorupdate(MCompany obj);

	Map<String, Object> findAllCompanyDetails(ListViewParam request);
}
