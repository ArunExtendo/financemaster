package com.maan.life.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.maan.life.bean.MGlAccountComp;
import com.maan.life.dto.ListViewParam;

public interface MGlAccountCompService {

	void saveorupdate(MGlAccountComp object);

	Page<MGlAccountComp> findAllMGlAccountCompDetails(ListViewParam request);

	Optional<MGlAccountComp> findById(String string);

}
