package com.maan.life.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;


public interface MGlAcntYearDto {

	 String getCompanyName();

	 String geTayCompCode();

	 BigDecimal getAyAcntYear();

	 String getAyPrevCurrNext();

	 Date getAyFmDt();

	 Date getAyToDt();

	 String getAyMainAcntCode();

	 String getAySubAcntCode();

	 String getAyCloseOption();

	 String getAyCrUid();

	 LocalDateTime getAyCrDt();

	 String getAyUpdUid();

	 LocalDateTime getAyUpdDt();

	 Boolean create = false;

	
	
	
}
