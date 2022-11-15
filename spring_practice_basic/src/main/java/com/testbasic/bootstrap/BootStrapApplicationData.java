package com.testbasic.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import com.testbasic.entity.Student;
import com.testbasic.repository.StudentRepo;

@Configuration
public class BootStrapApplicationData {

	@Autowired
	private  StudentRepo repo;
	
	@EventListener(ApplicationReadyEvent.class)
	public void insertData(ApplicationReadyEvent event) {
		Student student = new Student();
		student.setFirstName("Anurag");
		student.setLastName("Deshmukh");
		student.setEmail("anurag@gmail.com");
		
		Student student1 = new Student();
		student1.setFirstName("Akash");
		student1.setLastName("Raut");
		student1.setEmail("akash@gmail.com");
	
		this.repo.save(student);
		this.repo.save(student1);
		
}
}

