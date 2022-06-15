package com.maan.life.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
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
 * Domain class for entity "MCompany"
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
@Table(name = "M_COMPANY")
@EntityListeners(AuditingEntityListener.class)
public class MCompany implements Serializable {

	private static final long serialVersionUID = 1L;

	// --- ENTITY PRIMARY KEY
	@Id
	@NotEmpty(message = "Comp code is required")
	@Size(max = 12, message = "Comp code must be within 12 character")
	@Column(name = "COMP_CODE", nullable = false, length = 12)
	private String compCode;

	// --- ENTITY DATA FIELDS
	@Size(max = 240, message = "Comp name must be within 240 character")
	@Column(name = "COMP_NAME", length = 240)
	private String compName;

	@Size(max = 30, message = "Comp short name must be within 30 character")
	@Column(name = "COMP_SHORT_NAME", length = 30)
	private String compShortName;

	@Size(max = 60, message = "Comp logo must be within 60 character")
	@Column(name = "COMP_LOGO", length = 60)
	private String compLogo;

	@Size(max = 240, message = "Comp add1 must be within 240 character")
	@Column(name = "COMP_ADD_1", length = 240)
	private String compAdd1;

	@Size(max = 240, message = "Comp add2 must be within 240 character")
	@Column(name = "COMP_ADD_2", length = 240)
	private String compAdd2;

	@Size(max = 240, message = "Comp add3 must be within 240 character")
	@Column(name = "COMP_ADD_3", length = 240)
	private String compAdd3;

	@Size(max = 12, message = "Comp dflt divn code must be within 12 character")
	@Column(name = "COMP_DFLT_DIVN_CODE", length = 12)
	private String compDfltDivnCode;

	@Size(max = 12, message = "Comp dflt dept code be within 12 character")
	@Column(name = "COMP_DFLT_DEPT_CODE", length = 12)
	private String compDfltDeptCode;

	@Size(max = 240, message = "Comp bl name must be within 240 character")
	@Column(name = "COMP_BL_NAME", length = 240)
	private String compBlName;

	@Size(max = 30, message = "Comp bl short name must be within 30 character")
	@Column(name = "COMP_BL_SHORT_NAME", length = 30)
	private String compBlShortName;

	@Size(max = 240, message = "Comp bl add1 must be within 240 character")
	@Column(name = "COMP_BL_ADD_1", length = 240)
	private String compBlAdd1;

	@Size(max = 240, message = "Comp bl add2 must be within 240 character")
	@Column(name = "COMP_BL_ADD_2", length = 240)
	private String compBlAdd2;

	@Size(max = 240, message = "Comp bl add3 must be within 240 character")
	@Column(name = "COMP_BL_ADD_3", length = 240)
	private String compBlAdd3;

	@Size(max = 1, message = "Comp frz flag must be within 1 character")
	@Column(name = "COMP_FRZ_FLAG", length = 1)
	private String compFrzFlag;

	@Size(max = 12, message = "Comp base curr code1 must be within 12 character")
	@Column(name = "COMP_BASE_CURR_CODE_1", length = 12)
	private String compBaseCurrCode1;

	@Size(max = 12, message = "Comp base curr code2 must be within 12 character")
	@Column(name = "COMP_BASE_CURR_CODE_2", length = 12)
	private String compBaseCurrCode2;

	@Column(name = "COMP_ROUND_OFF")
	private BigDecimal compRoundOff;

	@Size(max = 240, message = "Comp unit name must be within 240 character")
	@Column(name = "COMP_UNIT_NAME", length = 240)
	private String compUnitName;

	@Size(max = 60, message = "Comp email id must be within 60 character")
	@Column(name = "COMP_EMAIL_ID", length = 60)
	private String compEmailId;

	@Size(max = 60, message = "Comp tel no must be within 60 character")
	@Column(name = "COMP_TEL_NO", length = 60)
	private String compTelNo;

	@Size(max = 60, message = "Comp fax no must be within 60 character")
	@Column(name = "COMP_FAX_NO", length = 60)
	private String compFaxNo;

	@CreatedBy
	@Size(max = 12, message = "Comp crUid must be within 12 character")
	@Column(name = "COMP_CR_UID", length = 12)
	private String compCrUid;

	@CreatedDate
	@Column(name = "COMP_CR_DT")
	private LocalDateTime compCrDt;

	@LastModifiedBy
	@Size(max = 12, message = "Comp updUid must be within 12 character")
	@Column(name = "COMP_UPD_UID", length = 12)
	private String compUpdUid;

	@LastModifiedDate
	@Column(name = "COMP_UPD_DT")
	private LocalDateTime compUpdDt;

	@Size(max = 12, message = "Comp base curr code3 must be within 12 character")
	@Column(name = "COMP_BASE_CURR_CODE_3", length = 12)
	private String compBaseCurrCode3;

	@Size(max = 240, message = "Comp reg no must be within 240 character")
	@Column(name = "COMP_REG_NO", length = 240)
	private String compRegNo;

	@Size(max = 240, message = "Comp trade ref no must be within 240 character")
	@Column(name = "COMP_TRADE_REF_NO", length = 240)
	private String compTradeRefNo;

	@Size(max = 60, message = "Comp theme must be within 60 character")
	@Column(name = "COMP_THEME", length = 60)
	private String compTheme;

	@Transient
	private Boolean create=true;

}
