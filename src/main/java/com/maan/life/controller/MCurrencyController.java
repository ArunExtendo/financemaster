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

import com.maan.life.bean.MCurrency;
import com.maan.life.dto.ListViewParam;
import com.maan.life.dto.MCurrencyDto;
import com.maan.life.dto.Option;
import com.maan.life.response.Response;
import com.maan.life.response.ResponseGenerator;
import com.maan.life.response.TransactionContext;
import com.maan.life.service.MCurrencyService;
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
@RequestMapping("/mcurrency")
public class MCurrencyController {

	@Autowired
	private MCurrencyService entityService;
	private MessagePropertyService messageSource;
	private @NonNull ResponseGenerator responseGenerator;
	private Convention sorting;

	private static final Logger logger = Logger.getLogger(MCurrencyController.class);

	@ApiOperation(value = "API to Create or Update Currency Entity.", response = Response.class)
	@PostMapping(value = "/createOrUpdate", produces = "application/json")
	public ResponseEntity<?> createOrUpdate(@ApiParam(value = "Request payload") @Valid @RequestBody MCurrency request,
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

	@ApiOperation(value = "Allows to fetch currency list to populate on dropdown.", response = Response.class)
	@GetMapping(value = "/getList", produces = "application/json")
	public ResponseEntity<?> getList(@RequestHeader HttpHeaders httpHeader) throws Exception {
		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);

		try {

			List<Option> lst = entityService.getList();
			return responseGenerator.successGetResponse(context, messageSource.getMessage("fetched"), lst,
					HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			logger.error("Error in getAll for dropdown " + e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@ApiOperation(value = "Allows to fetch Grid List.", response = Response.class)
	@PostMapping(value = "/getAll", produces = "application/json")
	public ResponseEntity<?> getAll(@RequestBody ListViewParam request, @RequestHeader HttpHeaders httpHeader)
			throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);

		Pageable paging = sorting.getPaging(sorting.getPageNumber(request.getPageNumber()),
				sorting.getPageSize(request.getPageSize()));

		try {

			List<MCurrencyDto> obj = new ArrayList<MCurrencyDto>();
			Optional<MCurrency> dataObj = null;
			Page<MCurrencyDto> pagingList = null;

			if (!ValidationUtil.isEmptyStringArray(request.getCode()) && ValidationUtil.isNull(request.getSearch())) {

				dataObj = entityService.findById(request.getCode()[0]);
				
				return responseGenerator.successGetResponse(context, messageSource.getMessage("fetched"), dataObj,
						HttpStatus.OK);
			}

			else {

				if (ValidationUtil.isNull(request.getSearch())
						&& ValidationUtil.isEmptyStringArray(request.getCode())) {

					pagingList = entityService.findAll(paging);

				}

				if (ValidationUtil.isEmptyStringArray(request.getCode())
						&& !ValidationUtil.isNull(request.getSearch())) {

					pagingList = entityService.findBySearch(request.getSearch(), paging);

				}

				obj = pagingList.getContent();

				Map<String, Object> response = new HashMap<>();
				response.put("data", obj);
				response.put("currentPage", pagingList.getNumber());
				response.put("totalItems", pagingList.getTotalElements());
				response.put("totalPages", pagingList.getTotalPages());

				return responseGenerator.successGetResponse(context, messageSource.getMessage("fetched"), response,
						HttpStatus.OK);

			}
		} catch (

		Exception e) {

			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

}
