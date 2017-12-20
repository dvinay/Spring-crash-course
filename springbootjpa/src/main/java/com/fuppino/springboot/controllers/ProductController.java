package com.fuppino.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
