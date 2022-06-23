package com.maan.life.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.maan.life.bean.MCustomer;
import com.maan.life.dto.ListViewParam;

public interface MCustomerService {

	List<MCustomer> getAll();

	void saveorupdate(MCustomer request);

	Page<MCustomer> findAllCustomerDetails(ListViewParam request);

	Optional<MCustomer> findById(String custCode);

}
