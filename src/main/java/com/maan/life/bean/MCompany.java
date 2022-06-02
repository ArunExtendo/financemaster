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
	@Column(name = "COMP_CODE", nullable = false, length = 12)
	private String compCode;

	// --- ENTITY DATA FIELDS
	@Column(name = "COMP_NAME", length = 240)
	private String compName;

	@Column(name = "COMP_SHORT_NAME", length = 30)
	private String compShortName;

	@Column(name = "COMP_LOGO", length = 60)
	private String compLogo;

	@Column(name = "COMP_ADD_1", length = 240)
	private String compAdd1;

	@Column(name = "COMP_ADD_2", length = 240)
	private String compAdd2;

	@Column(name = "COMP_ADD_3", length = 240)
	private String compAdd3;

	@Column(name = "COMP_DFLT_DIVN_CODE", length = 12)
	private String compDfltDivnCode;

	@Column(name = "COMP_DFLT_DEPT_CODE", length = 12)
	private String compDfltDeptCode;

	@Column(name = "COMP_BL_NAME", length = 240)
	private String compBlName;

	@Column(name = "COMP_BL_SHORT_NAME", length = 30)
	private String compBlShortName;

	@Column(name = "COMP_BL_ADD_1", length = 240)
	private String compBlAdd1;

	@Column(name = "COMP_BL_ADD_2", length = 240)
	private String compBlAdd2;

	@Column(name = "COMP_BL_ADD_3", length = 240)
	private String compBlAdd3;

	@Column(name = "COMP_FRZ_FLAG", length = 1)
	private String compFrzFlag;

	@Column(name = "COMP_BASE_CURR_CODE_1", length = 12)
	private String compBaseCurrCode1;

	@Column(name = "COMP_BASE_CURR_CODE_2", length = 12)
	private String compBaseCurrCode2;

	@Column(name = "COMP_ROUND_OFF")
	private BigDecimal compRoundOff;

	@Column(name = "COMP_UNIT_NAME", length = 240)
	private String compUnitName;

	@Column(name = "COMP_EMAIL_ID", length = 60)
	private String compEmailId;

	@Column(name = "COMP_TEL_NO", length = 60)
	private String compTelNo;

	@Column(name = "COMP_FAX_NO", length = 60)
	private String compFaxNo;

	@CreatedBy
	@Column(name = "COMP_CR_UID", length = 12)
	private String compCrUid;

	@CreatedDate
	@Column(name = "COMP_CR_DT")
	private LocalDateTime compCrDt;

	@LastModifiedBy
	@Column(name = "COMP_UPD_UID", length = 12)
	private String compUpdUid;

	@LastModifiedDate
	@Column(name = "COMP_UPD_DT")
	private LocalDateTime compUpdDt;

	@Column(name = "COMP_BASE_CURR_CODE_3", length = 12)
	private String compBaseCurrCode3;

	@Column(name = "COMP_REG_NO", length = 240)
	private String compRegNo;

	@Column(name = "COMP_TRADE_REF_NO", length = 240)
	private String compTradeRefNo;

	@Column(name = "COMP_THEME", length = 60)
	private String compTheme;

	@Transient
	private Boolean check;

//	// --- ENTITY LINKS ( RELATIONSHIP )
//	@OneToMany(mappedBy = "mCompany")
//	private List<MDivision> listOfMDivision;
//
//	@OneToMany(mappedBy = "mCompany")
//	private List<MProdSchemes> listOfMProdSchemes;

}
