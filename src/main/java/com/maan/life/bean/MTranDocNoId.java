package com.maan.life.bean;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MTranDocNoId implements Serializable {

	private static final long serialVersionUID = 1L;

	// --- ENTITY KEY ATTRIBUTES
	private String tdnDocType;
	
	private String tdnCompCode;
	
	private String tdnCode;
	
	private Double tdnYear;

}
