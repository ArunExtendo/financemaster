package com.maan.life.controller;

import com.maan.life.bean.MDepartment;
import com.maan.life.dto.ListViewParam;
import com.maan.life.response.Response;
import com.maan.life.response.ResponseGenerator;
import com.maan.life.response.TransactionContext;
import com.maan.life.service.MDepartmentService;
import com.maan.life.service.MessagePropertyService;
import com.maan.life.util.ValidationUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@AllArgsConstructor(onConstructor_ = { @Autowired })
@RequestMapping("/mdepartment")
public class MDepartmentController {

	@Autowired
	private MDepartmentService entityService;
	private MessagePropertyService messageSource;
	private @NonNull ResponseGenerator responseGenerator;

	private static final Logger logger = Logger.getLogger(MDepartmentController.class);

	@PostMapping(value = "/createOrUpdate", produces = "application/json")
	public ResponseEntity<?> createOrUpdate(
			@ApiParam(value = "Request payload") @Valid @RequestBody MDepartment request,
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

	@ApiOperation(value = "Allows to fetch Department list to populate on dropdown.", response = Response.class)
	@GetMapping(value = "/getList", produces = "application/json")
	public ResponseEntity<?> getList(@RequestHeader HttpHeaders httpHeader) throws Exception {
		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);

		try {

			List<MDepartment> lst = entityService.getAll();
			return responseGenerator.successGetResponse(context, messageSource.getMessage("fetched"), lst,
					HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			logger.error("Error in getList for dropdown List" + e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@ApiOperation(value = "Allows to fetch Grid List.", response = Response.class)
	@PostMapping(value = "/getAll", produces = "application/json")
	public ResponseEntity<?> getAll(@RequestBody ListViewParam request, @RequestHeader HttpHeaders httpHeader)
			throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);

		try {
			Map<String, Object> response = entityService.findAllDepartmentDetails(request);
			return responseGenerator.successGetResponse(context, messageSource.getMessage("fetched"), response,
					HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in getAll for Grid list" + e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}



	@ApiOperation(value = "Allows to fetch a Department Entity with given code(primary key).", response = Response.class)
	@PostMapping(value = "/get", produces = "application/json")
	public ResponseEntity<?> getById(@RequestBody ListViewParam request, @RequestHeader HttpHeaders httpHeader)
			throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);
		try {
			if (!ValidationUtil.isEmptyStringArray(request.getCode()) && !(request.getCode().length < 3)) {
				Optional<MDepartment> dataObj = entityService.findById(request.getCode()[0],request.getCode()[1],request.getCode()[2]);
				return responseGenerator.successGetResponse(context, messageSource.getMessage("fetched"), dataObj,
						HttpStatus.OK);
			} else {
				throw new Exception("Company and Division and Department Code is required to fetch entity");
			}
		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

}
