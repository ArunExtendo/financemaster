
package com.maan.life.repository;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.maan.life.bean.MAppCodes;
import com.maan.life.bean.MAppCodesId;
import com.maan.life.dto.MAppCodesDto;

public interface MAppCodesRepository
		extends JpaRepository<MAppCodes, MAppCodesId>, JpaSpecificationExecutor<MAppCodes> {

	void save(@Valid MAppCodesDto request);


}
