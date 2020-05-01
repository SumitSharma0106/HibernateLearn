package com.learn.Hibernate.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.Hibernate.entity.Student;
import com.learn.Hibernate.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@GetMapping("/{id}")
	public Optional<Student> getStudentByID(@PathVariable int id) {
		return service.findByID(id);
	}
	
	@GetMapping
	public List<Student> findAll(){
		return service.findAll();
	}

	@PostMapping
	public Student SaveOrUpdate(@RequestBody Student entity) {
		return service.SaveOrUpdate(entity);

	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		service.deleteStudent(id);
		return "User ID Deleted " + id;
	}
	
}
