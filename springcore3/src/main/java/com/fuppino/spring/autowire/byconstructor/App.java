package com.fuppino.spring.autowire.byconstructor;

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
		
		Job job = (Job)ctx.getBean("job");	
		System.out.println("Job : "+job);
		System.out.println("Profile  : "+job.getProfile());	
		
	}
}
