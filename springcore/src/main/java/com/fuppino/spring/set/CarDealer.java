package com.fuppino.spring.set;

import java.util.Set;

public class CarDealer {
	private String name;
	private Set<String> modles; 
	
	public CarDealer() {
		super();
	}

	public CarDealer(String name, Set<String> modles) {
		super();
		this.name = name;
		this.modles = modles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getModles() {
		return modles;
	}

	public void setModles(Set<String> modles) {
		this.modles = modles;
	}
	
}
