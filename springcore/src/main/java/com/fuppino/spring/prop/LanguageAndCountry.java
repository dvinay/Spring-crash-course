package com.fuppino.spring.prop;

import java.util.Properties;

public class LanguageAndCountry {
	private Properties data;

	public LanguageAndCountry() {
		super();
	}

	public LanguageAndCountry(Properties data) {
		super();
		this.data = data;
	}

	public Properties getData() {
		return data;
	}

	public void setData(Properties data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "LanguageAndCountry [data=" + data + "]";
	}
	
}
