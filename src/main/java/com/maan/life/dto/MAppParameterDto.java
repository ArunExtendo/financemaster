package com.maan.life.dto;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MAppParameterDto {

	@Id
	@NotEmpty(message = "Para code is required")
	@Size(max = 12, message = "Para code is a 12 Character")
	private String paraCode;

	@Id
	@NotEmpty(message = "Para sub code is required")
	@Size(max = 12, message = "Para sub code is a 12 Character")
	private String paraSubCode;

	@Size(max = 240, message = "Para name is a 240 Character") // --- ENTITY DATA FIELDS
	private String paraName;

	@Size(max = 240, message = "Para nameBl is a 240 Character")
	private String paraNameBl;

	@Size(max = 240, message = "Para value is a 240 Character")
	private String paraValue;

	@Size(max = 4000, message = "Para remark is a 4000 Character")
	private String paraRemark;

	@Size(max = 4000, message = "Para remarkBl is a 4000 Character")
	private String paraRemarkBl;

	@NotEmpty(message = "Para CrUid required")
	@Size(max = 12, message = "Para sub code is a 12 Character")
	private String paraCrUid;

//	@NotEmpty(message = "Para CrDt  required")
	@Temporal(TemporalType.DATE)
	private Date paraCrDt;

	@Size(max = 12, message = "ParaUpd Uid is a 12 Character")
	private String paraUpdUid;

	@Temporal(TemporalType.DATE)
	private Date paraUpdDt;

}
