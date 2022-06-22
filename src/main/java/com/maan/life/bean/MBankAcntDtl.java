/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2022-05-02 ( Date ISO 2022-05-02 - Time 15:41:58 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-05-02 ( 15:41:58 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.life.bean;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Table;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
* Domain class for entity "MBankAcntDtl"
*
* @author Telosys Tools Generator
*
*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@DynamicInsert
@DynamicUpdate
@Builder
@IdClass(MBankAcntDtlId.class)
@Table(name="M_BANK_ACNT_DTL")
@EntityListeners(AuditingEntityListener.class)
public class MBankAcntDtl implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="BAD_BANK_CODE", nullable=false)
    @NotNull(message = "Bank code is required")
    @Size(max = 12, message = "Bank code  must be within 12 character")
    private String     badBankCode ;

    @Id
    @Column(name="BAD_ACNT_NO", nullable=false)
    @NotNull(message = "Account Number is required")
    @Size(max = 60, message = "Account Number must be within 60 character")
    private String     badAcntNo ;

    //--- ENTITY DATA FIELDS 
    @Column(name="BAD_ACNT_NAME")
    @Size(max = 240, message = "Account Name  must be within 240 character")
    private String     badAcntName ;

    @Column(name="BAD_IBAN_NO")
    @Size(max = 60, message = " IBAN Number must be within 60 character")
    private String     badIbanNo ;

    @Column(name="BAD_ACNT_TYPE")
    @Size(max = 12, message = "Bank Account Type must be within 12 character")
    private String     badAcntType ;

    @Column(name="BAD_ACNT_BRANCH")
    @Size(max = 240, message = "Bank Account Branch must be within 240 character")
    private String     badAcntBranch ;

    @Column(name="BAD_MAIN_ACNT_CODE")
    @Size(max = 12, message = "Main Account Code  must be within 12 character")
    private String     badMainAcntCode ;

    @Column(name="BAD_CURR_CODE")
    @Size(max = 12, message = "Currency Code  must be within 12 character")
    private String   badCurrCode ;

    @CreatedBy
    @Column(name="BAD_CR_UID", nullable=false)
    private String  badCrUid ;

    @CreatedDate
    @Column(name="BAD_CR_DT", nullable=false)
    private LocalDateTime badCrDt ;

    @LastModifiedBy
    @Column(name="BAD_UPD_UID")
    private String  badUpdUid ;

    @LastModifiedDate
    @Column(name="BAD_UPD_DT")
    private LocalDateTime   badUpdDt ;

    @Column(name="BAD_SORT_CODE")
    private BigDecimal badSortCode ;

}



