package com.fuppino.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		Patient patient = (Patient)ctx.getBean("patient");	
		System.out.println("Patient ID: "+patient.getId());
		System.out.println("Patient Name: "+patient.getName());
	}
}
