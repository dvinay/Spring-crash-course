package com.fuppino.spring.prop;

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
		
		LanguageAndCountry languageAndCountry = (LanguageAndCountry)ctx.getBean("languageAndCountry");
		
		System.out.println("languageAndCountry Properties : "+languageAndCountry.getData());		
	}
}
