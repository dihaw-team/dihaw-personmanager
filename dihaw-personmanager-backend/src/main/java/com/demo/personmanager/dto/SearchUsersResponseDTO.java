package com.demo.personmanager.dto;

import java.util.Set;
import java.util.TreeSet;

import com.demo.personmanager.dto.core.BaseResultDTO;

/**
 * @author Wahid Gazzah
 * @since 30/06/2016
 *
 */
public class SearchUsersResponseDTO extends BaseResultDTO{
	
	private Set<SearchUsersElementsResponseDTO> elements = new TreeSet <SearchUsersElementsResponseDTO>();
	
	public Set<SearchUsersElementsResponseDTO> getElements() {
		return elements;
	}
	public void setElements(Set<SearchUsersElementsResponseDTO> elements) {
		this.elements = elements;
	}


	
	
}
