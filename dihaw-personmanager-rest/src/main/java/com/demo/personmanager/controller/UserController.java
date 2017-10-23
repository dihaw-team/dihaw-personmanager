package com.demo.personmanager.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.personmanager.dto.SearchUsersRequestDTO;
import com.demo.personmanager.dto.SearchUsersResponseDTO;
import com.demo.personmanager.dto.UserDTO;
import com.demo.personmanager.service.IUserService;

/**
 * User Rest Controller
 * @author Wahid Gazzah
 * @since 15/04/2016
 */

@RestController
@RequestMapping("/usermanager")
public class UserController extends CommonController{
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Long create(@RequestBody UserDTO dto) {
		
		logger.info("Delegating request to Service layer.");
		
		return userService.create(dto);
	}
	
	@RequestMapping(value = "/getById:{id}", method = RequestMethod.GET, produces = "application/json")
	public UserDTO getById(@PathVariable Long id) {
		  
		logger.info("Delegating request id {} to service layer.", id);
		
		return userService.getById(id);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Long update(@RequestBody UserDTO dto) {
	    
		logger.info("Delegating request to service layer.");
		
		return userService.update(dto);
	}
	  
	@RequestMapping(value = "/delete:{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		  
		logger.info(" Delegating request id {} to service layer.", id);
		  
		userService.delete(id);
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public List<UserDTO> getAll() {
		  
		logger.info("Delegating request id to service layer.");
		
		return userService.getAll();
	}
		
	@RequestMapping(value = "/searchUsers", method = RequestMethod.POST)
	public SearchUsersResponseDTO searchUsers(@RequestBody SearchUsersRequestDTO request) {
	    
		logger.info("Delegating request to service layer.");
		
		return userService.searchUsers(request);
	}

}
