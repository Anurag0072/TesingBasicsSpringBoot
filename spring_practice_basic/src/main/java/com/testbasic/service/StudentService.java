package com.testbasic.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.testbasic.entity.Student;
import com.testbasic.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo repo;

	public Student NewStudent(Student student) {
		Student newStudent = this.repo.save(student);
		return newStudent;
	}
	public Student findById(long id) {
		return this.repo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("invalid student id passed"));
	}
	public List<Student> allStudents() {
		List<Student> allstud = this.repo.findAll();
		return allstud;

	}
	public Student updateStudent(long id, Student student) {
		Student upstudent = this.findById(id);
		upstudent.setFirstName(student.getFirstName());
		upstudent.setLastName(student.getLastName());
		upstudent.setEmail(student.getEmail());
		this.repo.save(upstudent);
		return upstudent;
	}
	public void deleteStudent(long id) {
		this.repo.deleteById(id);
	}
}
