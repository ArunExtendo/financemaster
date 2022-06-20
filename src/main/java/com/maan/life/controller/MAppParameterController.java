package com.maan.life.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.maan.life.dto.LOVRequest;
import com.maan.life.dto.Option;
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

import com.maan.life.bean.MAppParameter;
import com.maan.life.dto.ListViewParam;
import com.maan.life.response.Response;
import com.maan.life.response.ResponseGenerator;
import com.maan.life.response.TransactionContext;
import com.maan.life.service.MAppParameterService;
import com.maan.life.service.MessagePropertyService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@AllArgsConstructor(onConstructor_ = { @Autowired })
@RequestMapping("/mappParameter")
public class MAppParameterController {

	@Autowired
	private MAppParameterService entityService;
	private MessagePropertyService messageSource;
	private @NonNull ResponseGenerator responseGenerator;

	private static final Logger logger = Logger.getLogger(MAppParameterController.class);
	
	@ApiOperation(value = "API to Create or Update AppParameter Entity", response = Response.class)
	@PostMapping(value = "/createOrUpdate", produces = "application/json")
	public ResponseEntity<?> createOrUpdate(
			@ApiParam(value = "Request payload") @Valid @RequestBody MAppParameter request,
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

 	@ApiOperation(value = "Allows to fetch Dropdown List Values for given App Param Code.", response = Response.class)
	@PostMapping(value = "/getListOfValues", produces = "application/json")
	public ResponseEntity<?> getListOfValues(@RequestHeader HttpHeaders httpHeader, @RequestBody @Valid LOVRequest request) throws Exception {
		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);

		try {
			List<Option> list = entityService.getListOfValues(request);
			return responseGenerator.successGetResponse(context, messageSource.getMessage("fetched"), list,
					HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in getListOfValues " + e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@ApiOperation(value = "Allows to fetch App parameter entities to populate on Grid.", response = Response.class)
	@PostMapping(value = "/getAll", produces = "application/json")
	public ResponseEntity<?> getAll(@RequestBody ListViewParam request, @RequestHeader HttpHeaders httpHeader)
			throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);
		try {
			List<MAppParameter> obj = new ArrayList<>();
			Page<MAppParameter> list = entityService.findAllAppParameterDetails(request);
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
			logger.error("Error in getAll for Grid list" + e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}
}
