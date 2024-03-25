package com.marketing.microServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.marketing.models.Course;
import com.marketing.models.Instructor;
import com.marketing.models.Student;

@FeignClient(url="http://localhost:8040", value = "Education-Client")
//@FeignClient(url="MARKETING") if we implement load balancing we dynamically give the client url by its name/ID in the service registry
public interface EducationService {
	
	@GetMapping("/education/getCourse/{courseId}")
	Course getCourse(@PathVariable long courseId);
	
	@GetMapping("/education/getStudent/{courseId}")
	Student getStudent(@PathVariable long courseId);
	
	@GetMapping("/education/getInstructor/{courseId}")
	Student getInstructor(@PathVariable long courseId);

}
