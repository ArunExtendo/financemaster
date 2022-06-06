package com.maan.life.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListViewParam {

	private String search;
	private int pageSize;
	private int pageNumber;
	private String code[];

}
