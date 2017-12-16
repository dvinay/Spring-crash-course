package com.fuppino.spring.standalone.collections;

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
		
		ProductList productList = (ProductList)ctx.getBean("productList");	
		System.out.println("ProductList"+ productList);	
		
	}
}
