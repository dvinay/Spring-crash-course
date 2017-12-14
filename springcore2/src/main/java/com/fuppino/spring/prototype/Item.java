package com.fuppino.spring.prototype;

import org.springframework.beans.factory.annotation.Required;

public class Item {
	
	private int id;
	private String name;

	public Item() {
		super();
	}

	public Item(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	@Required
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
