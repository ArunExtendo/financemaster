package com.maan.life.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.maan.life.bean.WCustRiskCalc;
import com.maan.life.dto.ListViewParam;

public interface WCustRiskCalcService {

	void saveorupdate(WCustRiskCalc object);

	Page<WCustRiskCalc> findAllWCustRiskCalcDetails(ListViewParam request);

	Optional<WCustRiskCalc> findById(String string);

}
