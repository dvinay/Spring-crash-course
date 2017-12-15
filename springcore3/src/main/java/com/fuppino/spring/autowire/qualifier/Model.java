package com.fuppino.spring.autowire.qualifier;

public class Model {

	private String name;

	public Model() {
		super();
	}

	public Model(String name) {
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
