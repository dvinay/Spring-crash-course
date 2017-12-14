package com.fuppino.spring.lc.annotations;

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
		
		AnnotationBean annotationBean = (AnnotationBean)ctx.getBean("annotationBean");
		System.out.println(annotationBean);
		ctx.registerShutdownHook();
	}
}
