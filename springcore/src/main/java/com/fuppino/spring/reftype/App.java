package com.fuppino.spring.reftype;

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
		
		Score score = (Score)ctx.getBean("scores");
		System.out.println(score);
		
		Student student = (Student)ctx.getBean("student");
		System.out.println(student);
	}
}
