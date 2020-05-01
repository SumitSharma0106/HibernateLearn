package com.learn.Hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.Hibernate.entity.Student;

public interface StudentRepo extends JpaRepository<Student,Integer> {


}
