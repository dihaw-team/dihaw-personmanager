package com.demo.personmanager.domain.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.personmanager.domain.IUserDomain;
import com.demo.personmanager.dto.SearchUsersRequestDTO;
import com.demo.personmanager.dto.SearchUsersResponseDTO;
import com.demo.personmanager.dto.UserDTO;
import com.demo.personmanager.persistence.IUserPersistence;

/**
 * Implementation of {@link IUserDomain}
 *  
 * @author Wahid Gazzah
 * @since 15/04/2016
 * 
 */

@Component
public class UserDomainImpl implements IUserDomain{

	private static final Logger logger = LoggerFactory.getLogger(UserDomainImpl.class);
	
	@Autowired
	private IUserPersistence userPersistence;
	
	public Long create(UserDTO dto) {

		logger.info("Delegating request to Persistence layer.");
		
		return userPersistence.create(dto);
	}

	public UserDTO getById(Long id) {

		UserDTO user;
		
		logger.info("Delegating request to Persistence layer.");
		
		user = userPersistence.getById(id);
		
//		if(user == null){
//			
//			user = new UserDTO();
//			user.getErrors().reject("user.notExist");	
//		}
//		if(!user.hasErrors()){
//			
//			user.getExtensions().put("produitId", 47L);
//			user.getExtensions().put("produitDesignation", "Produit Designation");
//			user.getExtensions().put("produitReference", "REF-587412");
//			user.getExtensions().put("companyId", 32L);
//		}
		
		return user;
	}

	public Long update(UserDTO dto) {

		logger.info("Delegating request to Persistence layer.");
		
		return userPersistence.update(dto);
	}

	public void delete(Long id) {
		
		logger.info("Delegating request to Persistence layer.");
		
		userPersistence.delete(id);
		
	}

	public List<UserDTO> getAll() {
		
		logger.info("Delegating request to Persistence layer.");
		
		return userPersistence.getAll();
	}

	public SearchUsersResponseDTO searchUsers(SearchUsersRequestDTO filter) {

		logger.info("Delegating request to Persistence layer.");
		
		return userPersistence.searchUsers(filter);
	}
}
