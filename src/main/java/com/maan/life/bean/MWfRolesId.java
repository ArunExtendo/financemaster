/*
 * Created on 2022-05-02 ( 15:42:51 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.maan.life.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Composite primary key for entity "MWfRoles" ( stored in table "M_WF_ROLES" )
 *
 * @author Kamalakannan Rameshbabu
 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class MWfRolesId implements Serializable {

	private static final long serialVersionUID = 1L;

	// --- ENTITY KEY ATTRIBUTES
	private String wrRoleId;

	private String wrWorkStepCode;

	private String wrWfCode;

}