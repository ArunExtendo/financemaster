package com.maan.life.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maan.life.bean.MCustApplComp;
import com.maan.life.dto.ListViewParam;
import com.maan.life.response.Response;
import com.maan.life.response.ResponseGenerator;
import com.maan.life.response.TransactionContext;
import com.maan.life.service.MCustApplCompService;
import com.maan.life.service.MessagePropertyService;
import com.maan.life.util.ValidationUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@AllArgsConstructor(onConstructor_ = { @Autowired })
@RequestMapping("/mcustApplComp")
public class MCustApplCompController {

	@Autowired
	private MCustApplCompService entityService;
	private MessagePropertyService messageSource;
	private @NonNull ResponseGenerator responseGenerator;

	private static final Logger logger = Logger.getLogger(MCustApplCompController.class);

	@PostMapping(value = "/createOrUpdate", produces = "application/json")
	public ResponseEntity<?> createOrUpdate(
			@ApiParam(value = "Request payload") @Valid @RequestBody MCustApplComp request,
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

	@ApiOperation(value = "Allows to fetch CustApplComp Grid List.", response = Response.class)
	@PostMapping(value = "/getAll", produces = "application/json")
	public ResponseEntity<?> getAll(@RequestBody ListViewParam request, @RequestHeader HttpHeaders httpHeader)
			throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);
		try {
			List<MCustApplComp> obj = new ArrayList<>();
			Page<MCustApplComp> list = entityService.findAllCustApplCompDetails(request);
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
			logger.error("Error in getAll for Grid List" + e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@ApiOperation(value = "Allows to fetch a cutomer Entity with given code(primary key).", response = Response.class)
	@PostMapping(value = "/get", produces = "application/json")
	public ResponseEntity<?> getById(@RequestBody ListViewParam request, @RequestHeader HttpHeaders httpHeader)
			throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);

		try {
			if (!ValidationUtil.isEmptyStringArray(request.getCode())) {
				Optional<MCustApplComp> dataObj = entityService.findById(request);
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
}
