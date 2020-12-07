package com.template.springbootgradle.models;

public class Citizen {

	int id;
	String name;

	public Citizen() {
	}
	
	public Citizen (int id, String name) {
		this.id=id;
		this.name=name;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
