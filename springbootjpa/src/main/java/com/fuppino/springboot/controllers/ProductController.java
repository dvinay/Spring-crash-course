package com.fuppino.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fuppino.springboot.entities.Product;
import com.fuppino.springboot.repos.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping
	public Iterable<Product> getProducts() {
		Iterable<Product> products = productRepository.findAll();
		return products;
	}
	
	@GetMapping("/{id}")
	public Product getProducts(@PathVariable("id") Long id) {
		Product product = productRepository.findOne(id);
		return product;
	}
	
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@PutMapping
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

}
