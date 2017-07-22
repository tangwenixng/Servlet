package com.example.model;

import javax.servlet.http.*;

public class Dog implements HttpSessionBindingListener{
	private String breed;

	public Dog(String breed){
		this.breed = breed;
	}

	public String getBreed(){
		return breed;
	}

	public void valueBound(HttpSessionBindingEvent event){
		System.out.println("you bind a dog");
	}

	public void valueUnbound(HttpSessionBindingEvent event){
		System.out.println("you unbind a dog");
	}
}