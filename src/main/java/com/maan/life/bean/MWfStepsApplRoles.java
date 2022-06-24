/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2022-05-02 ( Date ISO 2022-05-02 - Time 15:42:52 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-05-02 ( 15:42:52 )
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
 * Domain class for entity "MWfStepsApplRoles"
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
@IdClass(MWfStepsApplRolesId.class)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "M_WF_STEPS_APPL_ROLES")

public class MWfStepsApplRoles implements Serializable {

	private static final long serialVersionUID = 1L;

	// --- ENTITY PRIMARY KEY
	@Id
	@NotNull(message = "Wsar role id is required")
	@Size(max = 12, message = "Wsar role id must be within 12 character")
	@Column(name = "WSAR_ROLE_ID", nullable = false, length = 12)
	private String wsarRoleId;

	@Id
	@NotNull(message = "Wsar work step code required")
	@Size(max = 12, message = "Wsar work step code must be within 12 character")
	@Column(name = "WSAR_WORK_STEP_CODE", nullable = false, length = 12)
	private String wsarWorkStepCode;

	@Id
	@NotNull(message = "Wsar wf code required")
	@Size(max = 12, message = "Wsar wf code must be within 12 character")
	@Column(name = "WSAR_WF_CODE", nullable = false, length = 12)
	private String wsarWfCode;

	// --- ENTITY DATA FIELDS

	@CreatedBy
	@Size(max = 12, message = "Wsar crUid must be within 12 character")
	@Column(name = "WSAR_CR_UID", nullable = false, length = 12)
	private String wsarCrUid;

	@CreatedDate
	@JsonFormat(pattern = Constants.DATE_FORMAT_PATTERN)
	@Column(name = "WSAR_CR_DT", nullable = false)
	private LocalDateTime wsarCrDt;

	@LastModifiedBy
	@Column(name = "WSAR_UPD_UID", length = 12)
	private String wsarUpdUid;

	@LastModifiedDate
	@JsonFormat(pattern = Constants.DATE_FORMAT_PATTERN)
	@Column(name = "WSAR_UPD_DT")
	private LocalDateTime wsarUpdDt;

	// --- ENTITY LINKS ( RELATIONSHIP )

}
