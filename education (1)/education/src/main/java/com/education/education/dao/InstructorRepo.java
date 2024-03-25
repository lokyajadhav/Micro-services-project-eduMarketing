package com.education.education.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.education.education.models.Instructor;

@Repository
public interface InstructorRepo extends JpaRepository<Instructor, Long> {
	@Query(value = "Select * from instructor",nativeQuery = true)
	List<Instructor> getAllInstructors();

}
