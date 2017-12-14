package com.fuppino.spring.innerbean;

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
		System.out.println("Employee Name: "+employee.getName());
		System.out.println("Employee Address: "+employee.getAddress());
	}
}
