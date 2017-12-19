package com.fuppino.spring.springjavaconfig.dao;

import org.springframework.stereotype.Component;

@Component
public class Dao 
{
	public void init() {
		System.out.println("init");
	}
	
	public void destroy() {
		System.out.println("destroy");
	}
    public void create() {
    	System.out.println("created");
    }
}
