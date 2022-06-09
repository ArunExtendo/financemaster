package com.maan.life.dto;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListViewParam {

	private String search;
	private int pageSize;
	private int pageNumber;
	private String code[];
	
	public static void main(String[] args) throws Exception {

		ListViewParam hdr = new ListViewParam();	
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(hdr);
		System.out.print(jsonString);
	}

}
