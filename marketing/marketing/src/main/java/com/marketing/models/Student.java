package com.marketing.models;

import jakarta.persistence.Column;

public class Student {
	
	private Long userId;
	

	private String name;
	
	
	private String address;


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Student [userId=" + userId + ", name=" + name + ", address=" + address + "]";
	}


	public Student(Long userId, String name, String address) {
		super();
		this.userId = userId;
		this.name = name;
		this.address = address;
	}


	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
