/* 
 *  Copyright (c) 2019. All right reserved
 * Created on 2022-05-02 ( Date ISO 2022-05-02 - Time 15:42:05 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-05-02 ( 15:42:05 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */

package com.maan.life.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maan.life.util.Constants;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Domain class for entity "MCustApplComp"
 *
 * @author Thamizhazhagan Velayudham Tools Generator
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
@IdClass(MCustApplCompId.class)
@Table(name = "M_CUST_APPL_COMP")
@EntityListeners(AuditingEntityListener.class)
public class MCustApplComp implements Serializable {

	private static final long serialVersionUID = 1L;

	// --- ENTITY PRIMARY KEY
	@Id
	@NotEmpty(message = "Cacm comp code is required")
	@Size(max = 12, message = "Cacm comp code must be within 12 character")
	@Column(name = "CACM_COMP_CODE", nullable = false, length = 12)
	private String cacmCompCode;

	@Id
	@NotEmpty(message = "Cacm cust code is required")
	@Size(max = 12, message = "Cacm cust code must be within 12 character")
	@Column(name = "CACM_CUST_CODE", nullable = false, length = 12)
	private String cacmCustCode;

	@Id
	@NotEmpty(message = "Cacm divn code fm is required")
	@Size(max = 12, message = "Cacm divn code fm must be within 12 character")
	@Column(name = "CACM_DIVN_CODE_FM", nullable = false, length = 12)
	private String cacmDivnCodeFm;

	@Id
	@NotEmpty(message = "Cacm divn code to is required")
	@Size(max = 12, message = "Cacm divn code to must be within 12 character")
	@Column(name = "CACM_DIVN_CODE_TO", nullable = false, length = 12)
	private String cacmDivnCodeTo;

	@Id
	@NotEmpty(message = "Cacm dept code fm is required")
	@Size(max = 12, message = "Cacm dept code fm must be within 12 character")
	@Column(name = "CACM_DEPT_CODE_FM", nullable = false, length = 12)
	private String cacmDeptCodeFm;

	@Id
	@NotEmpty(message = "Cacm dpt code to is required")
	@Size(max = 12, message = "Cacm dept code to must be within 12 character")
	@Column(name = "CACM_DEPT_CODE_TO", nullable = false, length = 12)
	private String cacmDeptCodeTo;

	// --- ENTITY DATA FIELDS
	@Column(name = "CACM_EFF_FM_DT")
	private Date cacmEffFmDt;

	@Column(name = "CACM_EFF_TO_DT")
	private Date cacmEffToDt;

	@CreatedBy
	@Column(name = "CACM_CR_UID", nullable = false, updatable = false, length = 12)
	private String cacmCrUid;

	@CreatedDate
	@JsonFormat(pattern = Constants.DATE_FORMAT_PATTERN)
	@Column(name = "CACM_CR_DT", nullable = false, updatable = false)
	private LocalDateTime cacmCrDt;

	@LastModifiedBy
	@Column(name = "CACM_UPD_UID", length = 12)
	private String cacmUpdUid;

	@LastModifiedDate
	@JsonFormat(pattern = Constants.DATE_FORMAT_PATTERN)
	@Column(name = "CACM_UPD_DT")
	private LocalDateTime cacmUpdDt;

	// --- ENTITY LINKS ( RELATIONSHIP )

}