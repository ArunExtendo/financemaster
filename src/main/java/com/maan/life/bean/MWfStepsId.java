package com.maan.life.bean;

import java.io.Serializable;

/*
 * Created on 2022-05-02 ( 15:42:52 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



/**
 * Composite primary key for entity "MWfSteps" ( stored in table "M_WF_STEPS" )
 *
 * @author Sathish Subramani
 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MWfStepsId implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY KEY ATTRIBUTES 
    private String     wsWorkStepCode ;
    
    private String     wsWfCode ;
    
     
}
