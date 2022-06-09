package com.maan.life.util;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Convention {

	public Direction getSortDirection(String direction) {

		if (direction.equals("asc")) {
			return Sort.Direction.ASC;
		} else if (direction.equals("desc")) {
			return Sort.Direction.DESC;
		}

		return Sort.Direction.ASC;
	}

	public Pageable getPaging(int pageNo, int pageSize) {

		Pageable paging = PageRequest.of(pageNo, pageSize);

		return paging;
	}

	public int getPageNumber(int pageNo) {

		if (ValidationUtil.isNull(pageNo)) {
			return 0;
		} else {
			return pageNo - 1;
		}

	}

	public int getPageSize(int pageSize) {

		if (ValidationUtil.isNull(pageSize)) {
			return 10000;
		} else {
			return pageSize;
		}

	}

	
}
