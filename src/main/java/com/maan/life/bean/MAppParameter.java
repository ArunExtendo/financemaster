/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2022-05-02 ( Date ISO 2022-05-02 - Time 15:41:57 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-05-02 ( 15:41:57 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */

package com.maan.life.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Domain class for entity "MAppParameter"
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
@IdClass(MAppParameterId.class)
@Table(name = "M_APP_PARAMETER")

public class MAppParameter implements Serializable {

	private static final long serialVersionUID = 1L;

	// --- ENTITY PRIMARY KEY
	@Id
	@NotEmpty(message = "Para code is required")
	@Size(max = 12, message = "Para code is a 12 Character")
	@Column(name = "PARA_CODE", nullable = false, length = 12)
	private String paraCode;

	@Id
	@NotEmpty(message = "Para sub code is required")
	@Size(max = 12, message = "Para sub code is a 12 Character")
	@Column(name = "PARA_SUB_CODE", nullable = false, length = 12)
	private String paraSubCode;

	// --- ENTITY DATA FIELDS
	@Column(name = "PARA_NAME", length = 240)
	private String paraName;

	@Column(name = "PARA_NAME_BL", length = 240)
	private String paraNameBl;

	@Column(name = "PARA_VALUE", length = 240)
	private String paraValue;

	@Column(name = "PARA_REMARK", length = 4000)
	private String paraRemark;

	@Column(name = "PARA_REMARK_BL", length = 4000)
	private String paraRemarkBl;

	@NotEmpty(message = "Para CrUid required")
	@Size(max = 12, message = "Para CrUid is a 12 Character")
	@Column(name = "PARA_CR_UID", nullable = false, length = 12)
	private String paraCrUid;

	@Temporal(TemporalType.DATE)
	@Column(name = "PARA_CR_DT")
	private Date paraCrDt;
	
	@Size(max = 12, message = "ParaUpd Uid is a 12 Character")
	@Column(name = "PARA_UPD_UID", length = 12)
	private String paraUpdUid;

	@Temporal(TemporalType.DATE)
	@Column(name = "PARA_UPD_DT")
	private Date paraUpdDt;

}
