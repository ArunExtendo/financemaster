package com.maan.life.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.security.auth.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maan.life.advice.ObjectInvalidException;
import com.maan.life.bean.MCompany;
import com.maan.life.dto.MCompanyDto;
import com.maan.life.service.MCompanyService;
import com.maan.life.util.ValidationUtil;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@Service
@AllArgsConstructor(onConstructor_ = { @Autowired })
public class MCompanyValidator {

	List<String> errors = null;
	List<String> errorsObj = null;
	Optional<Subject> subject = null;

	private @NonNull MCompanyService companyService;

	public ValidationResult validate(MCompanyDto request) {

		errors = new ArrayList<>();
		MCompany obj = null;

		if (ValidationUtil.isNull(request.getCompCode())) {
			throw new ObjectInvalidException("Company Code is required");

		} else if (ValidationUtil.isValidLength(request.getCompCode(), 12)) {
			throw new ObjectInvalidException("Company Code length should be 12");
		} else {
			request.setCompCode(request.getCompCode());
		}

		Optional<MCompany> lobOptional = companyService.findByCompCode(request.getCompCode());

		if (request.getCheck() != null) {
			if (lobOptional.isPresent()) {

				throw new ObjectInvalidException("Already Exist");
			}

		} else {
			if (lobOptional.isPresent()) {

				obj = lobOptional.get();
			}

		}

		if (ValidationUtil.isNull(request.getCompName())) {
			throw new ObjectInvalidException("Company name is required");
		}
		if (ValidationUtil.isValidLength(request.getCompName(), 240)) {
			errors.add("Company Name length should be 240");
		} else {
			request.setCompName(request.getCompName());
		}

		if (ValidationUtil.isValidLength(request.getCompDfltDivnCode(), 12)) {
			errors.add("Division Code length should be 12");
		} else {
			request.setCompDfltDivnCode(request.getCompDfltDivnCode());
		}

		if (ValidationUtil.isValidLength(request.getCompDfltDeptCode(), 12)) {
			errors.add("Dept Code length should be 12");
		} else {
			request.setCompDfltDeptCode(request.getCompDfltDeptCode());
		}

		if (ValidationUtil.isValidLength(request.getCompBaseCurrCode1(), 12)) {
			errors.add("Curr Code1 length should be 12");
		} else {
			request.setCompBaseCurrCode1(request.getCompBaseCurrCode1());
		}

		if (ValidationUtil.isValidLength(request.getCompBaseCurrCode2(), 12)) {
			errors.add("Curr Code2 length should be 12");
		} else {
			request.setCompBaseCurrCode2(request.getCompBaseCurrCode2());
		}

		if (ValidationUtil.isValidLength(request.getCompBaseCurrCode3(), 12)) {
			errors.add("Curr Code3 length should be 12");
		} else {
			request.setCompBaseCurrCode3(request.getCompBaseCurrCode3());
		}

		if (ValidationUtil.isValidLength(request.getCompFrzFlag(), 1)) {
			errors.add("Flag length should be 1");
		} else {
			request.setCompFrzFlag(request.getCompFrzFlag());
		}

		if (ValidationUtil.isValidLength(request.getCompRoundOff(), 9)) {
			errors.add("Round Off Value should be 1-9");
		} else {
			request.setCompRoundOff(request.getCompRoundOff());
		}

		if (ValidationUtil.isValidLength(request.getCompShortName(), 30)) {
			errors.add("Company ShortName length should be 30");
		} else {
			request.setCompShortName(request.getCompShortName());
		}

		if (ValidationUtil.isValidLength(request.getCompLogo(), 60)) {
			errors.add("Company Logo length should be 12");
		} else {
			request.setCompLogo(request.getCompLogo());
		}
		if (ValidationUtil.isValidLength(request.getCompAdd1(), 240)) {
			errors.add("Company Add1 length should be 240");
		} else {
			request.setCompAdd1(request.getCompAdd1());
		}
		if (ValidationUtil.isValidLength(request.getCompAdd2(), 240)) {
			errors.add("Company Add2 length should be 240");
		} else {
			request.setCompAdd2(request.getCompAdd2());
		}
		if (ValidationUtil.isValidLength(request.getCompAdd3(), 240)) {
			errors.add("Company Add3 length should be 240");
		} else {
			request.setCompAdd3(request.getCompAdd3());
		}
		if (ValidationUtil.isValidLength(request.getCompBlName(), 240)) {
			errors.add("Company BlName length should be 240");
		} else {
			request.setCompBlName(request.getCompBlName());
		}
		if (ValidationUtil.isValidLength(request.getCompBlShortName(), 30)) {
			errors.add("Company BlShortName length should be 30");
		} else {
			request.setCompBlShortName(request.getCompBlShortName());
		}
		if (ValidationUtil.isValidLength(request.getCompBlAdd1(), 240)) {
			errors.add("Company BlAdd1 length should be 240");
		} else {
			request.setCompBlAdd1(request.getCompBlAdd1());
		}
		if (ValidationUtil.isValidLength(request.getCompBlAdd2(), 240)) {
			errors.add("Company Bl Add2 length should be 240");
		} else {
			request.setCompBlAdd2(request.getCompBlAdd2());
		}
		if (ValidationUtil.isValidLength(request.getCompBlAdd3(), 240)) {
			errors.add("Company Bl Add3 length should be 240");
		} else {
			request.setCompBlAdd3(request.getCompBlAdd3());
		}
		if (ValidationUtil.isValidLength(request.getCompUnitName(), 240)) {
			errors.add("Company Unit name length should be 240");
		} else {
			request.setCompUnitName(request.getCompUnitName());
		}
		if (ValidationUtil.isValidLength(request.getCompEmailId(), 60)) {
			errors.add("Email length should be 60");
		} else {
			request.setCompEmailId(request.getCompEmailId());
		}
		if (ValidationUtil.isValidLength(request.getCompTelNo(), 60)) {
			errors.add("Company TelNo length should be 60");
		} else {
			request.setCompTelNo(request.getCompTelNo());
		}
		if (ValidationUtil.isValidLength(request.getCompFaxNo(), 60)) {
			errors.add("Company FaxNo length should be 60");
		} else {
			request.setCompFaxNo(request.getCompFaxNo());
		}
		if (ValidationUtil.isValidLength(request.getCompTheme(), 60)) {
			errors.add("Company Theme length should be 60");
		} else {
			request.setCompTheme(request.getCompTheme());
		}
		if (ValidationUtil.isValidLength(request.getCompRegNo(), 240)) {
			errors.add("Company RegNo length should be 240");
		} else {
			request.setCompRegNo(request.getCompRegNo());
		}
		if (ValidationUtil.isValidLength(request.getCompTradeRefNo(), 240)) {
			errors.add("Company TradeRefNo length should be 240");
		} else {
			request.setCompTradeRefNo(request.getCompTradeRefNo());
		}

		ValidationResult result = new ValidationResult();
		if (errors.size() > 0) {
			String errorMessage = errors.stream().map(a -> String.valueOf(a)).collect(Collectors.joining(", "));
			throw new ObjectInvalidException(errorMessage);
		}

		if (null == obj) {

			obj = MCompany.builder().compCode(request.getCompCode()).compName(request.getCompName())
					.compShortName(request.getCompShortName()).compLogo(request.getCompLogo())
					.compAdd1(request.getCompAdd1()).compAdd2(request.getCompAdd2()).compAdd3(request.getCompAdd3())
					.compDfltDivnCode(request.getCompDfltDivnCode()).compDfltDeptCode(request.getCompDfltDeptCode())
					.compBlName(request.getCompBlName()).compBlShortName(request.getCompBlShortName())
					.compBlAdd1(request.getCompBlAdd1()).compBlAdd2(request.getCompBlAdd2())
					.compBlAdd3(request.getCompBlAdd3()).compFrzFlag(request.getCompFrzFlag())
					.compBaseCurrCode1(request.getCompBaseCurrCode1()).compBaseCurrCode2(request.getCompBaseCurrCode2())
					.compBaseCurrCode3(request.getCompBaseCurrCode3()).compRoundOff(request.getCompRoundOff())
					.compUnitName(request.getCompUnitName()).compEmailId(request.getCompEmailId())
					.compTelNo(request.getCompTelNo()).compFaxNo(request.getCompFaxNo())
					.compTheme(request.getCompTheme()).compRegNo(request.getCompRegNo())
					.compTradeRefNo(request.getCompTradeRefNo()).build();

		} else {
			obj.setCompCode(request.getCompCode());
			obj.setCompName(request.getCompName());
			obj.setCompShortName(request.getCompShortName());
			obj.setCompLogo(request.getCompLogo());
			obj.setCompAdd1(request.getCompAdd1());
			obj.setCompAdd2(request.getCompAdd2());
			obj.setCompAdd3(request.getCompAdd3());
			obj.setCompDfltDivnCode(request.getCompDfltDivnCode());
			obj.setCompDfltDeptCode(request.getCompDfltDeptCode());
			obj.setCompBlName(request.getCompBlName());
			obj.setCompBlShortName(request.getCompBlShortName());
			obj.setCompBlAdd1(request.getCompBlAdd1());
			obj.setCompBlAdd2(request.getCompBlAdd2());
			obj.setCompBlAdd3(request.getCompBlAdd3());
			obj.setCompFrzFlag(request.getCompFrzFlag());
			obj.setCompBaseCurrCode1(request.getCompBaseCurrCode1());
			obj.setCompBaseCurrCode2(request.getCompBaseCurrCode2());
			obj.setCompBaseCurrCode3(request.getCompBaseCurrCode3());
			obj.setCompRoundOff(request.getCompRoundOff());
			obj.setCompUnitName(request.getCompUnitName());
			obj.setCompEmailId(request.getCompEmailId());
			obj.setCompTelNo(request.getCompTelNo());
			obj.setCompFaxNo(request.getCompFaxNo());
			obj.setCompTheme(request.getCompTheme());
			obj.setCompRegNo(request.getCompRegNo());
			obj.setCompTradeRefNo(request.getCompTradeRefNo());

		}

		result.setObject(obj);
		return result;
	}

}
