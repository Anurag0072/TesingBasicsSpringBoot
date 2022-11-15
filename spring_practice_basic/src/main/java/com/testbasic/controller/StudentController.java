package com.testbasic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testbasic.entity.Student;
import com.testbasic.service.StudentService;



@RestController
@RequestMapping("/student/v1/api")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@GetMapping()
	public List<Student> getAllStudents() {
	      List<Student> allstud=this.service.allStudents();
	      return allstud;
	}
	
	@GetMapping("/{id}")
	public Student getStudentByid(@PathVariable("id") long id) {
		Student student = this.service.findById(id);
		return student;
	}
	
	@PostMapping()
	public Student addStudent(@RequestBody() Student student) {
		Student newstudent =this.service.NewStudent(student);
		return newstudent;
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@RequestBody()Student student, @PathVariable("id") long id) {
		Student updatedstudent = this.service.updateStudent(id, student);
		return updatedstudent;
	}
	
	@DeleteMapping("/{id}")
	public void DeleteStudent(@PathVariable("id") long id) {
		this.service.deleteStudent(id);
	}
	
}
