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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Domain class for entity "MAppCodes"
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
@IdClass(MAppCodesId.class)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "M_APP_CODES")
public class MAppCodes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "AC_TYPE", nullable = false)
	@NotNull(message = "Ac type required")
	@Size(max = 12, message = "Ac type must be within 12 character")
	private String acType;

	@Id
	@Column(name = "AC_CODE", nullable = false)
	@NotNull(message = "Ac code required")
	@Size(max = 12, message = "Ac code must be within 12 character")
	private String acCode;

	@Column(name = "ac_value")
	@Size(max = 40, message = "Ac value must be within 40 character")
	private String acValue;

	@Column(name = "AC_MC_CODE")
	@Size(max = 60, message = "Ac mc code must be within 60 character")
	private String acMcCode;

	@Column(name = "AC_MAST_DEF_CODE")
	@Size(max = 60, message = "Ac mast def code must be within 60 character")
	private String acMastDefCode;

	@Column(name = "AC_DESC")
	@NotNull(message = "Ac Desc required")
	@Size(max = 240, message = "Ac desc must be within 240 character")
	private String acDesc;

	@Column(name = "AC_DESC_BL")
	@Size(max = 240, message = "Ac desc bl must be within 240 Character")
	private String acDescBl;

	@Column(name = "AC_SHORT_DESC")
	@Size(max = 60, message = "Ac short desc must be within 60 character")
	private String acShortDesc;

	@Column(name = "AC_SHORT_DESC_BL")
	@Size(max = 60, message = "Ac short desc bl must be within 60 character")
	private String acShortDescBl;

	@Column(name = "AC_LONG_DESC")
	@Size(max = 4000, message = "Ac long desc must be within 4000 character")
	private String  acLongDesc;

	@Column(name = "AC_LONG_DESC_BL")
	@Size(max = 4000, message = " Ac long desc bl must be within 4000 character")
	private String acLongDescBl;

	@Column(name = "AC_CODE_BY_LOB_YN")
	@Size(max = 1, message = "Ac code by lob yn must be within 1 character")
	@Pattern(regexp = "^[YN]$", message = "Ac code by lob yn must be either Y or N")
	private String acCodeByLobYn;

	@Column(name = "AC_LOB_CODE")
	@Size(max = 12, message = "Ac lob code must be within 12 character")
	private String acLobCode;

	@Column(name = "AC_APPL_COMP_CODE")
	@Size(max = 12, message = "Ac appl comp code must be within 12 character")
	private String acApplCompCode;

	@Temporal(TemporalType.DATE)
	@Column(name = "AC_EFF_FM_DT")
	private Date acEffFmDt;

	@Temporal(TemporalType.DATE)
	@Column(name = "AC_EFF_TO_DT")
	private Date acEffToDt;

	@CreatedBy
	@Column(name = "AC_CR_UID", nullable = false, updatable = false)
	private String acCrUid;

	@CreatedDate
	@Column(name = "AC_CR_DT", nullable = false, updatable = false)
	private LocalDateTime acCrDt;

	@LastModifiedBy
	@Column(name = "AC_UPD_UID")
	private String acUpdUid;

	@LastModifiedDate
	@Column(name = "AC_UPD_DT")
	private LocalDateTime acUpdDt;
	
	@Transient
	private Boolean create=false;
}
