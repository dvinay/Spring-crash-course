package com.fuppino.spring;

import org.springframework.beans.factory.annotation.Required;

public class Patient {
	
	private int id;
	private String name;

	public Patient() {
		super();
	}

	public Patient(int id, String name) {
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
