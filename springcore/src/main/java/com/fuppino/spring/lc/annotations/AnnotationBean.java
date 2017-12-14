package com.fuppino.spring.lc.annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class AnnotationBean {
	private int id;

	public AnnotationBean() {
		super();
	}

	public AnnotationBean(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		System.out.println("inside - AnnotationBean setId method");
		this.id = id;
	}

	@Override
	public String toString() {
		return "AnnotationBean [id=" + id + "]";
	}

	@PostConstruct
	public void init() {
		System.out.println("inside - AnnotationBean init method");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("inside - AnnotationBean destroy method");
	}

}
