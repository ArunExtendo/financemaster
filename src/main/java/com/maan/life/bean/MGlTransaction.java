/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2022-05-02 ( Date ISO 2022-05-02 - Time 15:42:16 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-05-02 ( 15:42:16 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */

package com.maan.life.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Domain class for entity "MGlTransaction"
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
@Table(name = "M_GL_TRANSACTION")

public class MGlTransaction implements Serializable {

	private static final long serialVersionUID = 1L;

	// --- ENTITY PRIMARY KEY
	@Id
	@NotNull(message = "Tran code required")
	@Size(max = 12, message = "Tran code must be within 12 character")
	@Column(name = "TRAN_CODE", nullable = false, length = 12)
	private String tranCode;

	// --- ENTITY DATA FIELDS
	@Size(max = 240, message = "Tran name must be within 240 character")
	@Column(name = "TRAN_NAME", length = 240)
	private String tranName;

	@Size(max = 240, message = "Tran bl name must be within 240 character")
	@Column(name = "TRAN_BL_NAME", length = 240)
	private String tranBlName;

	@Size(max = 12, message = "Tran type must be within 12 character")
	@NotNull(message = "tran type required")
	@Column(name = "TRAN_TYPE", nullable = false, length = 12)
	private String tranType;

	@Size(max = 1, message = "Tran post mode must be within 1 character")
	@Column(name = "TRAN_POST_MODE", length = 1)
	private String tranPostMode;

	@Size(max = 1, message = "Tran source must be within 1 character")
	@Column(name = "TRAN_SOURCE", length = 1)
	private String tranSource;

	@Size(max = 1, message = "Tran acnt type must be within 1 character")
	@Column(name = "TRAN_ACNT_TYPE", length = 1)
	private String tranAcntType;

	@Column(name = "TRAN_BACK_DAYS")
	private BigDecimal tranBackDays;

	@Column(name = "TRAN_FUTURE_DAYS")
	private BigDecimal tranFutureDays;

	@Size(max = 1, message = "Tran ua req yn must be within 1 character")
	@Column(name = "TRAN_UA_REQ_YN", length = 1)
	private String tranUaReqYn;

	@Size(max = 12, message = "tranUaType must be within 12 character")
	@Column(name = "TRAN_UA_TYPE", length = 12)
	private String tranUaType;

	@Size(max = 1, message = "Tran auto print yn must be within 1 character")
	@Column(name = "TRAN_AUTO_PRINT_YN", length = 1)
	private String tranAutoPrintYn;

	@Column(name = "TRAN_MIN_AMT")
	private BigDecimal tranMinAmt;

	@Column(name = "TRAN_MAX_AMT")
	private BigDecimal tranMaxAmt;

	@Size(max = 12, message = "tran dflt main acnt code must be within 12 character")
	@Column(name = "TRAN_DFLT_MAIN_ACNT_CODE", length = 12)
	private String tranDfltMainAcntCode;

	@Size(max = 12, message = "tran dflt sub acnt code must be within 12 character")
	@Column(name = "TRAN_DFLT_SUB_ACNT_CODE", length = 12)
	private String tranDfltSubAcntCode;

	@Size(max = 12, message = "tran dflt chrg acnt code must be within 12 character")
	@Column(name = "TRAN_DFLT_CHRG_ACNT_CODE", length = 12)
	private String tranDfltChrgAcntCode;

	@Size(max = 1, message = "Tran freez yn must be within 1 character")
	@Column(name = "TRAN_FREEZ_YN", length = 1)
	private String tranFreezYn;

	@Temporal(TemporalType.DATE)
	@Column(name = "TRAN_FREEZ_DT")
	private Date tranFreezDt;

	@Size(max = 12, message = "Tran cr uid must be within 12 character")
	@Column(name = "TRAN_CR_UID", length = 12)
	private String tranCrUid;

	@CreatedDate
	@Column(name = "TRAN_CR_DT")
	private LocalDateTime tranCrDt;

	@Size(max = 12, message = "Tran upd uid must be within 12 character")
	@Column(name = "TRAN_UPD_UID", length = 12)
	private String tranUpdUid;

	@LastModifiedDate
	@Column(name = "TRAN_UPD_DT")
	private LocalDateTime tranUpdDt;

	@Size(max = 240, message = "Tran flex01 must be within 240 character")
	@Column(name = "TRAN_FLEX_01", length = 240)
	private String tranFlex01;

	@Size(max = 240, message = "Tran flex02 must be within 240 character")
	@Column(name = "TRAN_FLEX_02", length = 240)
	private String tranFlex02;

	@Size(max = 240, message = "Tran flex03 must be within 240 character")
	@Column(name = "TRAN_FLEX_03", length = 240)
	private String tranFlex03;

	@Size(max = 240, message = "Tran flex04 must be within 240 character")
	@Column(name = "TRAN_FLEX_04", length = 240)
	private String tranFlex04;

	@Size(max = 240, message = "Tran flex05 must be within 240 character")
	@Column(name = "TRAN_FLEX_05", length = 240)
	private String tranFlex05;

	@Size(max = 240, message = "Tran flex06 must be within 240 character")
	@Column(name = "TRAN_FLEX_06", length = 240)
	private String tranFlex06;

	@Size(max = 240, message = "Tran flex07 must be within 240 character")
	@Column(name = "TRAN_FLEX_07", length = 240)
	private String tranFlex07;

	@Size(max = 240, message = "Tran flex08 must be within 240 character")
	@Column(name = "TRAN_FLEX_08", length = 240)
	private String tranFlex08;

	@Size(max = 240, message = "Tran flex09 must be within 240 character")
	@Column(name = "TRAN_FLEX_09", length = 240)
	private String tranFlex09;

	@Size(max = 240, message = "Tran flex10 must be within 240 character")
	@Column(name = "TRAN_FLEX_10", length = 240)
	private String tranFlex10;
	
	@Transient
	private Boolean create =false;
	

	// --- ENTITY LINKS ( RELATIONSHIP )

}
