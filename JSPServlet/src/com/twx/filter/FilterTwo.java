package com.twx.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class FilterTwo implements Filter {

    public FilterTwo() {
        System.out.println("=====FilterTwo构造函数====");
    }

  
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("=====FilterTwo初始化方法====");//容器启动的时候就执行
	}
	

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 System.out.println("=====开始执行FilterTwo deFilter方法====");
		chain.doFilter(request, response);
		 System.out.println("=====结束执行FilterTwo deFilter方法====");
	}
	
	
	public void destroy() {
		System.out.println("=====FilterTwo销毁方法====");
	}

}
