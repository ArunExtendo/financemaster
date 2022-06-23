//package com.maan.life.dto;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//import java.util.Date;
//
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//public class MCustomerResponseDto {
//
//	private String custCode;
//
//	private String custName;
//
//	private String custNameBl;
//
//	private String custFirstName;
//
//	private String custMiddleName;
//
//	private String custLastName;
//
//	private String custTitle;
//
//	private String custShortName;
//
//	private String custShortNameBl;
//
//	private String custCcCode;
//
//	private String custCcType;
//
//	private String custPhone;
//
//	private String custPhoneBl;
//
//	private String custFax;
//
//	private String custFaxBl;
//
//	private String custMobileNo;
//
//	private String custMobileNoBl;
//
//	private String custMailingAddr;
//
//	private String custAddr01;
//
//	private String custAddr01Bl;
//
//	private String custAddr02;
//
//	private String custAddr02Bl;
//
//	private String custAddr03;
//
//	private String custAddr03Bl;
//
//	private String custArea;
//
//	private String custRegion;
//
//	private String custCity;
//
//	private String custCountry;
//
//	private String custOffAddr01;
//
//	private String custOffAddr01Bl;
//
//	private String custOffAddr02;
//	
//
//	private String custOffAddr02Bl;
//
//	private String custOffAddr03;
//
//	private String custOffAddr03Bl;
//
//	private String custOffArea;
//
//	private String custOffRegion;
//
//	private String custOffCity;
//
//	private String custOffCountry;
//
//	private String custEmail1;
//
//	private String custEmail2;
//
//	private String custWebSite;
//
//	private String custCreditChkYn;
//
//	private BigDecimal custCreditLimit;
//
//	private BigDecimal custCreditDays;
//
//	private Date custEffFmDt;
//
//	private Date custEffToDt;
//
//
//	private String custOffPhone;
//
//	private String custOffPhoneBl;
//
//	private String custOffFax;
//
//	private String custOffFaxBl;
//
//	private String custPoBox;
//
//	private String custOffPoBox;
//
//	private String custGender;
//
//	private String custMaritalSts;
//
//	private String custCivilId;
//
//	private String custNationality;
//
//	private String custOccType;
//
//	private String custLogoName;
//
//	private String custGroupCode;
//
//	private String custMakeFilterYn;
//
//	private String custBodyFilterYn;
//
//	private String custUsageFilterYn;
//
//	private String custCylFilterYn;
//
//	private String custMessage;
//
//	private LocalDateTime custCrDt;
//
//	private String custCrUid;
//
//	private LocalDateTime custUpdDt;
//
//	private String custUpdUid;
//
//	private String custDocEmailYn;
//
//	private String custGarageFilterYn;
//
//	private String custAgentPgYn;
//
//	private String custLegalSts;
//
//	private String custRegSts;
//
//	private String custNatTran;
//
//	private String custInterface;
//
//	private String custRiskLvl;
//
//	private String custRiskScore;
//
//	private String custProdCode;
//
//	private String custCollCode;
//
//	private String custHandCode;
//
//	private String custSts;
//
//	private String custContact;
//
//	private String custAmRating;
//
//	private String custSpRating;
//
//	private String custRetailType;
//
//	private String custDfltCurrCode;
//
//	private String custDfltDeptCode;
//
//	private String custDfltCostCentre;
//
//	private String custDfltTaxCode;
//
//	private String custDfltNominalCode;
//
//	private String custTaxRefNo;
//
//	private String custTaxGrpCode;
//
//	private String custSelfBillingYn;
//
//	private String custDebitYn;
//
//	private String custCompId;
//
//	private Date custCidExpDt;
//
//	private Date custTempToDt;
//
//	private String custIndClass;
//
//	private String custIdType;
//
//	private String custProdRiskScore;
//	
//	private String custJrsdRiskScore;
//
//	private String custOtherRiskScore;
//
//	private String custTotRiskScore;
//
//	private String custIntfRiskScore;
//
//	private String custAmlClass;
//
//	private String custRconPeriod;
//
//	private String custCnst;
//
//	private String custContactMobile;
//
//	private String custContactEmail;
//	
//	private String custProdRiskScoreOrdn;
//
//	private String custJrsdRiskScoreOrdn;
//
//	private String custIntfRiskScoreOrdn;
//
//	private String custOtherRiskScoreOrdn;
//
//	private String custTotRiskScoreOrdn;
//
//	private String custComplRemarks;
//
//	private String custSignComplPrsnName;
//
//	private String custRelatedPartyTran;
//
//	private String custLicIssuAuthr;
//
//	private String custCivilIdUw;
//
//	private String custContacFin;
//
//	private String custEmailIdFin;
//
//	private String custMobileFin;
//
//	private String custCivilIdFin;
//
//	private String custNameArabic;
//
//	private Date custDob;
//
//	private String group;
//	
//	private String category;
//
//	public MCustomerResponseDto(String custCode, String custName, String custNameBl, String custFirstName,
//			String custMiddleName, String custLastName, String custTitle, String custShortName, String custShortNameBl,
//			String custCcCode, String custCcType, String custPhone, String custPhoneBl, String custFax,
//			String custFaxBl, String custMobileNo, String custMobileNoBl, String custMailingAddr, String custAddr01,
//			String custAddr01Bl, String custAddr02, String custAddr02Bl, String custAddr03, String custAddr03Bl,
//			String custArea, String custRegion, String custCity, String custCountry, String custOffAddr01,
//			String custOffAddr01Bl, String custOffAddr02, String custOffAddr02Bl, String custOffAddr03,
//			String custOffAddr03Bl, String custOffArea, String custOffRegion, String custOffCity, String custOffCountry,
//			String custEmail1, String custEmail2, String custWebSite, String custCreditChkYn,
//			BigDecimal custCreditLimit, BigDecimal custCreditDays, Date custEffFmDt, Date custEffToDt,
//			String custOffPhone, String custOffPhoneBl, String custOffFax, String custOffFaxBl, String custPoBox,
//			String custOffPoBox, String custGender, String custMaritalSts, String custCivilId, String custNationality,
//			String custOccType, String custLogoName, String custGroupCode, String custMakeFilterYn,
//			String custBodyFilterYn, String custUsageFilterYn, String custCylFilterYn, String custMessage,
//			LocalDateTime custCrDt, String custCrUid, LocalDateTime custUpdDt, String custUpdUid, String custDocEmailYn,
//			String custGarageFilterYn, String custAgentPgYn, String custLegalSts, String custRegSts, String custNatTran,
//			String custInterface, String custRiskLvl, String custRiskScore, String custProdCode, String custCollCode,
//			String custHandCode, String custSts, String custContact, String custAmRating, String custSpRating,
//			String custRetailType, String custDfltCurrCode, String custDfltDeptCode, String custDfltCostCentre,
//			String custDfltTaxCode, String custDfltNominalCode, String custTaxRefNo, String custTaxGrpCode,
//			String custSelfBillingYn, String custDebitYn, String custCompId, Date custCidExpDt, Date custTempToDt,
//			String custIndClass, String custIdType, String custProdRiskScore, String custJrsdRiskScore,
//			String custOtherRiskScore, String custTotRiskScore, String custIntfRiskScore, String custAmlClass,
//			String custRconPeriod, String custCnst, String custContactMobile, String custContactEmail,
//			String custProdRiskScoreOrdn, String custJrsdRiskScoreOrdn, String custIntfRiskScoreOrdn,
//			String custOtherRiskScoreOrdn, String custTotRiskScoreOrdn, String custComplRemarks,
//			String custSignComplPrsnName, String custRelatedPartyTran, String custLicIssuAuthr, String custCivilIdUw,
//			String custContacFin, String custEmailIdFin, String custMobileFin, String custCivilIdFin,
//			String custNameArabic, Date custDob, String group, String category) {
//		super();
//		this.custCode = custCode;
//		this.custName = custName;
//		this.custNameBl = custNameBl;
//		this.custFirstName = custFirstName;
//		this.custMiddleName = custMiddleName;
//		this.custLastName = custLastName;
//		this.custTitle = custTitle;
//		this.custShortName = custShortName;
//		this.custShortNameBl = custShortNameBl;
//		this.custCcCode = custCcCode;
//		this.custCcType = custCcType;
//		this.custPhone = custPhone;
//		this.custPhoneBl = custPhoneBl;
//		this.custFax = custFax;
//		this.custFaxBl = custFaxBl;
//		this.custMobileNo = custMobileNo;
//		this.custMobileNoBl = custMobileNoBl;
//		this.custMailingAddr = custMailingAddr;
//		this.custAddr01 = custAddr01;
//		this.custAddr01Bl = custAddr01Bl;
//		this.custAddr02 = custAddr02;
//		this.custAddr02Bl = custAddr02Bl;
//		this.custAddr03 = custAddr03;
//		this.custAddr03Bl = custAddr03Bl;
//		this.custArea = custArea;
//		this.custRegion = custRegion;
//		this.custCity = custCity;
//		this.custCountry = custCountry;
//		this.custOffAddr01 = custOffAddr01;
//		this.custOffAddr01Bl = custOffAddr01Bl;
//		this.custOffAddr02 = custOffAddr02;
//		this.custOffAddr02Bl = custOffAddr02Bl;
//		this.custOffAddr03 = custOffAddr03;
//		this.custOffAddr03Bl = custOffAddr03Bl;
//		this.custOffArea = custOffArea;
//		this.custOffRegion = custOffRegion;
//		this.custOffCity = custOffCity;
//		this.custOffCountry = custOffCountry;
//		this.custEmail1 = custEmail1;
//		this.custEmail2 = custEmail2;
//		this.custWebSite = custWebSite;
//		this.custCreditChkYn = custCreditChkYn;
//		this.custCreditLimit = custCreditLimit;
//		this.custCreditDays = custCreditDays;
//		this.custEffFmDt = custEffFmDt;
//		this.custEffToDt = custEffToDt;
//		this.custOffPhone = custOffPhone;
//		this.custOffPhoneBl = custOffPhoneBl;
//		this.custOffFax = custOffFax;
//		this.custOffFaxBl = custOffFaxBl;
//		this.custPoBox = custPoBox;
//		this.custOffPoBox = custOffPoBox;
//		this.custGender = custGender;
//		this.custMaritalSts = custMaritalSts;
//		this.custCivilId = custCivilId;
//		this.custNationality = custNationality;
//		this.custOccType = custOccType;
//		this.custLogoName = custLogoName;
//		this.custGroupCode = custGroupCode;
//		this.custMakeFilterYn = custMakeFilterYn;
//		this.custBodyFilterYn = custBodyFilterYn;
//		this.custUsageFilterYn = custUsageFilterYn;
//		this.custCylFilterYn = custCylFilterYn;
//		this.custMessage = custMessage;
//		this.custCrDt = custCrDt;
//		this.custCrUid = custCrUid;
//		this.custUpdDt = custUpdDt;
//		this.custUpdUid = custUpdUid;
//		this.custDocEmailYn = custDocEmailYn;
//		this.custGarageFilterYn = custGarageFilterYn;
//		this.custAgentPgYn = custAgentPgYn;
//		this.custLegalSts = custLegalSts;
//		this.custRegSts = custRegSts;
//		this.custNatTran = custNatTran;
//		this.custInterface = custInterface;
//		this.custRiskLvl = custRiskLvl;
//		this.custRiskScore = custRiskScore;
//		this.custProdCode = custProdCode;
//		this.custCollCode = custCollCode;
//		this.custHandCode = custHandCode;
//		this.custSts = custSts;
//		this.custContact = custContact;
//		this.custAmRating = custAmRating;
//		this.custSpRating = custSpRating;
//		this.custRetailType = custRetailType;
//		this.custDfltCurrCode = custDfltCurrCode;
//		this.custDfltDeptCode = custDfltDeptCode;
//		this.custDfltCostCentre = custDfltCostCentre;
//		this.custDfltTaxCode = custDfltTaxCode;
//		this.custDfltNominalCode = custDfltNominalCode;
//		this.custTaxRefNo = custTaxRefNo;
//		this.custTaxGrpCode = custTaxGrpCode;
//		this.custSelfBillingYn = custSelfBillingYn;
//		this.custDebitYn = custDebitYn;
//		this.custCompId = custCompId;
//		this.custCidExpDt = custCidExpDt;
//		this.custTempToDt = custTempToDt;
//		this.custIndClass = custIndClass;
//		this.custIdType = custIdType;
//		this.custProdRiskScore = custProdRiskScore;
//		this.custJrsdRiskScore = custJrsdRiskScore;
//		this.custOtherRiskScore = custOtherRiskScore;
//		this.custTotRiskScore = custTotRiskScore;
//		this.custIntfRiskScore = custIntfRiskScore;
//		this.custAmlClass = custAmlClass;
//		this.custRconPeriod = custRconPeriod;
//		this.custCnst = custCnst;
//		this.custContactMobile = custContactMobile;
//		this.custContactEmail = custContactEmail;
//		this.custProdRiskScoreOrdn = custProdRiskScoreOrdn;
//		this.custJrsdRiskScoreOrdn = custJrsdRiskScoreOrdn;
//		this.custIntfRiskScoreOrdn = custIntfRiskScoreOrdn;
//		this.custOtherRiskScoreOrdn = custOtherRiskScoreOrdn;
//		this.custTotRiskScoreOrdn = custTotRiskScoreOrdn;
//		this.custComplRemarks = custComplRemarks;
//		this.custSignComplPrsnName = custSignComplPrsnName;
//		this.custRelatedPartyTran = custRelatedPartyTran;
//		this.custLicIssuAuthr = custLicIssuAuthr;
//		this.custCivilIdUw = custCivilIdUw;
//		this.custContacFin = custContacFin;
//		this.custEmailIdFin = custEmailIdFin;
//		this.custMobileFin = custMobileFin;
//		this.custCivilIdFin = custCivilIdFin;
//		this.custNameArabic = custNameArabic;
//		this.custDob = custDob;
//		this.group = group;
//		this.category = category;
//	}
//
//}
