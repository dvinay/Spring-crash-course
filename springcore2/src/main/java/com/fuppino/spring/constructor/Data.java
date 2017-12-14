package com.fuppino.spring.constructor;


public class Data {
	
	private int id;
	private String name;

	private Data() {
		super();
	}

	private Data(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
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
