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
import java.math.BigDecimal;
import java.time.LocalDate;

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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maan.life.util.Constants;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Domain class for entity "MWfSteps"
 *
 * @author Sathish Subramani
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
@IdClass(MWfStepsId.class)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "M_WF_STEPS")
public class MWfSteps implements Serializable {

	private static final long serialVersionUID = 1L;

	// --- ENTITY PRIMARY KEY
	@Id
	@NotNull(message = "Ws work step code required")
	@Size(max = 12, message = "Ws work step code must be within 12 character")
	@Column(name = "WS_WORK_STEP_CODE", nullable = false, length = 12)
	private String wsWorkStepCode;

	@Id
	@NotNull(message = "Ws wf code required")
	@Size(max = 12, message = "Ws wf code must be within 12 character")
	@Column(name = "WS_WF_CODE", nullable = false, length = 12)
	private String wsWfCode;

	// --- ENTITY DATA FIELDS
	@Size(max = 240, message = "Ws work step name must be within 240 character")
	@Column(name = "WS_WORK_STEP_NAME", nullable = false, length = 240)
	private String wsWorkStepName;

	@Size(max = 12, message = "Ws work step owner must be within 12 character")
	@Column(name = "WS_WORK_STEP_OWNER", nullable = false, length = 12)
	private String wsWorkStepOwner;

	@Size(max = 12, message = "Ws work step handler must be within 12 character")
	@Column(name = "WS_WORK_STEP_HANDLER", length = 12)
	private String wsWorkStepHandler;

	@Size(max = 12, message = "Ws remind freq must be within 12 character")
	@Column(name = "WS_REMIND_FREQ", length = 12)
	private String wsRemindFreq;

	@Column(name = "WS_REMIND_TIME")
	private BigDecimal wsRemindTime;

	@Size(max = 12, message = "Ws escalation freq must be within 12 character")
	@Column(name = "WS_ESCALATION_FREQ", length = 12)
	private String wsEscalationFreq;

	@Column(name = "WS_ESCALATION_TIME")
	private BigDecimal wsEscalationTime;

	@Size(max = 12, message = "Ws auto fwd freq must be within 12 character")
	@Column(name = "WS_AUTO_FWD_FREQ", length = 12)
	private String wsAutoFwdFreq;

	@Column(name = "WS_AUTO_FWD_TIME")
	private BigDecimal wsAutoFwdTime;

	@Column(name = "WS_AUTO_FWD_STEP")
	private BigDecimal wsAutoFwdStep;

	@Size(max = 240, message = "Ws app url must be within 240 character")
	@Column(name = "WS_APPL_URL", nullable = false, length = 240)
	private String wsApplUrl;

	@CreatedBy
	@Size(max = 12, message = "Ws cr uid must be within 12 character")
	@Column(name = "WS_CR_UID", nullable = false, updatable = false, length = 12)
	private String wsCrUid;

	@CreatedDate
	@JsonFormat(pattern = Constants.DATE_FORMAT_PATTERN)
	@Column(name = "WS_CR_DT", nullable = false, updatable = false)
	private LocalDate wsCrDt;

	@LastModifiedBy
	@Size(max = 12, message = "Ws upd uid freq must be within 12 character")
	@Column(name = "WS_UPD_UID", length = 12)
	private String wsUpdUid;

	@LastModifiedDate
	@JsonFormat(pattern = Constants.DATE_FORMAT_PATTERN)
	@Column(name = "WS_UPD_DT")
	private LocalDate wsUpdDt;

	@Transient
	private Boolean create = false;

	// --- ENTITY LINKS ( RELATIONSHIP )

}
