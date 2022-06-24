package com.maan.life.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.maan.life.bean.MGlTransaction;

public interface AccountGroupService {

	void saveorupdate(@Valid MGlTransaction request);

	List<MGlTransaction> getAll();

}
