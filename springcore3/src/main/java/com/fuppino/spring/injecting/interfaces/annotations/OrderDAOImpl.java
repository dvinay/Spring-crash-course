package com.fuppino.spring.injecting.interfaces.annotations;

import org.springframework.stereotype.Component;

@Component
public class OrderDAOImpl implements OrderDAO {

	@Override
	public void createOrder() {
		System.out.println("Inside createOrder methods - OrderDAOImpl");
	}

}
