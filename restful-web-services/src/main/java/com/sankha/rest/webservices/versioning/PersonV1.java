package com.sankha.rest.webservices.versioning;

public class PersonV1 {
	
	private Name name;
	public PersonV1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public PersonV1(Name name) {
		super();
		this.name = name;
	}
	
	

}
