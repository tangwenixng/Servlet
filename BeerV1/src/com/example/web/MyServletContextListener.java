package com.example.web;

import javax.servlet.*;
import com.example.model.*;

public class MyServletContextListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent event){
		System.out.println("MyServletContextListener init.....");
		ServletContext context = event.getServletContext();
		String dogBreed = context.getInitParameter("breed");

		Dog dog = new Dog(dogBreed);
		context.setAttribute("dog",dog);

	}

	public void contextDestroyed(ServletContextEvent event){

	}
}