package com.learn.Hibernate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.Hibernate.entity.Student;
import com.learn.Hibernate.repository.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	StudentRepo repo;
	
	
	public Optional<Student> findByID(int id) {
		return repo.findById(id);

}
	
	public List<Student> findAll(){
		return repo.findAll();
	}
	
	
	public Student SaveOrUpdate(Student entity) {
		
		Optional<Student> stu=repo.findById(entity.getId());
		
		if(stu.isPresent()) {
			Student newEntity=stu.get();
			newEntity.setFirst_name(entity.getFirst_name());
			newEntity.setLast_name(entity.getLast_name());
			newEntity.setEmail(entity.getEmail());
			
			newEntity=repo.save(newEntity);
			
			return newEntity;
		}else {
			entity=repo.save(entity);
			return entity;
		}
	}
	
	public String deleteStudent(int id) {
		repo.deleteById(id);
		return "User ID Deleted" + id;
	}
}
