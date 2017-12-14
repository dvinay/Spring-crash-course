package com.fuppino.spring.map;

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
		
		TelePhoneDirectory telePhoneDirectory = (TelePhoneDirectory)ctx.getBean("telePhoneDirectory");
		
		System.out.println("TelePhoneDirectory Name: "+telePhoneDirectory.getName());
		System.out.println("TelePhoneDirectory Departments: "+telePhoneDirectory.getContacts());
		System.out.println("Deafult map type: "+telePhoneDirectory.getContacts().getClass().getName());		
	}
}
