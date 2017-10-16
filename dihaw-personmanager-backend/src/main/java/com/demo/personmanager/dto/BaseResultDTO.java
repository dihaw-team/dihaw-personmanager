package com.demo.personmanager.dto;

/**
 * @author Wahid Gazzah
 * @since 16/10/2027
 *
 */

public class BaseResultDTO {
	
	private Long nombreResults;
	
	private Long totalRequest;
	private Long numberElements;
	private Long totalPages;
	private Long pageNumber;
	private boolean hasPrevious;
	private boolean haseNext;

	public Long getNombreResults() {
		return nombreResults;
	}

	public void setNombreResults(Long nombreResults) {
		this.nombreResults = nombreResults;
	}

	public Long getTotalRequest() {
		return totalRequest;
	}

	public void setTotalRequest(Long totalRequest) {
		this.totalRequest = totalRequest;
	}

	public Long getNumberElements() {
		return numberElements;
	}

	public void setNumberElements(Long numberElements) {
		this.numberElements = numberElements;
	}

	public Long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
	}

	public Long getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Long pageNumber) {
		this.pageNumber = pageNumber;
	}

	public boolean hasPrevious() {
		return hasPrevious;
	}

	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}

	public boolean haseNext() {
		return haseNext;
	}

	public void setHaseNext(boolean haseNext) {
		this.haseNext = haseNext;
	}
	
	
	

}
