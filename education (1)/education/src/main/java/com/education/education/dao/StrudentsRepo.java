package com.education.education.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.education.education.models.Students;

@Repository
public interface StrudentsRepo extends JpaRepository<Students, Long> {

	@Query(value = "SELECT * from students" , nativeQuery = true)
	List<Students> getAllStudents();

}
