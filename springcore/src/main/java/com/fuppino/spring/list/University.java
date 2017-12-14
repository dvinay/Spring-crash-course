package com.fuppino.spring.list;

import java.util.List;

public class University {
	private String name;
	private List<String> department; 
	
	public University() {
		super();
	}

	public University(String name, List<String> department) {
		super();
		this.name = name;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getDepartment() {
		return department;
	}

	public void setDepartment(List<String> department) {
		this.department = department;
	}

	
}
