package com.marketing.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="marketing_manager")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MarketingManager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id",insertable = false, nullable = true)
	private Long userId;
	
	@Column(name="name")
	private String name;
	
	@Column(name = "employee_id")
	private String employeeId;
	
	@OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
	List<Tickets> tickets=new ArrayList<>();

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

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "MarketingManager [userId=" + userId + ", name=" + name + ", employeeId=" + employeeId + "]";
	}

	public MarketingManager(Long userId, String name, String employeeId) {
		super();
		this.userId = userId;
		this.name = name;
		this.employeeId = employeeId;
	}

	public MarketingManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
