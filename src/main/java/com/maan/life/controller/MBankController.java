package com.maan.life.controller;

import com.maan.life.bean.MBank;
import com.maan.life.bean.MBankAcntDtl;
import com.maan.life.dto.ListViewParam;
import com.maan.life.response.Response;
import com.maan.life.response.ResponseGenerator;
import com.maan.life.response.TransactionContext;
import com.maan.life.service.MBankService;
import com.maan.life.service.MessagePropertyService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@AllArgsConstructor(onConstructor_ = { @Autowired })
@RequestMapping("/mbank")
public class MBankController {

	@Autowired
	private MBankService bankService;
	private MessagePropertyService messageSource;

	private static final Logger logger = Logger.getLogger(MBankController.class);

	private @NonNull ResponseGenerator responseGenerator;

	@ApiOperation(value = "API to Create or Update Bank Entity", response = Response.class)
	@PostMapping(value = "/createOrUpdate", produces = "application/json")
	public ResponseEntity<?> createOrUpdate(
			@ApiParam(value = "Bank request payload") @Valid @RequestBody MBank request,
			@RequestHeader HttpHeaders httpHeader) throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);
		try {
			bankService.saveorupdate(request);
			return responseGenerator.successResponse(context, messageSource.getMessage("saved"), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in createOrupdate" + e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}



	@ApiOperation(value = "Allows to fetch Bank entities to populate on Grid.", response = Response.class)
	@PostMapping(value = "/getAll", produces = "application/json")
	public ResponseEntity<?> getAll(@RequestBody ListViewParam request, @RequestHeader HttpHeaders httpHeader)
			throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);

		try {
			List<MBank> obj = new ArrayList<MBank>();
			Page<MBank> list = null;
			list = bankService.getAll(request);
			obj = list.getContent();
			Map<String, Object> response = new HashMap<>();
			response.put("data", obj);
			response.put("currentPage", list.getNumber());
			response.put("totalItems", list.getTotalElements());
			response.put("totalPages", list.getTotalPages());
			return responseGenerator.successGetResponse(context, messageSource.getMessage("fetched"), response,
					HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in getAll for Grid list" + e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@ApiOperation(value = "API to Create or Update Bank Account Entity", response = Response.class)
	@PostMapping(value = "/account/createOrUpdate", produces = "application/json")
	public ResponseEntity<?> createOrUpdateAccount(
			@ApiParam(value = "Bank Account request payload") @Valid @RequestBody MBankAcntDtl request,
			@RequestHeader HttpHeaders httpHeader) throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);
		try {
			bankService.createOrUpdateAccount(request);
			return responseGenerator.successResponse(context, messageSource.getMessage("saved"), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in createOrupdate" + e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}



	@ApiOperation(value = "Allows to fetch Bank Account entities to populate on Grid.", response = Response.class)
	@PostMapping(value = "/account/getAll", produces = "application/json")
	public ResponseEntity<?> getBankAccountList(@RequestBody ListViewParam request, @RequestHeader HttpHeaders httpHeader)
			throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);

		try {

			Page<MBankAcntDtl> list = bankService.getBankAccountList(request);
			List<MBankAcntDtl> obj = list.getContent();
			Map<String, Object> response = new HashMap<>();
			response.put("data", obj);
			response.put("currentPage", list.getNumber());
			response.put("totalItems", list.getTotalElements());
			response.put("totalPages", list.getTotalPages());
			return responseGenerator.successGetResponse(context, messageSource.getMessage("fetched"), response,
					HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in getAll for Grid list" + e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

}
