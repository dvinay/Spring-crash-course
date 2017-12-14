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
		
		System.out.println("University Name: "+carDealer.getName());
		System.out.println("University Departments: "+carDealer.getModles());
		System.out.println("Deafult set type: "+carDealer.getModles().getClass().getName());		
	}
}
