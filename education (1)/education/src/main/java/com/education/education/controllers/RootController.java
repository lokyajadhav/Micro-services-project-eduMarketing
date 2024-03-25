package com.education.education.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.education.education.dao.CourseRepo;
import com.education.education.dao.InstructorRepo;
import com.education.education.dao.StrudentsRepo;
import com.education.education.microServices.MarketingClinet;
import com.education.education.models.Courses;
import com.education.education.models.Instructor;
import com.education.education.models.Students;


@Controller
@RequestMapping("/education")
public class RootController {
	
	@Autowired
	CourseRepo courseRepo;
	
	@Autowired
	StrudentsRepo stuRepo;
	
	@Autowired
	InstructorRepo instructorRepo;
	@Autowired
	MarketingClinet marketingClinet;
	@PostMapping("/addCourse")
	ResponseEntity<?> addCouse(@RequestBody Courses course)
	{
		try
		{
			return ResponseEntity.status(HttpStatus.OK).body(courseRepo.save(course));
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
		}
	}
	@GetMapping("/getCourse/{courseId}")
	ResponseEntity<?> getCourse(@PathVariable long courseId)
	{
		try
		{
			Courses course=courseRepo.getById(courseId);
			 Hibernate.initialize(course); 
			System.err.println(course);
			return  ResponseEntity.status(HttpStatus.OK).body(course);
			
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
		}
	}
	@GetMapping("/getAllCourses")
	ResponseEntity<?> getAllCorses()
	{
		try
		{
			List<Courses> courses=courseRepo.findAll();
			List<Courses> updateCourses=courses.stream().map(course->{
				course.setMarketingManagerName(marketingClinet.getManager(course.getMarketingManager()).getName());
				return course;
					
			}).collect(Collectors.toList());
			return ResponseEntity.status(HttpStatus.OK).body(updateCourses);
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
		}
	}
	@PostMapping("/addStudent")
	ResponseEntity<?> addStuent(@RequestBody Students course)
	{
		try
		{
			return ResponseEntity.status(HttpStatus.OK).body(stuRepo.save(course));
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
		}
	}
	@GetMapping("/getStudent/{courseId}")
	ResponseEntity<?> getStudent(@PathVariable long courseId)
	{
		try
		{
			return ResponseEntity.status(HttpStatus.OK).body(stuRepo.getById(courseId));
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
		}
	}
	@GetMapping("/getAllStudents")
	ResponseEntity<?> getAllStudents()
	{
		try
		{
			return ResponseEntity.status(HttpStatus.OK).body(stuRepo.getAllStudents());
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
		}
	}
	@PostMapping("/addInstructor")
	ResponseEntity<?> addInstructor(@RequestBody Instructor course)
	{
		try
		{
			return ResponseEntity.status(HttpStatus.OK).body(instructorRepo.save(course));
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
		}
	}
	@GetMapping("/getInstructor/{courseId}")
	ResponseEntity<?> getInstructor(@PathVariable long courseId)
	{
		try
		{
			return ResponseEntity.status(HttpStatus.OK).body(instructorRepo.getById(courseId));
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
		}
	}
	@GetMapping("/getAllInstructor")
	ResponseEntity<?> getAllInstructor()
	{
		try
		{
			return ResponseEntity.status(HttpStatus.OK).body(instructorRepo.getAllInstructors());
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
		}
	}
	
	@GetMapping("/assignCourseTOInstructor/{courseId}/{instructorId}")
	ResponseEntity<?> AssignCourseToInstructor(@PathVariable long courseId, @PathVariable long instructorId)
	{
		Map<String, String> response=new  HashMap<>();
		try
		{
			courseRepo.assignCourseToInstructor(courseId,instructorId);
			response.put("msg", "Course Assigned to Instructor!");
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		catch(Exception e)
		
		{
			response.put("msg", e.getMessage());
			return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
		}
	}
	@GetMapping("/assignCourseTOStudent/{courseId}/{studentId}")
	ResponseEntity<?> AssignCourseToStudent(@PathVariable long courseId, @PathVariable long studentId)
	{
		Map<String, String> response=new  HashMap<>();
		try
		{
			courseRepo.assignCourseToStudent(courseId,studentId);
			response.put("msg", "Course Assigned to Student!");
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		catch(Exception e)
		
		{
			response.put("msg", e.getMessage());
			return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
		}
	}

}
