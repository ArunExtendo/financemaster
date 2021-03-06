/*
 * Created on 2022-05-02 ( 15:42:15 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
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
 * Composite primary key for entity "MGlAcntPeriod" ( stored in table "M_GL_ACNT_PERIOD" )
 *
 * @author Indrabalan Ramadoss
 * 
 * Created on 21-06-2022
 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MGlAcntPeriodId implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY KEY ATTRIBUTES 
    private String     apCompCode ;
    
    private BigDecimal apAcntYear ;
    
    private BigDecimal apCalYear ;
    
    private BigDecimal apCalMonth ;
    
     
}
