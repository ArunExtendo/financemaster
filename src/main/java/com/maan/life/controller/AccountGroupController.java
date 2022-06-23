package com.maan.life.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.maan.life.response.Response;
import com.maan.life.response.ResponseGenerator;
import com.maan.life.response.TransactionContext;
import com.maan.life.service.AccountGroupService;
import com.maan.life.service.MGIAcntYearService;
import com.maan.life.service.MGlAcntPeriodService;
import com.maan.life.service.MessagePropertyService;
import com.maan.life.util.Convention;
import com.maan.life.util.ValidationUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@AllArgsConstructor(onConstructor_ = { @Autowired })
@RequestMapping("/accountGroup")
public class AccountGroupController {

	@Autowired
	private AccountGroupService accountGroupService;
	private MessagePropertyService messageSource;
	private @NonNull ResponseGenerator responseGenerator;
	private Convention sorting;
	private MGIAcntYearService mGIAcntYearService;
	private MGlAcntPeriodService mGlAcntPeriodService;

	private static final Logger logger = Logger.getLogger(AccountGroupController.class);

	@ApiOperation(value = "API to Create or Update transction Entity.", response = Response.class)
	@PostMapping(value = "/createOrUpdate", produces = "application/json")
	public ResponseEntity<?> createOrUpdate(
			@ApiParam(value = "Request payload") @Valid @RequestBody MGlTransaction request,
			@RequestHeader HttpHeaders httpHeader) throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);
		try {
			accountGroupService.saveorupdate(request);
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

			List<MGlTransaction> lst = accountGroupService.getAll();
			return responseGenerator.successGetResponse(context, messageSource.getMessage("fetched"), lst,
					HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			logger.error("Error in getAll for dropdown " + e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}
	@ApiOperation(value = "API to Create or Update account year Entity.", response = Response.class)
	@PostMapping(value = "/year/createOrUpdate", produces = "application/json")
	public ResponseEntity<?> createOrUpdateYear(
			@ApiParam(value = "Request payload") @Valid @RequestBody MGlAcntYear request,
			@RequestHeader HttpHeaders httpHeader) throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);
		try {
			mGIAcntYearService.saveorupdate(request);
			return responseGenerator.successResponse(context, messageSource.getMessage("saved"), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in createOrupdate account year" + e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}

	}

	@ApiOperation(value = "Allows to fetch MGl AcntYear List.", response = Response.class)
	@PostMapping(value = "/year/getAll", produces = "application/json")
	public ResponseEntity<?> getAll(@RequestBody ListViewParam request, @RequestHeader HttpHeaders httpHeader)
			throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);

		try {
			Map<String, Object> response = mGIAcntYearService.findAll(request);
			return responseGenerator.successGetResponse(context, messageSource.getMessage("fetched"), response,
					HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@ApiOperation(value = "Allows to fetch a account year Entity with given code(primary key).", response = Response.class)
	@PostMapping(value = "/year/get", produces = "application/json")
	public ResponseEntity<?> getByaccountyearId(@RequestBody ListViewParam request,
			@RequestHeader HttpHeaders httpHeader) throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);

		try {
			if (!ValidationUtil.isEmptyStringArray(request.getCode())) {
				Optional<MGlAcntYear> mGlAcntYearOptionl = mGIAcntYearService
						.findByAyCompCodeAndAyAcntYear(request.getCode()[0], request.getCode()[1]);
				return responseGenerator.successGetResponse(context, messageSource.getMessage("fetched"),
						mGlAcntYearOptionl, HttpStatus.OK);
			} else {
				throw new Exception("Code to fetch Entity is not provided");
			}
		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@ApiOperation(value = "API to Create or Update account period Entity.", response = Response.class)
	@PostMapping(value = "/period/createOrUpdate", produces = "application/json")
	public ResponseEntity<?> createOrUpdatePeriod(
			@ApiParam(value = "Request payload") @Valid @RequestBody MGlAcntPeriod request,
			@RequestHeader HttpHeaders httpHeader) throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);
		try {
			mGlAcntPeriodService.saveorupdate(request);
			return responseGenerator.successResponse(context, messageSource.getMessage("saved"), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in createOrupdate account period" + e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}

	}

	@ApiOperation(value = "Allows to fetch MGl Acnt Period  List.", response = Response.class)
	@PostMapping(value = "/period/getAll", produces = "application/json")
	public ResponseEntity<?> accountPeriod(@RequestBody ListViewParam request, @RequestHeader HttpHeaders httpHeader)
			throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);

		try {
			Map<String, Object> response = mGlAcntPeriodService.findAll(request);
			return responseGenerator.successGetResponse(context, messageSource.getMessage("fetched"), response,
					HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@ApiOperation(value = "Allows to fetch a account period Entity with given code(primary key).", response = Response.class)
	@PostMapping(value = "/period/get", produces = "application/json")
	public ResponseEntity<?> getByaccountperiodId(@RequestBody ListViewParam request,
			@RequestHeader HttpHeaders httpHeader) throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);

		try {
			if (!ValidationUtil.isEmptyStringArray(request.getCode())) {
				Optional<MGlAcntPeriod> mGlAcntYearOptionl = mGlAcntPeriodService
						.findById(request.getCode()[0],
								request.getCode()[1], request.getCode()[2], request.getCode()[3]);
				return responseGenerator.successGetResponse(context, messageSource.getMessage("fetched"),
						mGlAcntYearOptionl, HttpStatus.OK);
			} else {
				throw new Exception("Code to fetch Entity is not provided");
			}
		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

}
