package com.fuppino.spring.autowire.byconstructor;


public class Job {

	private String name;
	private Profile profile;
	
	public Job() {
		super();
	}

	public Job(Profile profile) {
		super();
		this.profile = profile;
	}

	public Job(String name, Profile profile) {
		super();
		this.name = name;
		this.profile = profile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "Job [name=" + name + ", profile=" + profile + "]";
	}
	
}
