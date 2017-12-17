package com.fuppino.spring.springorm.product.dao;

import java.util.List;

import com.fuppino.spring.springorm.product.entity.Product;

public interface ProductDAO {
	int create(Product product);
	void update(Product product);
	void delete(Product product);
	Product read(int id);
	List<Product> readALL();
}
