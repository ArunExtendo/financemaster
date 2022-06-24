/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2022-05-02 ( Date ISO 2022-05-02 - Time 15:42:53 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-05-02 ( 15:42:53 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */

package com.maan.life.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
 * Domain class for entity "MWorkflow"
 *
 * @author Sundar Srini
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

@Table(name = "M_WORKFLOW")

public class MWorkflow implements Serializable {

	private static final long serialVersionUID = 1L;

	// --- ENTITY PRIMARY KEY
	@Id
	@NotNull(message = "WF code required")
	@Size(max = 12, message = "Wf code must be within 12 character")
	@Column(name = "WF_CODE", nullable = false, length = 12)
	private String wfCode;

	// --- ENTITY DATA FIELDS
	@Size(max = 240, message = "Wf desc must be within 240 character")
	@Column(name = "WF_DESC", length = 240)
	private String wfDesc;

	@Size(max = 12, message = "Wf product code must be within 12 character")
	@Column(name = "WF_PRODUCT_CODE", length = 12)
	private String wfProductCode;

	@Size(max = 12, message = "Wf module code must be within 12 character")
	@Column(name = "WF_MODULE_CODE", length = 12)
	private String wfModuleCode;

	@Size(max = 12, message = "Wf tran type must be within 12 character")
	@Column(name = "WF_TRAN_TYPE", length = 12)
	private String wfTranType;

	@Size(max = 12, message = "Wf tat freq must be within 12 character")
	@Column(name = "WF_TAT_FREQ", length = 12)
	private String wfTatFreq;

	@Column(name = "WF_TAT")
	private BigDecimal wfTat;

	@CreatedBy
	@Column(name = "WF_CR_UID", nullable = false, updatable = false, length = 12)
	private String wfCrUid;

	@CreatedDate
	@JsonFormat(pattern = Constants.DATE_FORMAT_PATTERN)
	@Column(name = "WF_CR_DT", nullable = false, updatable = false)
	private LocalDateTime wfCrDt;

	@LastModifiedBy
	@Column(name = "WF_UPD_UID", length = 12)
	private String wfUpdUid;

	@LastModifiedDate
	@JsonFormat(pattern = Constants.DATE_FORMAT_PATTERN)
	@Column(name = "WF_UPD_DT")
	private LocalDateTime wfUpdDt;

	// --- ENTITY LINKS ( RELATIONSHIP )

}
