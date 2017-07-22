package com.example.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.example.model.*;

public class BeerSelect extends HttpServlet{
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		
		// out.println("Beer Selection Advice<br>");
		String c = request.getParameter("color");

		//用于模拟模型（model）层
		BeerExpert beerExpert = new BeerExpert();
		List<String> list = beerExpert.getBrands(c);

		// for(String str:list){
		// 	out.print("<br>try : "+str);
		// }
		request.setAttribute("style",list);
		RequestDispatcher requestDispathcer= request.getRequestDispatcher("result.jsp");

		requestDispathcer.forward(request,response);//转发到视图
		
	}
}
