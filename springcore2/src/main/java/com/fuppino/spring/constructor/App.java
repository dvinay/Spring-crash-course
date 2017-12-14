package com.fuppino.spring.constructor;

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
		
		Data data = (Data)ctx.getBean("data");
		System.out.print(" data id: "+data.getId());
		System.out.println(" data name:"+data.getName());
	}
}
