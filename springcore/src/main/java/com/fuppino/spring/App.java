package com.fuppino.spring;

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
		
		Employee employee1 = (Employee)ctx.getBean("employee1");
		display(employee1);
		
		Employee employee2 = (Employee)ctx.getBean("employee2");
		display(employee2);
		
		Employee employee3 = (Employee)ctx.getBean("employee3");
		display(employee3);
	}
	
	public static void display(Employee employee) {
		System.out.println("Employee ID: "+employee.getId());
		System.out.println("Employee Name: "+employee.getName());
	}
}
