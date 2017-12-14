package com.fuppino.spring.list;

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
		
		University university = (University)ctx.getBean("university");
		
		System.out.println("University Name: "+university.getName());
		System.out.println("University Departments: "+university.getDepartment());
		System.out.println("Deafult list type: "+university.getDepartment().getClass().getName());		
	}
}
