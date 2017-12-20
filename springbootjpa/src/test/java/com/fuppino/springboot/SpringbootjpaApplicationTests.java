package com.fuppino.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.fuppino.springboot.entities.Product;
import com.fuppino.springboot.repos.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootjpaApplicationTests {

	@Autowired
	ApplicationContext context;
	
	@Test
	public void createProduct() {
		ProductRepository productRepository = context.getBean(ProductRepository.class);
		Product product = new Product();
		product.setId(3L);
		product.setName("IPhone");
		product.setDescription("Iphone X");
		product.setPrice(1000.0);
		productRepository.save(product);
	}
	
	@Test
	public void readProduct() {
		ProductRepository productRepository = context.getBean(ProductRepository.class);
		Product product = productRepository.findOne(3L);
		System.out.println("Product : "+product);
	}
	
	@Test
	public void updateProduct() {
		ProductRepository productRepository = context.getBean(ProductRepository.class);
		Product product = productRepository.findOne(3L);
		product.setPrice(1100.0);
		productRepository.save(product);
	}
	
	@Test
	public void readProducts() {
		ProductRepository productRepository = context.getBean(ProductRepository.class);
		Iterable<Product> product = productRepository.findAll();
		product.forEach(p-> System.out.println(p));
	}
	
	@Test
	public void findProductsByCustomFields() {
		ProductRepository productRepository = context.getBean(ProductRepository.class);
		Iterable<Product> product = productRepository.findByName("IPhone");
		product.forEach(p-> System.out.println(p));
		System.out.println();
		
		product = productRepository.findByPrice(800D);
		product.forEach(p-> System.out.println(p));
		System.out.println();
		
		product = productRepository.findByNameAndPrice("IPhone",1100D);
		product.forEach(p-> System.out.println(p));
		System.out.println();
	}

}
