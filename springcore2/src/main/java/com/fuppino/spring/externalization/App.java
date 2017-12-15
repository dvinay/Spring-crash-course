package com.fuppino.spring.externalization;

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
		
		Extern data = (Extern)ctx.getBean("extern");
		System.out.println(data);
	}
}
