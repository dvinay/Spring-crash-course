package com.fuppino.spring.autowire.annotation;

public class Item {

	private String name;

	public Item() {
		super();
	}

	public Item(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + "]";
	}
	
}
