package com.fuppino.spring.byname;

public class Address {

	private String cityName;

	public Address() {
		super();
	}

	public Address(String cityName) {
		super();
		this.cityName = cityName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "Address [cityName=" + cityName + "]";
	}
	
}
