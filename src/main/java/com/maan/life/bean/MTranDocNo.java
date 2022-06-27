package com.maan.life.bean;

import java.io.Serializable;
import java.time.LocalDateTime;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Domain class for entity "MTranDocNo"
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
@IdClass(MTranDocNoId.class)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "M_TRAN_DOC_NO")
public class MTranDocNo implements Serializable {

	private static final long serialVersionUID = 1L;

	// --- ENTITY PRIMARY KEY
	@Id
	@NotNull(message = "Tdn doc type required")
	@Size(max = 12, message = "Tdn doc type must be within 12 character")
	@Column(name = "TDN_DOC_TYPE", nullable = false, length = 12)
	private String tdnDocType;

	@Id
	@NotNull(message = "Tdn comp code required")
	@Size(max = 12, message = "Tdn comp code must be within 12 character")
	@Column(name = "TDN_COMP_CODE", nullable = false, length = 12)
	private String tdnCompCode;

	@Id
	@NotNull(message = "Tdn Code required")
	@Size(max = 240, message = "Tdn code must be within 240 character")
	@Column(name = "TDN_CODE", nullable = false, length = 240)
	private String tdnCode;

	@Id
	@NotNull(message = "Tdn year required")
	@Column(name = "TDN_YEAR", nullable = false)
	private Double tdnYear;

	@Column(name = "TDN_FIRST_NO")
	private Double tdnFirstNo;

	@Column(name = "TDN_LAST_NO")
	private Double tdnLastNo;

	@Column(name = "TDN_CURR_NO")
	private Double tdnCurrNo;

	@Size(max = 12, message = "Tdn divn code must be within 12 character")
	@Column(name = "TDN_DIVN_CODE", nullable = false, length = 12)
	private String tdnDivnCode;

	@Size(max = 12, message = "Tdn dept code must be within 12 character")
	@Column(name = "TDN_DEPT_CODE", length = 12)
	private String tdnDeptCode;

	@CreatedBy
	@Size(max = 12, message = "Tdn cr uid must be within 12 character")
	@Column(name = "TDN_CR_UID", nullable = false, length = 12, updatable = false)
	private String tdnCrUid;

	@CreatedDate
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_FORMAT_PATTERN)
	@Column(name = "TDN_CR_DT", nullable = false, updatable = false)
	private LocalDateTime tdnCrDt;

	@LastModifiedBy
	@Size(max = 12, message = "Tdn upd uid must be within 12 character")
	@Column(name = "TDN_UPD_UID", nullable = false, length = 12)
	private String tdnUpdUid;

	@LastModifiedDate
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_FORMAT_PATTERN)
	@Column(name = "TDN_UPD_DT", nullable = false)
	private LocalDateTime tdnUpdDt;

	@Transient
	private Boolean create = false;

}

