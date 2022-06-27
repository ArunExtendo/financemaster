package com.maan.life.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.maan.life.bean.MGlAccountCurr;
import com.maan.life.dto.ListViewParam;

public interface MGlAccountCurrService {

	void saveorupdate(MGlAccountCurr object);

	Page<MGlAccountCurr> findAllGlAccountCurrDetails(ListViewParam request);

	Optional<MGlAccountCurr> findById(ListViewParam request);

}
