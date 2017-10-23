package com.demo.personmanager.persistence.utility;

import org.springframework.stereotype.Component;

import com.demo.personmanager.dto.SearchUsersElementsResponseDTO;
import com.demo.personmanager.dto.SearchUsersResponseDTO;
import com.demo.personmanager.dto.UserDTO;
import com.demo.personmanager.entity.UserEntity;

/**
 * Mapping Class from DTO to Entity, and from Entity to DTO
 * 
 * @author Wahid Gazzah
 * @since 15/04/2016
 *
 */

public class UserPersistenceUtility {

	public static UserDTO toUserDTO(UserEntity entity) {
		
		UserDTO dto = new UserDTO();
		
		dto.setId(entity.getId());
		dto.setEmail(entity.getEmail());
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());
		dto.setTelephone(entity.getTelephone());
		dto.setAdresse(entity.getAdresse());
		dto.setZipCode(entity.getZipCode());
		dto.setState(entity.getState());
		
		return dto;
	}
	
	public static UserEntity toUserEntity(UserDTO dto) {
		
		UserEntity entity = new UserEntity();
		
		entity.setId(dto.getId());
		entity.setEmail(dto.getEmail());
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setTelephone(dto.getTelephone());
		entity.setAdresse(dto.getAdresse());
		entity.setZipCode(dto.getZipCode());
		entity.setState(dto.getState());
		
		return entity;
	}
	
	public static SearchUsersElementsResponseDTO toSearchUsersElementsResponseDTO(UserEntity entity) {
		
		SearchUsersElementsResponseDTO dto = new SearchUsersElementsResponseDTO();
		
		dto.setId(entity.getId());
		dto.setEmail(entity.getEmail());
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());
		dto.setTelephone(entity.getTelephone());
		dto.setAdresse(entity.getAdresse());
		dto.setTelephone(entity.getTelephone());
		
		return dto;
	}
}
