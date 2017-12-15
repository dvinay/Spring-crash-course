package com.fuppino.spring.autowire.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class Car {

	@Autowired(required=false)
	@Qualifier("model2")
	private Model model;
	
	public Car() {
		super();
	}

	public Car(Model model) {
		super();
		this.model = model;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Car [model=" + model + "]";
	}
	
	
}
