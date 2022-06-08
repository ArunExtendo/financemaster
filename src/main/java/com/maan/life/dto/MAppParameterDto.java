package com.maan.life.dto;

import java.util.Date;

import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MAppParameterDto {

	@Id
	private String paraCode;

	@Id
	private String paraSubCode;

	private String paraName;

	private String paraNameBl;

	private String paraValue;

	private String paraRemark;

	private String paraRemarkBl;

	private String paraCrUid;

	private Date paraCrDt;

	private String paraUpdUid;

	private Date paraUpdDt;

}
