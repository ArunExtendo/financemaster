/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2022-05-02 ( Date ISO 2022-05-02 - Time 15:42:12 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-05-02 ( 15:42:12 )
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
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Domain class for entity "MExchangeRate"
 *
 * @author Thamizhazhagan Velayudham
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
@IdClass(MExchangeRateId.class)
@Table(name = "M_EXCHANGE_RATE")
@EntityListeners(AuditingEntityListener.class)
public class MExchangeRate implements Serializable {

	private static final long serialVersionUID = 1L;

	// --- ENTITY PRIMARY KEY
	@Id
	@Temporal(TemporalType.DATE)
	@Column(name = "ER_EFF_FRM_DT", nullable = false)
	private Date erEffFrmDt;

	@Id
	@Temporal(TemporalType.DATE)
	@Column(name = "ER_EFF_TO_DT", nullable = false)
	private Date erEffToDt;

	@Id
	@NotEmpty(message = "Er conv fm curr code is required")
	@Size(max = 12, message = "Er conv fm curr code must be within 12 character")
	@Column(name = "ER_CONV_FM_CURR_CODE", nullable = false, length = 12)
	private String erConvFmCurrCode;

	@Id
	@NotEmpty(message = "Er conv to curr code is required")
	@Size(max = 12, message = "Er conv to curr code must be within 12 character")
	@Column(name = "ER_CONV_TO_CURR_CODE", nullable = false, length = 12)
	private String erConvToCurrCode;

	@Id
	@NotEmpty(message = "Er rate is required")
	@Size(max = 12, message = "Er rate for must be within 12 character")
	@Column(name = "ER_RATE_FOR", nullable = false, length = 12)
	private String erRateFor;

	// --- ENTITY DATA FIELDS
	@Column(name = "ER_BUY_RATE")
	private BigDecimal erBuyRate;

	@Column(name = "ER_SEL_RATE")
	private BigDecimal erSelRate;

	@CreatedBy
	@Size(max = 12, message = "Er crUid must be within 12 character")
	@Column(name = "ER_CR_UID",updatable = false, length = 12)
	private String erCrUid;

	@CreatedDate
	@Column(name = "ER_CR_DT",updatable = false)
	private LocalDateTime erCrDt;

	@LastModifiedBy
	@Size(max = 12, message = "Er upd uid must be within 12 character")
	@Column(name = "ER_UPD_UID", length = 12)
	private String erUpdUid;

	@LastModifiedDate
	@Column(name = "ER_UPD_DT")
	private LocalDateTime erUpdDt;

	@Transient
	private Boolean create =false;

	// --- ENTITY LINKS ( RELATIONSHIP )

}
