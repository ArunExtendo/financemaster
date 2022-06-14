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
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Domain class for entity "MGlTransaction"
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
@EntityListeners(AuditingEntityListener.class)
@Table(name = "M_GL_TRANSACTION")

public class MGlTransaction implements Serializable {

	private static final long serialVersionUID = 1L;

	// --- ENTITY PRIMARY KEY
	@Id
	@Column(name = "TRAN_CODE", nullable = false, length = 12)
	private String tranCode;

	// --- ENTITY DATA FIELDS
	@Column(name = "TRAN_NAME", length = 240)
	private String tranName;

	@Column(name = "TRAN_BL_NAME", length = 240)
	private String tranBlName;

	@Column(name = "TRAN_TYPE", nullable = false, length = 12)
	private String tranType;

	@Column(name = "TRAN_POST_MODE", length = 1)
	private String tranPostMode;

	@Column(name = "TRAN_SOURCE", length = 1)
	private String tranSource;

	@Column(name = "TRAN_ACNT_TYPE", length = 1)
	private String tranAcntType;

	@Column(name = "TRAN_BACK_DAYS")
	private BigDecimal tranBackDays;

	@Column(name = "TRAN_FUTURE_DAYS")
	private BigDecimal tranFutureDays;

	@Column(name = "TRAN_UA_REQ_YN", length = 1)
	private String tranUaReqYn;

	@Column(name = "TRAN_UA_TYPE", length = 12)
	private String tranUaType;

	@Column(name = "TRAN_AUTO_PRINT_YN", length = 1)
	private String tranAutoPrintYn;

	@Column(name = "TRAN_MIN_AMT")
	private BigDecimal tranMinAmt;

	@Column(name = "TRAN_MAX_AMT")
	private BigDecimal tranMaxAmt;

	@Column(name = "TRAN_DFLT_MAIN_ACNT_CODE", length = 12)
	private String tranDfltMainAcntCode;

	@Column(name = "TRAN_DFLT_SUB_ACNT_CODE", length = 12)
	private String tranDfltSubAcntCode;

	@Column(name = "TRAN_DFLT_CHRG_ACNT_CODE", length = 12)
	private String tranDfltChrgAcntCode;

	@Column(name = "TRAN_FREEZ_YN", length = 1)
	private String tranFreezYn;

	@Temporal(TemporalType.DATE)
	@Column(name = "TRAN_FREEZ_DT")
	private Date tranFreezDt;

	@Column(name = "TRAN_CR_UID", length = 12)
	private String tranCrUid;

	@Temporal(TemporalType.DATE)
	@Column(name = "TRAN_CR_DT")
	private Date tranCrDt;

	@Column(name = "TRAN_UPD_UID", length = 12)
	private String tranUpdUid;

	@Temporal(TemporalType.DATE)
	@Column(name = "TRAN_UPD_DT")
	private Date tranUpdDt;

	@Column(name = "TRAN_FLEX_01", length = 240)
	private String tranFlex01;

	@Column(name = "TRAN_FLEX_02", length = 240)
	private String tranFlex02;

	@Column(name = "TRAN_FLEX_03", length = 240)
	private String tranFlex03;

	@Column(name = "TRAN_FLEX_04", length = 240)
	private String tranFlex04;

	@Column(name = "TRAN_FLEX_05", length = 240)
	private String tranFlex05;

	@Column(name = "TRAN_FLEX_06", length = 240)
	private String tranFlex06;

	@Column(name = "TRAN_FLEX_07", length = 240)
	private String tranFlex07;

	@Column(name = "TRAN_FLEX_08", length = 240)
	private String tranFlex08;

	@Column(name = "TRAN_FLEX_09", length = 240)
	private String tranFlex09;

	@Column(name = "TRAN_FLEX_10", length = 240)
	private String tranFlex10;
	
	@Transient
	private Boolean create;

	// --- ENTITY LINKS ( RELATIONSHIP )

}
