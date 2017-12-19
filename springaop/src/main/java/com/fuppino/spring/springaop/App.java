package com.fuppino.spring.springaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
        ProductService productService = (ProductService) applicationContext.getBean("productServiceImpl");
        System.out.println("Result : "+productService.multiply(10, 20));
    }
}
