package com.education.education.models;

import jakarta.persistence.Column;

public class Manager {
	
	private String name;
	
	private String employeeId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Manager(String name, String employeeId) {
		super();
		this.name = name;
		this.employeeId = employeeId;
	}

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Manager [name=" + name + ", employeeId=" + employeeId + "]";
	}
	
}
