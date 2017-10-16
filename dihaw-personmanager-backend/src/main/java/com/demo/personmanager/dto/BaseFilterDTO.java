package com.demo.personmanager.dto;

/**
 * @author Wahid Gazzah
 * @since 16/10/2027
 *
 */
public class BaseFilterDTO {
	
	private static final String EMPTY_STRING = "";

    private static final Integer DEFAULT_PAGE = 0;
	private static final Integer DEFAULT_PAGE_SIZE = 10;
	private static final String DEFAULT_ORDER_COL = "id";
    private static final String DEFAULT_ORDER_DIR = "asc";
	
	private Integer  pageNum;
	private Integer pageSize;
    private String orderCol;
    private String orderDir;
    
	public Integer getPageNum() {
		if(this.pageNum == null){
			setPageNum(DEFAULT_PAGE);
		}
		return pageNum;
	}
	public Integer getPageSize() {
		if(this.pageSize == null){
			setPageSize(DEFAULT_PAGE_SIZE);
		}
		return pageSize;
	}
	public String getOrderCol() {
		if(isEmpty(this.orderCol)){
			setOrderCol(DEFAULT_ORDER_COL);
		}
		return orderCol;
	}	
	public String getOrderDir() {
		if(isEmpty(this.orderDir)){
			setOrderDir(DEFAULT_ORDER_DIR);
		}
		return orderDir;
	}	
	
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public void setOrderCol(String orderCol) {
		this.orderCol = orderCol;
	}
	public void setOrderDir(String orderDir) {
		this.orderDir = orderDir;
	}
	
	private boolean isEmpty(String value) {
		return value == null && EMPTY_STRING.equals(value);
	}

}
