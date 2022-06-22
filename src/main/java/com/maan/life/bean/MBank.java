/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2022-05-02 ( Date ISO 2022-05-02 - Time 15:41:57 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-05-02 ( 15:41:57 )
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

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
* Domain class for entity "MBank"
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
@Table(name="M_BANK")
@EntityListeners(AuditingEntityListener.class)
public class MBank implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="BANK_CODE", nullable=false)
    @NotNull(message = "Bank code is required")
    @NotEmpty(message = "Bank code is required")
    @Size(max = 12, message = "Bank Code must be within 12 character")
    private String     bankCode ;

    //--- ENTITY DATA FIELDS 
    @Column(name="BANK_NAME", nullable=false)
    @NotNull(message = "Bank Name is required")
    @NotEmpty(message = "Bank Name is required")
    @Size(max = 240, message = "Bank Name must be within 240 character")
    private String     bankName ;

    @Column(name="BANK_SHORT_NAME")
    @Size(max = 60, message = "Bank Code must be within 60 character")
    private String     bankShortName ;

    @Column(name="BANK_ADDR_01")
    @Size(max = 240, message = "Address Line 1 must be within 240 character")
    private String     bankAddr01 ;

    @Column(name="BANK_ADDR_02")
    @Size(max = 240, message = "Address Line 2  must be within 240 character")
    private String     bankAddr02 ;

    @Column(name="BANK_ADDR_03")
    @Size(max = 240, message = "Address Line 3  must be within 240 character")
    private String     bankAddr03 ;

    @Column(name="BANK_PO_BOX_NO" )
    @Size(max = 60, message = "PO BOX Number must be within 60 character")
    private String     bankPoBoxNo ;

    @Column(name="BANK_COUNTRY" )
    @Size(max = 12, message = "Country must be within 12 character")
    private String     bankCountry ;

    @Column(name="BANK_CITY")
    @Size(max = 12, message = "City must be within 12 character")
    private String     bankCity ;

    @Column(name="BANK_PHONE_NO")
    @Size(max = 60, message = "Phone Number must be within 60 character")
    private String     bankPhoneNo ;

    @Column(name="BANK_FAX_NO")
    @Size(max = 60, message = "FAX Number must be within 60 character")
    private String     bankFaxNo ;

    @Column(name="BANK_EMAIL")
    @Size(max = 60, message = "Email Address  must be within 60 character")
    private String     bankEmail ;

    @Column(name="BANK_WEBSITE")
    @Size(max = 60, message = "Website Address must be within 60 character")
    private String     bankWebsite ;

    @Column(name="BANK_LOGO")
    @Size(max = 240 , message = "Logo must be within 240 character")
    private String     bankLogo ;

    @Column(name="BANK_CONT_PER_NAME")
    @Size(max = 240, message = "Contact Person Name  must be within 240 character")
    private String     bankContPerName ;

    @Column(name="BANK_CONT_PER_PH_NO")
    @Size(max = 60, message = "Contact Person Phone Number  must be within 60 character")
    private String     bankContPerPhNo ;

    @Column(name="BANK_CONT_PER_EMAIL")
    @Size(max = 60, message = "Contact Person Email  must be within 60 character")
    private String     bankContPerEmail ;

    @CreatedBy
    @Column(name="BANK_CR_UID", nullable=false,updatable = false)
    private String     bankCrUid ;

    @CreatedDate
    @Column(name="BANK_CR_DT", nullable=false,updatable = false)
    private LocalDateTime bankCrDt ;

    @LastModifiedBy
    @Column(name="BANK_UPD_UID")
    private String     bankUpdUid ;

    @LastModifiedDate
    @Column(name="BANK_UPD_DT")
    private LocalDateTime       bankUpdDt ;


}



