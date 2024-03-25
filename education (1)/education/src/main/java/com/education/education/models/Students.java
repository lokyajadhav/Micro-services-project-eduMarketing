package com.education.education.models;



import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Students {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	 @ManyToMany(mappedBy = "students", cascade = CascadeType.ALL)
	    private List<Courses> courses = new ArrayList<>();
	
	public Students(Long userId, String name, String address, List<Courses> courses) {
		super();
		this.userId = userId;
		this.name = name;
		this.address = address;
		this.courses = courses;
	}

	public List<Courses> getCourses() {
		return courses;
	}

	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}

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

	public Students(Long userId, String name, String address) {
		super();
		this.userId = userId;
		this.name = name;
		this.address = address;
	}

	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Students [userId=" + userId + ", name=" + name + ", address=" + address + "]";
	}
	
	
	

}
