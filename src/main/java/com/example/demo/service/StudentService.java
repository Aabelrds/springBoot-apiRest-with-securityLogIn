package com.example.demo.service;

import java.util.List;

import com.example.demo.models.entity.Student;


public interface StudentService {
	
	public List<Student> findAll();
	
	public Student findById(Long id);
	
	public Student save(Student student);

	public void deleteById(Long id);
}
	
	