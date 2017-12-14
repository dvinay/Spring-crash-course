package com.fuppino.spring.set;

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
		
		CarDealer carDealer = (CarDealer)ctx.getBean("carDealer");
		
		System.out.println("CarDealer Name: "+carDealer.getName());
		System.out.println("CarDealer Models: "+carDealer.getModles());
		System.out.println("Deafult set type: "+carDealer.getModles().getClass().getName());		
	}
}
