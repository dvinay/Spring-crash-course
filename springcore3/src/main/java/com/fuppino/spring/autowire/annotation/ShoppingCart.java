package com.fuppino.spring.autowire.annotation;

import org.springframework.beans.factory.annotation.Autowired;


public class ShoppingCart {

	private String name;
	
	@Autowired
	private Item item;
	
	public ShoppingCart() {
		super();
	}
	
	/*
	@Autowired
	public ShoppingCart(Item item) {
		super();
		this.item = item;
	}
	*/
	
	public ShoppingCart(String name, Item item) {
		super();
		this.name = name;
		this.item = item;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Item getItem() {
		return item;
	}

//	@Autowired
	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "ShoppingCart [name=" + name + ", item=" + item + "]";
	}
	
}
