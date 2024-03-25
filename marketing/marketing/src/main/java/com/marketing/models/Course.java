package com.marketing.models;

import jakarta.persistence.Column;

public class Course {

	
	
	private Long courseId;
	
	
	private String name;
	
	
	private String descrition;
	

	private int duration;
	
	
	private int price;
	
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(Long courseId, String name, String descrition, int duration, int price, long marketingManager,
			String marketingManagerName) {
		super();
		this.courseId = courseId;
		this.name = name;
		this.descrition = descrition;
		this.duration = duration;
		this.price = price;
		this.marketingManager = marketingManager;
		this.marketingManagerName = marketingManagerName;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name + ", descrition=" + descrition + ", duration="
				+ duration + ", price=" + price + ", marketingManager=" + marketingManager + ", marketingManagerName="
				+ marketingManagerName + "]";
	}

	private long marketingManager;
	
	 public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescrition() {
		return descrition;
	}

	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public long getMarketingManager() {
		return marketingManager;
	}

	public void setMarketingManager(long marketingManager) {
		this.marketingManager = marketingManager;
	}

	public String getMarketingManagerName() {
		return marketingManagerName;
	}

	public void setMarketingManagerName(String marketingManagerName) {
		this.marketingManagerName = marketingManagerName;
	}

	private String marketingManagerName;
}
