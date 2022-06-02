
package com.maan.life.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maan.life.bean.MCompany;
import com.maan.life.repository.MCompanyRepository;
import com.maan.life.service.MCompanyService;

@Service
@Transactional
public class MCompanyServiceImpl implements MCompanyService {

	@Autowired
	private MCompanyRepository repository;

	private Logger log = LogManager.getLogger(MCompanyServiceImpl.class);

	/*
	 * public MCompanyServiceImpl(MCompanyRepository repo) { this.repository = repo;
	 * }
	 * 
	 */
	@Override
	public MCompany create(MCompany d) {

		MCompany entity;

		try {
			entity = repository.save(d);

		} catch (Exception ex) {
			log.error(ex);
			return null;
		}
		return entity;
	}

	@Override
	public MCompany update(MCompany d) {
		MCompany c;

		try {
			c = repository.saveAndFlush(d);

		} catch (Exception ex) {
			log.error(ex);
			return null;
		}
		return c;
	}

	/*
	 * @Override public MCompany getOne(long id) { MCompany t;
	 * 
	 * try { t = repository.findById(id).orElse(null);
	 * 
	 * } catch (Exception ex) { log.error(ex); return null; } return t; }
	 * 
	 */
	@Override
	public List<MCompany> getAll() {
		List<MCompany> lst;

		try {
			lst = repository.findAll();

		} catch (Exception ex) {
			log.error(ex);
			return Collections.emptyList();
		}
		return lst;
	}

	@Override
	public long getTotal() {
		long total;

		try {
			total = repository.count();
		} catch (Exception ex) {
			log.error(ex);
			return 0;
		}
		return total;
	}

	@Override
	public Optional<MCompany> findByCompCode(String compCode) {

		return repository.findByCompCode(compCode);
	}

	@Override
	public void saveorupdate(MCompany obj) {

		repository.saveAndFlush(obj);

	}

	@Override
	public Page<MCompany> findAll(Pageable paging) {

		return repository.findAll(paging);
	}

	@Override
	public Page<MCompany> findSearch(String search, Pageable paging) {

		String sear = "%" + search + "%";

		return repository.findAll(sear, paging);
	}

	/*
	 * @Override public boolean delete(long id) { try { repository.deleteById(id);
	 * return true;
	 * 
	 * } catch (Exception ex) { log.error(ex); return false; } }
	 * 
	 */

}
