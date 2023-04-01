package com.triveous.librarymgnt.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triveous.librarymgnt.modal.Student;
import com.triveous.librarymgnt.repository.StudentRepository;

@Service
public class StudentServicesImple implements StudentServices{
	
	private static final Logger LOG = LoggerFactory.getLogger(StudentServicesImple.class);
	
	@Autowired
	private StudentRepository studentrepository;

	@Override
	public Student saveStudent(Student student) {
		LOG.info("Student services - saving student");
		Student data = studentrepository.save(student);
		LOG.info("Student services - saved student");
		return data;
	}
	

	@Override
	public List<Student> listOfStudents() {
		LOG.info("Student services - requested student list");
		List<Student> list = studentrepository.findAll();
		LOG.info("Student services - returned list");
		return list;
	}

}
