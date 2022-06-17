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
import java.time.LocalDate;
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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@EntityListeners(AuditingEntityListener.class)
public class MAppParameter implements Serializable {

	private static final long serialVersionUID = 1L;

	// --- ENTITY PRIMARY KEY
	@Id
	@NotEmpty(message = "Para code is required")
	@Size(max = 12, message = "Para code must be within 12 character")
	@Column(name = "PARA_CODE", nullable = false, length = 12)
	private String paraCode;

	@Id
	@NotEmpty(message = "Para sub code is required")
	@Size(max = 12, message = "Para sub code must be within 12 character")
	@Column(name = "PARA_SUB_CODE", nullable = false, length = 12)
	private String paraSubCode;

	// --- ENTITY DATA FIELDS
	@Size(max = 240, message = "Para name must be within 240 character")
	@Column(name = "PARA_NAME", length = 240)
	private String paraName;

	@Size(max = 240, message = "Para name bl must be within 240 character")
	@Column(name = "PARA_NAME_BL", length = 240)
	private String paraNameBl;

	@Size(max = 240, message = "Para value must be within 240 character")
	@Column(name = "PARA_VALUE", length = 240)
	private String paraValue;

	@Size(max = 4000, message = "Para remark must be within 4000 character")
	@Column(name = "PARA_REMARK", length = 4000)
	private String paraRemark;

	@Size(max = 4000, message = "Para remark bl must be within 4000 character")
	@Column(name = "PARA_REMARK_BL", length = 4000)
	private String paraRemarkBl;
	
	@CreatedBy
	@Size(max = 12, message = "Para CrUid  must be within 12 character")
	@Column(name = "PARA_CR_UID", nullable = false, length = 12)
	private String paraCrUid;
     
	@CreatedDate
	@Column(name = "PARA_CR_DT")
	private LocalDateTime paraCrDt;
	
	@LastModifiedBy
	@Size(max = 12, message = "ParaUpd Uid must be within 12 character")
	@Column(name = "PARA_UPD_UID", length = 12)
	private String paraUpdUid;

	@LastModifiedDate
	@Column(name = "PARA_UPD_DT")
	private LocalDateTime paraUpdDt;
	
	@Transient
	private Boolean create =false;

}
