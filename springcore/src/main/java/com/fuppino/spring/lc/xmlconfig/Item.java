package com.fuppino.spring.lc.xmlconfig;


public class Item {
	private int id;

	public Item() {
		super();
	}

	public Item(int id) {
		super();
		this.id = id;
	}

	public void init() {//function name is not mandatory
		System.out.println("inside - Item init method");
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		System.out.println("inside - Item setId method");
		this.id = id;
	}

	public void destroy() {//function name is not mandatory
		System.out.println("inside - Item destroy method");
	}
	
	@Override
	public String toString() {
		return "Item [id=" + id + "]";
	}
		
}
