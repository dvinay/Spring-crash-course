package com.fuppino.spring.stereotype.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("profe")
@Scope("prototype")
public class Professor {
	private int id;
	private String name;

	public Professor() {
		super();
	}

	public Professor(int id, String name) {
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

	@Override
	public String toString() {
		return "Professor [id=" + id + ", name=" + name + "]";
	}

}
