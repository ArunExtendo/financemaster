package com.maan.life.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maan.life.util.Constants;

import java.time.LocalDateTime;

public interface MCurrencyDto {

	String getCurrCode();

	String getCurrName();

	String getCurrBlName();

	String getCurrShortName();

	String getCurrBlShortName();

	String getCurrFreezYn();

	@JsonFormat(pattern = Constants.DATE_FORMAT_PATTERN)
	LocalDateTime getCurrFreezDt();
}
