package com.demo.personmanager.controller;


/**
 * Common base controller for user based controllers.
 * 
 * @author Wahid Gazzah
 * @since 30/06/2016
 *
 */
public class CommonController {
	
	private static final String EMPTY_STRING = "";
	
    public static final String PAGE_NUM_PARAM = "pageNum";
    public static final String PAGE_SIZE_PARAM = "pageSize";
    public static final String ORDER_COL_PARAM = "orderCol";
    public static final String ORDER_DIR_PARAM = "orderDir";
    
	private boolean isEmpty(String value) {
		return value == null && EMPTY_STRING.equals(value);
	}
}
