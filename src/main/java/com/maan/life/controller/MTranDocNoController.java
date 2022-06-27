package com.maan.life.controller;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maan.life.bean.MTranDocNo;
import com.maan.life.dto.ListViewParam;
import com.maan.life.response.Response;
import com.maan.life.response.ResponseGenerator;
import com.maan.life.response.TransactionContext;
import com.maan.life.service.MTranDocNoService;
import com.maan.life.service.MessagePropertyService;
import com.maan.life.util.ValidationUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@NoArgsConstructor
@AllArgsConstructor(onConstructor_ = { @Autowired })
@RequestMapping("/mtrandocno")
public class MTranDocNoController {
	
	@Autowired
	private MTranDocNoService entityService;
	private MessagePropertyService messageSource;
	private @NonNull ResponseGenerator responseGenerator;
	
	private static final Logger logger = Logger.getLogger(MTranDocNoController.class);
	
	@ApiOperation(value = "API to Create or Update TranDocNo Entity.", response = Response.class)
	@PostMapping(value = "/createOrUpdate", produces = "application/json")
	public ResponseEntity<?> createOrUpdate(@ApiParam(value = "Request payload") @Valid @RequestBody MTranDocNo request,
			@RequestHeader HttpHeaders httpHeader) throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);
		try {
			entityService.saveorupdate(request);
			return responseGenerator.successResponse(context, messageSource.getMessage("saved"), HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			logger.error("Error in createOrUpdate" + e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@ApiOperation(value = "Allows to fetch a TranDocNo Entity with given code(primary key).", response = Response.class)
	@PostMapping(value = "/get", produces = "application/json")
	public ResponseEntity<?> getById(@RequestBody ListViewParam request, @RequestHeader HttpHeaders httpHeader)
			throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);

		try {
			if (!ValidationUtil.isEmptyStringArray(request.getCode())) {
				Optional<MTranDocNo> dataObj = entityService.findByCodes(request.getCode()[0],request.getCode()[1],request.getCode()[2],request.getCode()[3]);
				return responseGenerator.successGetResponse(context, messageSource.getMessage("fetched"), dataObj,
						HttpStatus.OK);
			} else {
				throw new Exception("Code to fetch Entity is not provided");
			}
		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}
	
	@ApiOperation(value = "Allows to fetch Grid List.", response = Response.class)
	@PostMapping(value = "/getAll", produces = "application/json")
	public ResponseEntity<?> getAll(@RequestBody ListViewParam request, @RequestHeader HttpHeaders httpHeader)
			throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);

		try {
			Map<String, Object> response = entityService.findAll(request);
			return responseGenerator.successGetResponse(context, messageSource.getMessage("fetched"), response,
					HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

}

