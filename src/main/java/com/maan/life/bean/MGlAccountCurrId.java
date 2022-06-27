/*
 * Created on 2022-05-02 ( 15:42:14 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.maan.life.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Composite primary key for entity "MGlAccountCurr" ( stored in table
 * "M_GL_ACCOUNT_CURR" )
 *
 * @author Kamalakannan Rameshbabu
 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MGlAccountCurrId implements Serializable {

	private static final long serialVersionUID = 1L;

	// --- ENTITY KEY ATTRIBUTES
	private String acurrMainAcntCode;

	private String acurrSubAcntCode;

}
