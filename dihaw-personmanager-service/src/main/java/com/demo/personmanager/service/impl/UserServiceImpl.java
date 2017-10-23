package com.demo.personmanager.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.personmanager.domain.IUserDomain;
import com.demo.personmanager.dto.SearchUsersRequestDTO;
import com.demo.personmanager.dto.SearchUsersResponseDTO;
import com.demo.personmanager.dto.UserDTO;
import com.demo.personmanager.service.IUserService;

/**
 * Implementation of {@link IUserService}
 * 
 * @author Wahid Gazzah
 * @since 15/04/2016
 */

@Service
@Transactional
public class UserServiceImpl implements IUserService{

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private IUserDomain userDomain;

	public Long create(UserDTO dto) {

		logger.info("Delegating request to Domaine layer.");
		
		return userDomain.create(dto);
	}

	public UserDTO getById(Long id) {

		logger.info("Delegating request to Domaine layer.");
		
		return userDomain.getById(id);
	}

	public Long update(UserDTO dto) {

		logger.info("Delegating request to Domaine layer.");
		
		return userDomain.update(dto);
	}

	public void delete(Long id) {
		
		logger.info("Delegating request to Domaine layer.");
		
		userDomain.delete(id);
		
	}

	public List<UserDTO> getAll() {
		
		logger.info("Delegating request to Domaine layer.");
		
		return userDomain.getAll();
	}

	public SearchUsersResponseDTO searchUsers(SearchUsersRequestDTO request) {

		logger.info("Delegating request to Domaine layer.");
		
		return userDomain.searchUsers(request);
	}
}
