/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2022-05-02 ( Date ISO 2022-05-02 - Time 15:42:11 )
 * Generated by Raj Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-05-02 ( 15:42:11 )
 * Generated by Raj ( http://www.telosys.org/ ) version 3.3.0
 */

package com.maan.life.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Domain class for entity "MDivision"
 *
 * @author Raj
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
@EntityListeners(AuditingEntityListener.class)
@IdClass(MDivisionId.class)
@Table(name = "M_DIVISION")

public class MDivision implements Serializable {

	private static final long serialVersionUID = 1L;

	// --- ENTITY PRIMARY KEY
	@Id
	@NotNull(message = "divn Code required")
	@Size(max = 12, message = "Divn code must be within 12 character")
	@Column(name = "DIVN_CODE", nullable = false, length = 12)
	private String divnCode;

	@Id
	@NotNull(message = "divn Comp Code required")
	@Size(max = 12, message = "Divn comp code must be within 12 character")
	@Column(name = "DIVN_COMP_CODE", nullable = false, length = 12)
	private String divnCompCode;

	// --- ENTITY DATA FIELDS
	@Size(max = 240, message = "Divn name must be within 240 character")
	@Column(name = "DIVN_NAME", length = 240)
	private String divnName;

	@Size(max = 30, message = "Divn short name must be within 30 character")
	@Column(name = "DIVN_SHORT_NAME", length = 30)
	private String divnShortName;

	@Size(max = 5, message = "Divn header must be within 5 character")
	@Column(name = "DIVN_HEADER", length = 5)
	private String divnHeader;

	@Size(max = 240, message = "Divn bl name must be within 240 character")
	@Column(name = "DIVN_BL_NAME", length = 240)
	private String divnBlName;

	@Size(max = 30, message = "Divn bl short name must be within 30 character")
	@Column(name = "DIVN_BL_SHORT_NAME", length = 30)
	private String divnBlShortName;

	@Size(max = 1, message = "Divn frz flag must be within 1 character")
	@Column(name = "DIVN_FRZ_FLAG", length = 1)
	private String divnFrzFlag;

	@CreatedBy
	@Size(max = 12, message = "Divn cr uid must be within 12 character")
	@Column(name = "DIVN_CR_UID", length = 12, nullable = false, updatable = false)
	private String divnCrUid ;

	@CreatedDate
	@Column(name = "DIVN_CR_DT", nullable = false, updatable = false)
	private LocalDateTime divnCrDt;

	@LastModifiedDate
	@Column(name = "DIVN_UPD_DT")
	private LocalDateTime divnUpdDt;

	@LastModifiedBy
	@Size(max = 12, message = "Divn upd uid must be within 12 character")
	@Column(name = "DIVN_UPD_UID", length = 12)
	private String divnUpdUid;

	@Size(max = 12, message = "Divn base curr code1 must be within 12 character")
	@Column(name = "DIVN_BASE_CURR_CODE_1", length = 12)
	private String divnBaseCurrCode1;

	@Size(max = 12, message = "Divn base curr code2 must be within 12 character")
	@Column(name = "DIVN_BASE_CURR_CODE_2", length = 12)
	private String divnBaseCurrCode2;

	@Size(max = 12, message = "Divn base curr code3 must be within 12 character")
	@Column(name = "DIVN_BASE_CURR_CODE_3", length = 12)
	private String divnBaseCurrCode3;

	@Column(name = "DIVN_ROUND_OFF")
	private BigDecimal divnRoundOff;

	@Size(max = 240, message = "Divn unit name must be within 240 character")
	@Column(name = "DIVN_UNIT_NAME", length = 240)
	private String divnUnitName;
	
	@Transient
	private Boolean create=false;

	// --- ENTITY LINKS ( RELATIONSHIP )

}
