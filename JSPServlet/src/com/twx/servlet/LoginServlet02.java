package com.twx.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet02 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("进入deget方法");
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("进入depost方法");
		String name = req.getParameter("uname");
		String password = req.getParameter("upwd");
		
		System.out.println("用户名"+name);
		System.out.println("密码"+password);
		
		String url=null;
		if(name.equals("唐文兴") && password.equals("qwer")){
			url = "/02/success.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, resp);
			
			//请求重定向
			//resp.sendRedirect(req.getContextPath()+"/01/success.jsp");
		}else{
			url = "/02/error.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, resp);
			//resp.sendRedirect(req.getContextPath()+"/01/error.jsp");
		}
	}

	/*@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("uname");
		String password = req.getParameter("upwd");
		
		System.out.println("用户名"+name);
		System.out.println("密码"+password);
	}*/
	
}
