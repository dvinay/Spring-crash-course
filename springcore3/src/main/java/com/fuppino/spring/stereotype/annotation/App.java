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
		
		Professor professor = (Professor)ctx.getBean("profe");	
		System.out.println("Professor : "+ professor);	
		System.out.println("Hashcode value : "+ professor.hashCode());
		
		Professor professor1 = (Professor)ctx.getBean("profe");	
		System.out.println("Professor : "+ professor1);	
		System.out.println("Hashcode value : "+ professor1.hashCode());	
		
	}
}
