package com.fuppino.spring.injecting.interfaces.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/fuppino/spring/injecting/interfaces/annotations/config.xml");
		
		OrderBO orderBO = (OrderBO)ctx.getBean("orderBO");	
		orderBO.processOrder();	
	}
}
