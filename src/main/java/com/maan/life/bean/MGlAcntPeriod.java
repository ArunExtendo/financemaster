
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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maan.life.util.Constants;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Domain class for entity "MGlAcntPeriod"
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
@IdClass(MGlAcntPeriodId.class)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "M_GL_ACNT_PERIOD")
public class MGlAcntPeriod implements Serializable {

	private static final long serialVersionUID = 1L;

	// --- ENTITY PRIMARY KEY
	@Id
	@NotNull(message = "Company code is required")
	@Size(max = 12, message = "Company code must be within 12 character")
	@Column(name = "AP_COMP_CODE", nullable = false, length = 12)
	private String apCompCode;

	@Id
	@Column(name = "AP_ACNT_YEAR", nullable = false)
	private BigDecimal apAcntYear;

	@Id
	@Column(name = "AP_CAL_YEAR", nullable = false)
	private BigDecimal apCalYear;

	@Id
	@Column(name = "AP_CAL_MONTH", nullable = false)
	private BigDecimal apCalMonth;

	// --- ENTITY DATA FIELDS
	@JsonFormat(pattern = Constants.DATE_FORMAT_PATTERN)
	@Temporal(TemporalType.DATE)
	@Column(name = "AP_FM_DT")
	private Date apFmDt;

	@JsonFormat(pattern = Constants.DATE_FORMAT_PATTERN)
	@Temporal(TemporalType.DATE)
	@Column(name = "AP_TO_DT")
	private Date apToDt;

	@Column(name = "AP_QTLY")
	private BigDecimal apQtly;

	@CreatedBy
	@Size(max = 12, message = "Created By must be within 1 character")
	@Column(name = "AP_CR_UID", length = 12)
	private String apCrUid;

	@CreatedDate
	 @JsonFormat(pattern = Constants.DATE_FORMAT_PATTERN)
	@Column(name = "AP_CR_DT", nullable = false, updatable = false)
	private LocalDateTime apCrDt;

	@LastModifiedBy
	@Size(max = 12, message = "Updated By must be within 12 character")
	@Column(name = "AP_UPD_UID", length = 12)
	private String apUpdUid;

	@LastModifiedDate
	@JsonFormat(pattern = Constants.DATE_FORMAT_PATTERN)
	@Column(name = "AP_UPD_DT")
	private LocalDateTime apUpdDt;

	@Transient
	private Boolean create = false;

	// --- ENTITY LINKS ( RELATIONSHIP )

}
