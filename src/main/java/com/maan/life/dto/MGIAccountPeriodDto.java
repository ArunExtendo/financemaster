package com.maan.life.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maan.life.util.Constants;

public interface MGIAccountPeriodDto {
	
	// --- ENTITY PRIMARY KEY
	 String getApCompCode();

	
	 BigDecimal getApAcntYear();


	 BigDecimal getApCalYear();


	 BigDecimal getApCalMonth();

	// --- ENTITY DATA FIELDS
	 @JsonFormat(pattern = Constants.DATE_FORMAT_PATTERN)
	 Date getApFmDt();

	 @JsonFormat(pattern = Constants.DATE_FORMAT_PATTERN)
	 Date getApToDt();

	 BigDecimal getApQtly();




}
