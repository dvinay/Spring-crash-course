package com.fuppino.springboot.repos;

import org.springframework.data.repository.CrudRepository;

import com.fuppino.springboot.entities.Product;
import java.lang.String;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findByName(String name);
	List<Product> findByPrice(Double price);
	List<Product> findByNameAndPrice(String name, Double price);
}
