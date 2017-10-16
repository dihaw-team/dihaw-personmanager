package com.demo.personmanager.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SimpleCORSFilter implements Filter {
	
	private static final Logger logger = LoggerFactory.getLogger(SimpleCORSFilter.class);

	public void init(FilterConfig arg0) throws ServletException {
		
		logger.info("initFilter...");
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		logger.info("doFilter...");

		HttpServletResponse response = (HttpServletResponse) resp;

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");

		chain.doFilter(req, resp);
	}

	public void destroy() {
		
		logger.info("destroyFilter...");
	}

}
