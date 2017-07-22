package com.example.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.example.model.*;

public class ListenerTest extends HttpServlet{
	public ListenerTest(){
		System.out.println("ListenerTest .....");
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		response.setContentType("text/html");
		
		Dog dog = (Dog)getServletContext().getAttribute("dog");
		String breed = dog.getBreed();

		PrintWriter out = response.getWriter();
		out.println("breed is "+breed);
		out.flush();
	}
}