package com.maan.life.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.maan.life.bean.MCompany;
import com.maan.life.dto.ListViewParam;
import com.maan.life.response.Response;
import com.maan.life.response.ResponseGenerator;
import com.maan.life.response.TransactionContext;
import com.maan.life.service.MCompanyService;
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
@RequestMapping("/mcompany")
public class MCompanyController {

	@Autowired
	private MCompanyService entityService;
	private MessagePropertyService messageSource;
	private Convention sorting;

	private static final Logger logger = Logger.getLogger(MCompanyController.class);

	private @NonNull ResponseGenerator responseGenerator;

	@ApiOperation(value = "Create or Update.", response = Response.class)
	@PostMapping(value = "/createOrUpdate", produces = "application/json")
	public ResponseEntity<?> createOrUpdate(
			@ApiParam(value = "The Line of Business request payload") @Valid @RequestBody MCompany request,
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

	@ApiOperation(value = "Allows to fetch dropdown List.", response = Response.class)
	@GetMapping(value = "/getAll", produces = "application/json")
	public ResponseEntity<?> getAll(@RequestHeader HttpHeaders httpHeader) throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);

		try {

			List<MCompany> lst = entityService.getAll();
			return responseGenerator.successGetResponse(context, messageSource.getMessage("fetched"), lst,
					HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			logger.error("Error in getAll for dropdown List" + e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@ApiOperation(value = "Allows to fetch Grid List.", response = Response.class)
	@PostMapping(value = "/getAll", produces = "application/json")
	public ResponseEntity<?> getAll(@RequestBody ListViewParam request, @RequestHeader HttpHeaders httpHeader)
			throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);

		try {
			Pageable paging = sorting.getPaging(sorting.getPageNumber(request.getPageNumber()),
					sorting.getPageSize(request.getPageSize()));

			List<MCompany> obj = new ArrayList<MCompany>();
			Page<MCompany> list = null;

			if (ValidationUtil.isNull(request.getSearch())) {

				list = entityService.findAll(paging);

			} else {

				list = entityService.findSearch(request.getSearch(), paging);

			}

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
