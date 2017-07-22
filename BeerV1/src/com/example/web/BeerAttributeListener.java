package com.example.web;

import javax.servlet.http.*;

public class BeerAttributeListener implements HttpSessionAttributeListener{

	public void attributeAdded(HttpSessionBindingEvent event){
		String name = event.getName();
		Object obj = event.getValue();

		System.out.println("add name "+name+" obj "+obj);
	}

	public void attributeRemoved(HttpSessionBindingEvent event){
		String name = event.getName();
		Object obj = event.getValue();

		System.out.println("removed name "+name+" obj "+obj);
	}

	public void attributeReplaced(HttpSessionBindingEvent event){
		String name = event.getName();
		Object obj = event.getValue();

		System.out.println("replaced name "+name+" obj "+obj);
	}

}