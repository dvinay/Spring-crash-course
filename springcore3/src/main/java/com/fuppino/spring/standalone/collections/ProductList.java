package com.fuppino.spring.standalone.collections;

import java.util.List;

public class ProductList {
	List<String> productNames;
	
	public List<String> getProductNames() {
		return productNames;
	}

	public void setProductNames(List<String> productNames) {
		this.productNames = productNames;
	}

	@Override
	public String toString() {
		return "ProductList [productNames=" + productNames + "]";
	}
	
}
