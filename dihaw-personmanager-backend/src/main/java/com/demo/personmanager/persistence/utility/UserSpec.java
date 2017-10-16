package com.demo.personmanager.persistence.utility;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.demo.personmanager.dto.UserDTO;

//http://stackoverflow.com/questions/27626825/spring-data-jpa-query-by-example
public class UserSpec implements Specification<UserDTO> {

	public Predicate toPredicate(Root<UserDTO> arg0, CriteriaQuery<?> arg1, CriteriaBuilder arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
