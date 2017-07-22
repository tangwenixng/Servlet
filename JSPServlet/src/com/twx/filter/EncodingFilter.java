package com.twx.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class EncodingFilter implements Filter {
	String encoding = null;
    public EncodingFilter() {
       
    }

  
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("=====EncodingFilter初始化方法====");//容器启动的时候就执行
		encoding = fConfig.getInitParameter("encoding");
		if(encoding==null){
			throw new ServletException("编码为空");
		}
	}
	

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 System.out.println("=====开始执行EncodingFilter deFilter方法====");
		 if(!encoding.equals(request.getCharacterEncoding())){
			 request.setCharacterEncoding(encoding);
		 }
		 response.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
		 System.out.println("=====结束执行EncodingFilter deFilter方法====");
	}
	
	
	public void destroy() {
		System.out.println("=====FilterTwo销毁方法====");
	}

}
