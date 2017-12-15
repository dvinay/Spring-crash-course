package com.fuppino.spring.byname;

public class Course {

	private String subject;

	public Course() {
		super();
	}

	public Course(String subject) {
		super();
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Course [subject=" + subject + "]";
	}
	
}
