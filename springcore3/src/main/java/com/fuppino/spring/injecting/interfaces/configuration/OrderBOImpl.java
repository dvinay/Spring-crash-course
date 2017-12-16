package com.fuppino.spring.injecting.interfaces.configuration;

public class OrderBOImpl implements OrderBO {

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
