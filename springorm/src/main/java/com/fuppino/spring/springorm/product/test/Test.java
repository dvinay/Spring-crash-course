package com.fuppino.spring.springorm.product.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fuppino.spring.springorm.product.dao.ProductDAO;
import com.fuppino.spring.springorm.product.entity.Product;

public class Test {
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");
		Product product = new Product();
		product.setId(2);
		product.setName("IPhone");
		product.setDesc("apple iphone phone");;
		product.setPrice(800);
//		productDAO.create(product);
//		productDAO.update(product);
//		productDAO.delete(product);
		
		/*
		Product product1 = productDAO.read(2);
		System.out.println(product1);
		*/
		
		List<Product> products = productDAO.readALL();
		System.out.println(products);
	}
}
