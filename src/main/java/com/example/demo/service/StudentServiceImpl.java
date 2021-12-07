package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.dao.StudentDao;
import com.example.demo.models.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	
	@Autowired
	private StudentDao studentDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Student> findAll() {
		
		return (List<Student>) studentDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Student findById(Long id) {
		
		return studentDao.findById(id).orElse(null);
	}
	
	
	@Override
	@Transactional
	public Student save(Student student) {
		
		return studentDao.save(student);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		
		studentDao.deleteById(id);
		
	}

}
