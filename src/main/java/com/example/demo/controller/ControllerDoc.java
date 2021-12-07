package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.entity.Student;


public interface ControllerDoc {
	
	
	ResponseEntity<?> readAll();


	ResponseEntity<?> read(Long id);


	ResponseEntity<?> create(Student student);

	
	ResponseEntity<?> update(Student student, Long id);

	
	ResponseEntity<?> delete(Long id);

	
	ResponseEntity<?> upload(MultipartFile file, Long id);

	
	ResponseEntity<?> getImage(String name);

}
