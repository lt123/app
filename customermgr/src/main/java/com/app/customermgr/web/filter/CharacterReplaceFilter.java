package com.app.customermgr.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterReplaceFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("CharacterReplaceFilter.init()");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("CharacterReplaceFilter.doFilter()");
		chain.doFilter(request, response);
	}

	public void destroy() {
		System.out.println("CharacterReplaceFilter.destroy()");
	}

}
