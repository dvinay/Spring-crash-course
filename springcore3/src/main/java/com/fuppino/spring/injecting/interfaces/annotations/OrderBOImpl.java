package com.fuppino.spring.injecting.interfaces.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("orderBO")
public class OrderBOImpl implements OrderBO {

	@Autowired
	private OrderDAO orderDAOImpl;
	
	@Override
	public void processOrder() {
		System.out.println("Inside processOrder methods - OrderBOImpl");
		getOrderDAOImpl().createOrder();
	}

	public OrderDAO getOrderDAOImpl() {
		return orderDAOImpl;
	}

	public void setOrderDAOImpl(OrderDAO orderDAOImpl) {
		this.orderDAOImpl = orderDAOImpl;
	}

}
