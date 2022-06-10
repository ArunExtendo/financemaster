package com.maan.life.dto;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MAppCodesDto {

	private String acType;

	private String acCode;

	private String acValue;

	private String acMcCode;

	private String acMastDefCode;

	private String acDesc;

	private String acDescBl;

	private String acShortDesc;

	private String acShortDescBl;

	private String acLongDesc;

	private String acLongDescBl;

	private String acCodeByLobYn;

	private String acLobCode;

	private String acApplCompCode;

	private Date acEffFmDt;

	private Date acEffToDt;

	private String acCrUid;

	private LocalDateTime acCrDt;

	private String acUpdUid;

	private LocalDateTime acUpdDt;

}
