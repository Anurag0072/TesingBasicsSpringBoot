package com.testbasic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testbasic.entity.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

	
}