package com.fuppino.spring.autowire.qualifier;

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
		
		Car car = (Car)ctx.getBean("car");	
		System.out.println("Car"+ car);	
		
	}
}
