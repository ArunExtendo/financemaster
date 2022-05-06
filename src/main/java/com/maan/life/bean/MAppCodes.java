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
import javax.validation.constraints.NotEmpty;
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
@IdClass(MAppCodesId.class)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "M_APP_CODES")
public class MAppCodes implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @Id
    @Column(name="AC_TYPE", nullable = false)
    @NotEmpty(message = "Ac Type required")
    @Size(max = 12, message = "Ac Type is a 12 Character")
    private String acType ;

    @Id
    @Column(name="AC_CODE", nullable = false)
    @NotEmpty(message = "Ac Code required")
    @Size(max = 12, message = "Ac Code is a 12 Character")
    private String acCode ;

    @Column(name = "ac_value")
    @Size(max = 40, message = "Ac Value is a 40 Character")
    private String acValue ;

    @Column(name="AC_MC_CODE")
    @Size(max = 60, message = "Ac Mc Code is a 60 Character")
    private String acMcCode ;

    @Column(name="AC_MAST_DEF_CODE")
    @Size(max = 60, message = "Ac Mast Def Code is a 60 Character")
    private String acMastDefCode ;

    @Column(name="AC_DESC")
    @Size(max = 240, message = "Ac Desc is a 240 Character")
    private String acDesc ;

    @Column(name="AC_DESC_BL")
    @Size(max = 240, message = "AcDescBl is a 240 Character")
    private String acDescBl ;

    @Column(name="AC_SHORT_DESC")
    @Size(max = 60, message = "Ac ShortDesc is a 60 Character")
    private String acShortDesc ;

    @Column(name="AC_SHORT_DESC_BL")
    @Size(max = 60, message = "Ac Short DescBl is a 60 Character")
    private String acShortDescBl ;

    @Column(name="AC_LONG_DESC")
    @Size(max = 4000, message = "Ac LongDesc is a 4000 Character")
    private String acLongDesc ;

    @Column(name="AC_LONG_DESC_BL")
    @Size(max = 4000, message = " Ac LongDescBl is a 4000 Character")
    private String acLongDescBl ;

    @Column(name="AC_CODE_BY_LOB_YN")
    @Size(max = 1, message = "Ac CodeByLobYn is a 1 Character")
    @Pattern(regexp = "^[YN]$", message = "Ac CodeByLobYn Must be either Y or N")
    private String acCodeByLobYn;

    @Column(name="AC_LOB_CODE")
    @Size(max = 12, message = "Ac Lob Code is a 12 Character")
    private String acLobCode ;

    @Column(name="AC_APPL_COMP_CODE")
    @Size(max = 12, message = "Ac ApplCompCode is a 12 Character")
    private String acApplCompCode ;

    @Temporal(TemporalType.DATE)
    @Column(name="AC_EFF_FM_DT")
    private Date acEffFmDt ;

    @Temporal(TemporalType.DATE)
    @Column(name="AC_EFF_TO_DT")
    private Date acEffToDt ;
	
    @CreatedBy
	@Column(name = "AC_CR_UID")
	private String acCrUid;

	@CreatedDate
	@Column(name = "AC_CR_DT")
	private LocalDateTime acCrDt;

	@LastModifiedBy
	@Column(name = "AC_UPD_UID")
	private String acUpdUid;

	@LastModifiedDate
	@Column(name = "AC_UPD_DT")
	private LocalDateTime acUpdDt;
}
