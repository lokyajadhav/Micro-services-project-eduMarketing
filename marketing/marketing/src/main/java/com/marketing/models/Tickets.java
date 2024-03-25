package com.marketing.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tickets")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tickets {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ticket_id",insertable = false, nullable = true)
	private Long ticketId;
	
	@Column(name="generated_date")
	private String generatedDate;
	
	@Column(name="course")
	private long course;
	
	@Column(name="student")
	private long student;
	
	@Column(name="instructor")
	private long instructor;
	
	@Column(name="status")
	private String status;
	
	transient private String insName;
	transient private String stuName;
	transient private String courseName;
	
	
	
	 public Tickets(Long ticketId, String generatedDate, long course, long student, long instructor, String status,
			String insName, String stuName, String courseName, MarketingManager manager) {
		super();
		this.ticketId = ticketId;
		this.generatedDate = generatedDate;
		this.course = course;
		this.student = student;
		this.instructor = instructor;
		this.status = status;
		this.insName = insName;
		this.stuName = stuName;
		this.courseName = courseName;
		this.manager = manager;
	}

	public String getInsName() {
		return insName;
	}

	public void setInsName(String insName) {
		this.insName = insName;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Tickets(Long ticketId, String generatedDate, long course, long student, long instructor, String status,
			MarketingManager manager) {
		super();
		this.ticketId = ticketId;
		this.generatedDate = generatedDate;
		this.course = course;
		this.student = student;
		this.instructor = instructor;
		this.status = status;
		this.manager = manager;
	}

	public long getCourse() {
		return course;
	}

	public void setCourse(long course) {
		this.course = course;
	}

	public long getStudent() {
		return student;
	}

	public void setStudent(long student) {
		this.student = student;
	}

	public long getInstructor() {
		return instructor;
	}

	public void setInstructor(long instructor) {
		this.instructor = instructor;
	}

	@ManyToOne(cascade = CascadeType.ALL)
		
	 @JoinColumn(name="marketing_manager_id")
			
	 MarketingManager manager;

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public String getGeneratedDate() {
		return generatedDate;
	}

	public void setGeneratedDate(String generatedDate) {
		this.generatedDate = generatedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public MarketingManager getManager() {
		return manager;
	}

	public void setManager(MarketingManager manager) {
		this.manager = manager;
	}

	

	@Override
	public String toString() {
		return "Tickets [ticketId=" + ticketId + ", generatedDate=" + generatedDate + ", course=" + course
				+ ", student=" + student + ", instructor=" + instructor + ", status=" + status + ", insName=" + insName
				+ ", stuName=" + stuName + ", courseName=" + courseName + ", manager=" + manager + "]";
	}

	public Tickets(Long ticketId, String generatedDate, String status, MarketingManager manager) {
		super();
		this.ticketId = ticketId;
		this.generatedDate = generatedDate;
		this.status = status;
		this.manager = manager;
	}

	public Tickets() {
		super();
		// TODO Auto-generated constructor stub
	}
			
	

}
