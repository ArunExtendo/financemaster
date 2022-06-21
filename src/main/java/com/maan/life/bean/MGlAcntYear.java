
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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Domain class for entity "MGlAcntYear"
 *
 * @author Indrabalan Ramadoss
 * 
 *         Created on 21-06-2022
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
@IdClass(MGlAcntYearId.class)
@Table(name = "M_GL_ACNT_YEAR")

public class MGlAcntYear implements Serializable {

	private static final long serialVersionUID = 1L;

	// --- ENTITY PRIMARY KEY
	@Id
	@NotNull(message = "Company code is required")
	@Size(max = 12, message = "Company code must be within 12 character")
	@Column(name = "AY_COMP_CODE", nullable = false, length = 12)
	private String ayCompCode;

	@Id
	@NotNull(message = "Account year is required")
	@Column(name = "AY_ACNT_YEAR", nullable = false)
	private BigDecimal ayAcntYear;

	// --- ENTITY DATA FIELDS
	@Size(max = 1, message = "Previous Current Next must be within 1 character")
	@Column(name = "AY_PREV_CURR_NEXT", length = 1)
	private String ayPrevCurrNext;

	@Temporal(TemporalType.DATE)
	@Column(name = "AY_FM_DT")
	private Date ayFmDt;

	@Temporal(TemporalType.DATE)
	@Column(name = "AY_TO_DT")
	private Date ayToDt;

	@Size(max = 12, message = "Main Account Code must be within 12 character")
	@Column(name = "AY_MAIN_ACNT_CODE", length = 12)
	private String ayMainAcntCode;

	@Size(max = 12, message = "Sub Account Code must be within 12 character")
	@Column(name = "AY_SUB_ACNT_CODE", length = 12)
	private String aySubAcntCode;

	@Size(max = 1, message = "Close Option  must be within 1 character")
	@Column(name = "AY_CLOSE_OPTION", nullable = false, length = 1)
	private String ayCloseOption;

	@CreatedBy
	@Size(max = 12, message = "Created By must be within 12 character")
	@Column(name = "AY_CR_UID", length = 12)
	private String ayCrUid;

	@CreatedDate
	@Column(name = "AY_CR_DT", nullable = false, updatable = false)
	private LocalDateTime ayCrDt;

	@LastModifiedBy
	@Size(max = 12, message = "Updated By must be within 12 character")
	@Column(name = "AY_UPD_UID", length = 12)
	private String ayUpdUid;

	@LastModifiedDate
	@Column(name = "AY_UPD_DT")
	private LocalDateTime ayUpdDt;
	
	@Transient
	private Boolean create =false;

	// --- ENTITY LINKS ( RELATIONSHIP )

}
