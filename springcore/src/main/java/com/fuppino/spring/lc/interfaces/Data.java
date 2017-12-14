package com.fuppino.spring.lc.interfaces;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


public class Data implements InitializingBean, DisposableBean{
	private int id;

	public Data() {
		super();
	}

	public Data(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		System.out.println("inside - Data setId method");
		this.id = id;
	}

	@Override
	public String toString() {
		return "Data [id=" + id + "]";
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("inside - Data afterPropertiesSet");
	}

	@Override
	public void destroy() {
		System.out.println("inside - Data destroy method");
	}

}
