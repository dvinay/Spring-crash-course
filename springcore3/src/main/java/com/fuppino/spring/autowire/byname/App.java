package com.fuppino.spring.autowire.byname;

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
		
		Student student = (Student)ctx.getBean("student");	
		System.out.println("Student : "+student);
		System.out.println("Course  : "+student.getCourse());	
		
	}
}
