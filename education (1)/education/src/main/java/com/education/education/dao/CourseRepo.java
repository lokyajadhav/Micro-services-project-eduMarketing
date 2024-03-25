package com.education.education.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.education.education.models.Courses;

import jakarta.transaction.Transactional;
@Repository
public interface CourseRepo extends JpaRepository<Courses, Long> {

	@Query(value = "SELECT * FROM courses", nativeQuery = true)
	List<Courses> getAllCourses();
	@Modifying
	@Transactional
	@Query(value = "update courses set instructor_id=:instructor_id where course_id=:course_id",nativeQuery = true)
	void assignCourseToInstructor(long course_id, long instructor_id);
	
	@Modifying
	@Transactional
	@Query(value = "insert into students_courses values(:course_id, :student_id)",nativeQuery = true)
	void assignCourseToStudent(long course_id, long student_id);

}
