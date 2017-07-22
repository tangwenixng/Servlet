package com.example.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class CodeReturn extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		System.out.println("OK");
		
		response.setContentType("application/jar");

		ServletContext context = getServletContext();
		InputStream is = context.getResourceAsStream("jackson-all-1.9.0.jar");

		int read = 0;
		byte[] bytes= new byte[1024];
		OutputStream output = response.getOutputStream();
		while((read=is.read(bytes))!=-1){
			output.write(bytes,0,read);
		}
		output.flush();
		output.close();
	}
}