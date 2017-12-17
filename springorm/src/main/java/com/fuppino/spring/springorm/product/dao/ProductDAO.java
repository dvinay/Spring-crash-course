package com.fuppino.spring.springorm.product.dao;

import com.fuppino.spring.springorm.product.entity.Product;

public interface ProductDAO {
	int create(Product product);
	void update(Product product);
	void delete(Product product);
}
