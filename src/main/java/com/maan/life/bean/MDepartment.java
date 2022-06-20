/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2022-05-02 ( Date ISO 2022-05-02 - Time 15:42:10 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-05-02 ( 15:42:10 )
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
 * Domain class for entity "MDepartment"
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
@IdClass(MDepartmentId.class)
@Table(name = "M_DEPARTMENT")
@EntityListeners(AuditingEntityListener.class)
public class MDepartment implements Serializable {

	private static final long serialVersionUID = 1L;

	// --- ENTITY PRIMARY KEY
	@Id
	@NotEmpty(message = "Dept code is required")
	@Size(max = 12, message = "Dept code must be within 12 character")
	@Column(name = "DEPT_CODE", nullable = false, length = 12)
	private String deptCode;

	@Id
	@NotEmpty(message = "Dept divn code is required")
	@Size(max = 12, message = "Dept divn code must be within 12 character")
	@Column(name = "DEPT_DIVN_CODE", nullable = false, length = 12)
	private String deptDivnCode;

	@Id
	@NotEmpty(message = "Dept comp code is required")
	@Size(max = 12, message = "Dept comp code must be within 12 character")
	@Column(name = "DEPT_COMP_CODE", nullable = false, length = 12)
	private String deptCompCode;

	// --- ENTITY DATA FIELDS
	@Size(max = 240, message = "Dept name must be within 240 character")
	@Column(name = "DEPT_NAME", length = 240)
	private String deptName;

	@Size(max = 30, message = "Dept short name must be within 30 character")
	@Column(name = "DEPT_SHORT_NAME", length = 30)
	private String deptShortName;

	@Size(max = 5, message = "Dept header must be within 5 character")
	@Column(name = "DEPT_HEADER", length = 5)
	private String deptHeader;
	
	@Size(max = 240, message = "Dept bl name must be within 240 character")
	@Column(name = "DEPT_BL_NAME", length = 240)
	private String deptBlName;

	@Size(max = 30, message = "Dept bl short name must be within 30 character")
	@Column(name = "DEPT_BL_SHORT_NAME", length = 30)
	private String deptBlShortName;

	@Size(max = 1, message = "Dept frz flag must be within 1 character")
	@Column(name = "DEPT_FRZ_FLAG", length = 1)
	private String deptFrzFlag;

	@CreatedBy
	@Size(max = 12, message = "Dept crUid must be within 12 character")
	@Column(name = "DEPT_CR_UID", updatable = false,length = 12)
	private String deptCrUid;

	@CreatedDate
	@Column(name = "DEPT_CR_DT",updatable = false)
	private LocalDateTime deptCrDt;

	@LastModifiedDate
	@Column(name = "DEPT_UPD_DT")
	private LocalDateTime deptUpdDt;

	@LastModifiedBy
	@Size(max = 12, message = "Dept updUid must be within 12 character")
	@Column(name = "DEPT_UPD_UID", length = 12)
	private String deptUpdUid;

	// --- ENTITY LINKS ( RELATIONSHIP )
	@Transient
	private Boolean create=false;

}
