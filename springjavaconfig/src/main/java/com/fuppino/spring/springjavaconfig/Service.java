package com.fuppino.spring.springjavaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fuppino.spring.springjavaconfig.dao.Dao;

@Component
public class Service 
{
	@Autowired
	Dao dao;
	
    public void save() {
    	System.out.println("save");
    	dao.create();
    }
}
