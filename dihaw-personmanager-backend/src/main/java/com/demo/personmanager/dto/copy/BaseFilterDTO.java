package com.demo.personmanager.dto.copy;

/**
 * @author Wahid Gazzah
 * @since 16/10/2027
 *
 */
public class BaseFilterDTO {
	
	private Integer  pageNum;
	private Integer pageSize;
    private String orderCol;
    private String orderDir;
    
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getOrderCol() {
		return orderCol;
	}
	public void setOrderCol(String orderCol) {
		this.orderCol = orderCol;
	}
	public String getOrderDir() {
		return orderDir;
	}
	public void setOrderDir(String orderDir) {
		this.orderDir = orderDir;
	}
    
    


}
