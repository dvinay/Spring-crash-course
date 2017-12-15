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
		
		Employee employee = (Employee)ctx.getBean("employee");	
		System.out.println("Employee : "+employee);
	}
}
