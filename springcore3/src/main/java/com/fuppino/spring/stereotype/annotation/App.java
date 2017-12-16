package com.fuppino.spring.stereotype.annotation;

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
		
		Professor professor = (Professor)ctx.getBean("professor");	
		System.out.println("Professor : "+ professor);	
		
	}
}
