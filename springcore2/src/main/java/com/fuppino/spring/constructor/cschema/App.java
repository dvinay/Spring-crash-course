package com.fuppino.spring.constructor.cschema;

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
		
		Cons data = (Cons)ctx.getBean("cons");
		System.out.print(" cons id: "+data.getId());
		System.out.println(" cons name:"+data.getName());
	}
}
