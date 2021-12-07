package com.example.demo.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Student;

public interface StudentDao extends CrudRepository<Student, Long> {
	
	
}
