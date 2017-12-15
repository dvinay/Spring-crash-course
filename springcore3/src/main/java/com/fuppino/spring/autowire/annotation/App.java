package com.fuppino.spring.autowire.annotation;

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
		
		ShoppingCart shoppingCart = (ShoppingCart)ctx.getBean("shoppingCart");	
		System.out.println("ShoppingCart : "+shoppingCart);
		System.out.println("Item  : "+shoppingCart.getItem());	
		
	}
}
