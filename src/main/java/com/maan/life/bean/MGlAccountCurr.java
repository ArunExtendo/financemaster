/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2022-05-02 ( Date ISO 2022-05-02 - Time 15:42:14 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-05-02 ( 15:42:14 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */

package com.maan.life.bean;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
 * Domain class for entity "MGlAccountCurr"
 *
 * @author Kamalakannan Rameshbabu
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
@IdClass(MGlAccountCurrId.class)
@Table(name = "M_GL_ACCOUNT_CURR")
@EntityListeners(AuditingEntityListener.class)

public class MGlAccountCurr implements Serializable {

	private static final long serialVersionUID = 1L;

	// --- ENTITY PRIMARY KEY
	@Id
	@NotNull(message = "Acurr main acnt code is required")
	@Size(max = 12, message = "Acurr main acnt code must be within 12 character")
	@Column(name = "ACURR_MAIN_ACNT_CODE", nullable = false, length = 12)
	private String acurrMainAcntCode;

	@Id
	@NotNull(message = "Acurr sub acnt code is required")
	@Size(max = 12, message = "Acurr sub acnt code must be within 12 character")
	@Column(name = "ACURR_SUB_ACNT_CODE", nullable = false, length = 12)
	private String acurrSubAcntCode;

	// --- ENTITY DATA FIELDS
	@Size(max = 12, message = "Acurr curr code must be within 12 character")
	@Column(name = "ACURR_CURR_CODE", length = 12)
	private String acurrCurrCode;

	@CreatedBy
	@Size(max = 12, message = "Acurr cr uid must be within 12 character")
	@Column(name = "ACURR_CR_UID", nullable = false, updatable = false, length = 12)
	private String acurrCrUid;

	@CreatedDate
	@JsonFormat(pattern = Constants.DATE_FORMAT_PATTERN)
	@Column(name = "ACURR_CR_DT", nullable = false, updatable = false)
	private LocalDateTime acurrCrDt;

	@LastModifiedBy
	@Size(max = 12, message = "Acurr upd uid must be within 12 character")
	@Column(name = "ACURR_UPD_UID", length = 12)
	private String acurrUpdUid;

	@LastModifiedDate
	@JsonFormat(pattern = Constants.DATE_FORMAT_PATTERN)
	@Column(name = "ACURR_UPD_DT")
	private LocalDateTime acurrUpdDt;

}
