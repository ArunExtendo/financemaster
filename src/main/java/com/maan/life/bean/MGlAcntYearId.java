
package com.maan.life.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Composite primary key for entity "MGlAcntYear" ( stored in table
 * "M_GL_ACNT_YEAR" )
 *
 * @author Indrabalan Ramadoss
 * 
 *         Created on 21-06-2022
 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MGlAcntYearId implements Serializable {

	private static final long serialVersionUID = 1L;

	// --- ENTITY KEY ATTRIBUTES
	private String ayCompCode;

	private BigDecimal ayAcntYear;

}
