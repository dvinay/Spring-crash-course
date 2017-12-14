package com.fuppino.spring.lc.xmlconfig;

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
		
		Item item = (Item)ctx.getBean("item");
		System.out.println(item);
		ctx.registerShutdownHook();
	}
}
