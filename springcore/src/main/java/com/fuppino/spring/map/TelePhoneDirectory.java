package com.fuppino.spring.map;

import java.util.Map;

public class TelePhoneDirectory {
	private String name;
	private Map<String,String> contacts; 
	
	public TelePhoneDirectory() {
		super();
	}

	public TelePhoneDirectory(String name, Map<String, String> contacts) {
		super();
		this.name = name;
		this.contacts = contacts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getContacts() {
		return contacts;
	}

	public void setContacts(Map<String, String> contacts) {
		this.contacts = contacts;
	}
	
}
