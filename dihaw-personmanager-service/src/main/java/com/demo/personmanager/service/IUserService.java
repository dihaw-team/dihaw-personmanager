package com.demo.personmanager.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.demo.personmanager.dto.SearchUsersRequestDTO;
import com.demo.personmanager.dto.SearchUsersResponseDTO;
import com.demo.personmanager.dto.UserDTO;

/**
 * @author Wahid Gazzah
 * @since 15/04/2016
 */

public interface IUserService {

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public Long create(UserDTO dto);

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public UserDTO getById(Long id);

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public Long update(UserDTO dto);

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public void delete(Long id);

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public List<UserDTO> getAll();

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public SearchUsersResponseDTO searchUsers(SearchUsersRequestDTO filter);
}
