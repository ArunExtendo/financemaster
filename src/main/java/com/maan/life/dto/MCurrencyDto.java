package com.maan.life.dto;

import java.time.LocalDateTime;

public interface MCurrencyDto {

	String getCurrCode();

	String getCurrName();

	String getCurrBlName();

	String getCurrShortName();

	String getCurrBlShortName();

	String getCurrFreezYn();

	LocalDateTime getCurrFreezDt();
}
