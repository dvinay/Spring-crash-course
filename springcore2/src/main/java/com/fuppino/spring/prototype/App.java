package com.fuppino.spring.prototype;

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
		
		Item item1 = (Item)ctx.getBean("item");	
		display(item1);
		
		Item item2 = (Item)ctx.getBean("item");	
		display(item2);
		
		Item item3 = (Item)ctx.getBean("item");	
		display(item3);
		
		Item item4 = (Item)ctx.getBean("item");	
		display(item4);
		
	}
	public static void display(Item item){
		System.out.print(" hashcode : "+item.hashCode());
		System.out.print(" item id: "+item.getId());
		System.out.println(" item name:"+item.getName());
	}
}
