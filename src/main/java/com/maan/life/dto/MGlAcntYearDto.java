package com.maan.life.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maan.life.util.Constants;

public interface MGlAcntYearDto {

	String getCompanyName();

	String getTayCompCode();

	BigDecimal getAyAcntYear();

	String getAyPrevCurrNext();

	@JsonFormat(pattern = Constants.DATE_FORMAT_PATTERN)
	Date getAyFmDt();

	@JsonFormat(pattern = Constants.DATE_FORMAT_PATTERN)
	Date getAyToDt();

	String getAyMainAcntCode();

	String getAySubAcntCode();

	String getAyCloseOption();

}