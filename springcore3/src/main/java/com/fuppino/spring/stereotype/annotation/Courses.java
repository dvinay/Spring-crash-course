package com.fuppino.spring.stereotype.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Courses {
	
	@Value("java-profile")
	private String title;
	
	public Courses() {
		super();
	}

	public Courses(String title) {
		super();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Courses [title=" + title + "]";
	}
	
}
