package com.fuppino.spring.lc.interfaces;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		Data data = (Data)ctx.getBean("data");
		System.out.println(data);
		ctx.registerShutdownHook();
	}
}
