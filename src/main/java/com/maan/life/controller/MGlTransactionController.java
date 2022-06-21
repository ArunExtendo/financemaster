package com.maan.life.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maan.life.bean.MGlAcntPeriod;
import com.maan.life.bean.MGlAcntYear;
import com.maan.life.bean.MGlTransaction;
import com.maan.life.dto.ListViewParam;
import com.maan.life.dto.MGlAcntYearDto;
import com.maan.life.response.Response;
import com.maan.life.response.ResponseGenerator;
import com.maan.life.response.TransactionContext;
import com.maan.life.service.MGIAcntYearService;
import com.maan.life.service.MGlAcntPeriodService;
import com.maan.life.service.MGlTransactionService;
import com.maan.life.service.MessagePropertyService;
import com.maan.life.util.Convention;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@AllArgsConstructor(onConstructor_ = { @Autowired })
@RequestMapping("/mgltransaction")
public class MGlTransactionController {

	@Autowired
	private MGlTransactionService entityService;
	private MessagePropertyService messageSource;
	private @NonNull ResponseGenerator responseGenerator;
	private Convention sorting;
	private MGIAcntYearService mGIAcntYearService;
	private MGlAcntPeriodService mGlAcntPeriodService;

	private static final Logger logger = Logger.getLogger(MGlTransactionController.class);

	@PostMapping(value = "/createOrUpdate", produces = "application/json")
	public ResponseEntity<?> createOrUpdate(
			@ApiParam(value = "Request payload") @Valid @RequestBody MGlTransaction request,
			@RequestHeader HttpHeaders httpHeader) throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);
		try {
			entityService.saveorupdate(request);
			return responseGenerator.successResponse(context, messageSource.getMessage("saved"), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in createOrupdate" + e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}

	}

	@ApiOperation(value = "Allows to fetch all data List.", response = Response.class)
	@GetMapping(value = "/getAll", produces = "application/json")
	public ResponseEntity<?> getAll(@RequestHeader HttpHeaders httpHeader) throws Exception {
		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);

		try {

			List<MGlTransaction> lst = entityService.getAll();
			return responseGenerator.successGetResponse(context, messageSource.getMessage("fetched"), lst,
					HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			logger.error("Error in getAll for dropdown " + e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}


	@PostMapping(value = "/createOrUpdate/year", produces = "application/json")
	public ResponseEntity<?> createOrUpdate(
			@ApiParam(value = "Request payload") @Valid @RequestBody MGlAcntYear request,
			@RequestHeader HttpHeaders httpHeader) throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);
		try {
			mGIAcntYearService.saveorupdate(request);
			return responseGenerator.successResponse(context, messageSource.getMessage("saved"), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in createOrupdate" + e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}

	}
	
	@ApiOperation(value = "Allows to fetch all data List.", response = Response.class)
	@GetMapping(value = "/getAll/year", produces = "application/json")
	public ResponseEntity<?> getAllYearList(@RequestHeader HttpHeaders httpHeader) throws Exception {
		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);

		try {

			List<MGlAcntYearDto> lst = mGIAcntYearService.getAll();
			return responseGenerator.successGetResponse(context, messageSource.getMessage("fetched"), lst,
					HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			logger.error("Error in getAll for dropdown " + e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}
	
	@ApiOperation(value = "Allows to fetch MGl AcntYear List.", response = Response.class)
	@PostMapping(value = "/getAll/year", produces = "application/json")
	public ResponseEntity<?> getAllYear(@RequestBody ListViewParam request, @RequestHeader HttpHeaders httpHeader)
			throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);
		try {
			List<MGlAcntYear> obj = new ArrayList<>();
			Page<MGlAcntYear> list = mGIAcntYearService.findAllMGlAcntYear(request);
			obj = list.getContent();
			Map<String, Object> response = new HashMap<>();
			response.put("data", obj);
			response.put("currentPage", list.getNumber());
			response.put("totalItems", list.getTotalElements());
			response.put("totalPages", list.getTotalPages());

			return responseGenerator.successGetResponse(context, messageSource.getMessage("fetched"), response,
					HttpStatus.OK);
		} catch (
		Exception e) {
			e.printStackTrace();
			logger.error("Error in getAll for Grid List" + e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}
	
	
	@PostMapping(value = "/createOrUpdate/period", produces = "application/json")
	public ResponseEntity<?> createOrUpdate(
			@ApiParam(value = "Request payload") @Valid @RequestBody MGlAcntPeriod request,
			@RequestHeader HttpHeaders httpHeader) throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);
		try {
			mGlAcntPeriodService.saveorupdate(request);
			return responseGenerator.successResponse(context, messageSource.getMessage("saved"), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in createOrupdate" + e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}

	}
	
	@ApiOperation(value = "Allows to fetch all data List.", response = Response.class)
	@GetMapping(value = "/getAll/period", produces = "application/json")
	public ResponseEntity<?> getAllPeriodList(@RequestHeader HttpHeaders httpHeader) throws Exception {
		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);

		try {

			List<MGlAcntPeriod> list = mGlAcntPeriodService.getAll();
			return responseGenerator.successGetResponse(context, messageSource.getMessage("fetched"), list,
					HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			logger.error("Error in getAll for dropdown " + e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}
	
	@ApiOperation(value = "Allows to fetch MGl Acnt Period List.", response = Response.class)
	@PostMapping(value = "/getAll/period", produces = "application/json")
	public ResponseEntity<?> getAllPeriod(@RequestBody ListViewParam request, @RequestHeader HttpHeaders httpHeader)
			throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);
		try {
			List<MGlAcntPeriod> obj = new ArrayList<>();
			Page<MGlAcntPeriod> list = mGlAcntPeriodService.findAllMGlAcntPeriod(request);
			obj = list.getContent();
			Map<String, Object> response = new HashMap<>();
			response.put("data", obj);
			response.put("currentPage", list.getNumber());
			response.put("totalItems", list.getTotalElements());
			response.put("totalPages", list.getTotalPages());

			return responseGenerator.successGetResponse(context, messageSource.getMessage("fetched"), response,
					HttpStatus.OK);
		} catch (
		Exception e) {
			e.printStackTrace();
			logger.error("Error in getAll for Grid List" + e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}
	
}
