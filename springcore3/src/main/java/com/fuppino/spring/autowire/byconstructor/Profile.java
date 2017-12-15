package com.fuppino.spring.autowire.byconstructor;

public class Profile {

	private String skil;

	public Profile() {
		super();
	}

	public Profile(String skil) {
		super();
		this.skil = skil;
	}

	public String getSkil() {
		return skil;
	}

	public void setSkil(String skil) {
		this.skil = skil;
	}

	@Override
	public String toString() {
		return "Profile [skil=" + skil + "]";
	}
	
}
