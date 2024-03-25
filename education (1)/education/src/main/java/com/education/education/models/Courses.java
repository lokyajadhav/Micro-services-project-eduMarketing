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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="courses")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Courses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="course_id",insertable = false, nullable = true)
	private Long courseId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String descrition;
	
	@Column(name="duration")
	private int duration;
	
	@Column(name="price")
	private int price;
	
	@Column(name="marketing_manager")
	private long marketingManager;
	
	transient private String marketingManagerName;
	

	public Courses(Long courseId, String name, String descrition, int duration, int price, long marketingManager,
			String marketingManagerName, List<Students> students, Instructor instructor) {
		super();
		this.courseId = courseId;
		this.name = name;
		this.descrition = descrition;
		this.duration = duration;
		this.price = price;
		this.marketingManager = marketingManager;
		this.marketingManagerName = marketingManagerName;
		this.students = students;
		this.instructor = instructor;
	}

	public String getMarketingManagerName() {
		return marketingManagerName;
	}

	public void setMarketingManagerName(String marketingManagerName) {
		this.marketingManagerName = marketingManagerName;
	}



	public Long getCourseId() {
		return courseId;
	}
	 @ManyToMany(cascade = CascadeType.ALL)
	    @JoinTable(
	            name = "students_courses",
	            joinColumns = @JoinColumn(name = "course_id"),
	            inverseJoinColumns = @JoinColumn(name = "student_id")
	    )
	List<Students> students=new ArrayList<>();
	 
	 @ManyToOne(cascade = CascadeType.ALL)
	
	 @JoinColumn(name="instructor_id")
			
	 Instructor instructor;
	 
	 
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

	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Courses(Long courseId, String name, String descrition, int duration, int price, long marketingManager) {
		super();
		this.courseId = courseId;
		this.name = name;
		this.descrition = descrition;
		this.duration = duration;
		this.price = price;
		this.marketingManager = marketingManager;
	}

	@Override
	public String toString() {
		return "Courses [courseId=" + courseId + ", name=" + name + ", descrition=" + descrition + ", duration="
				+ duration + ", price=" + price + ", marketingManager=" + marketingManager + ", marketingManagerName="
				+ marketingManagerName + ", students=" + students + ", instructor=" + instructor + "]";
	}
	
	

}
