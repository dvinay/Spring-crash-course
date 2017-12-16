package com.fuppino.spring.injecting.interfaces.configuration;

public class OrderDAOImpl implements OrderDAO {

	@Override
	public void createOrder() {
		System.out.println("Inside createOrder methods - OrderDAOImpl");
	}

}
