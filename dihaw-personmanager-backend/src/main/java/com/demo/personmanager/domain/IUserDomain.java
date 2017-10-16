package com.demo.personmanager.domain;

import java.util.List;

import com.demo.personmanager.dto.SearchUsersRequestDTO;
import com.demo.personmanager.dto.SearchUsersResponseDTO;
import com.demo.personmanager.dto.UserDTO;

/**
 * User Domain Interface
 *  
 * @author Wahid Gazzah
 * @since 15/04/2016
 */
public interface IUserDomain {

	public Long create(UserDTO dto);

	public UserDTO getById(Long id);

	public Long update(UserDTO dto);

	public void delete(Long id);

	public List<UserDTO> getAll();

	public SearchUsersResponseDTO searchUsers(SearchUsersRequestDTO filter);
}
