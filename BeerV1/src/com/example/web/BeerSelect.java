package com.example.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.example.model.*;

public class BeerSelect extends HttpServlet{

	public BeerSelect(){
		System.out.println("BeerSelect......................");
	}

	public void init(ServletConfig config){
		System.out.println("init....");
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		Dog dog = new Dog("erha");

		HttpSession session = request.getSession();
		session.setAttribute("beerName",dog);
		
		// out.println("Beer Selection Advice<br>");
		String c = request.getParameter("color");

		//用于模拟模型（model）层
		BeerExpert beerExpert = new BeerExpert();
		List<String> list = beerExpert.getBrands(c);

		// for(String str:list){
		// 	out.print("<br>try : "+str);
		// }
		request.setAttribute("style",list);
		request.setAttribute("dog",new Dog("dahuang"));
		request.setAttribute("user","twx");
		request.setAttribute("str","<b></b>hfdhfdj");
		RequestDispatcher requestDispathcer= request.getRequestDispatcher("result.jsp");

		requestDispathcer.forward(request,response);
		
	}
}
