/*
 * Created on 2022-05-02 ( 15:41:58 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.maan.life.bean;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;



/**
 * Composite primary key for entity "MBankAcntDtl" ( stored in table "M_BANK_ACNT_DTL" )
 *
 * @author Telosys
 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MBankAcntDtlId implements Serializable {

    private static final long serialVersionUID = 1L;

    private String     badBankCode ;
    
    private String     badAcntNo ;
    
     
}
