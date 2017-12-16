package com.fuppino.spring.stereotype.annotation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("profe")
@Scope("prototype")
public class Professor {
	
	@Value("#{10+30}")
	private int id;
	
	@Value("Ram")
	private String name;

	@Value("#{topicsList}")
	private List<String> topics;
	
	@Autowired
	private Courses courses;

	public Professor() {
		super();
	}

	public Professor(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Professor(int id, String name, List<String> topics) {
		super();
		this.id = id;
		this.name = name;
		this.topics = topics;
	}
	
	public Professor(int id, String name, List<String> topics, Courses courses) {
		super();
		this.id = id;
		this.name = name;
		this.topics = topics;
		this.courses = courses;
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

	public List<String> getTopics() {
		return topics;
	}

	public void setTopics(List<String> topics) {
		this.topics = topics;
	}

	public Courses getCourses() {
		return courses;
	}

	public void setCourses(Courses courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", name=" + name + ", topics=" + topics
				+ ", courses=" + courses + "]";
	}
	
}
