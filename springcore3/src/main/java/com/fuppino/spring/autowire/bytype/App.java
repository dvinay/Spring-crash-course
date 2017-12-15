package com.fuppino.spring.autowire.bytype;

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
		System.out.println("Address : "+employee.getAddress());
		System.out.println("Address hashcode: "+employee.getAddress().hashCode());	
		
	}
}
