package com.triveous.librarymgnt.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.triveous.librarymgnt.modal.Book;
import com.triveous.librarymgnt.modal.Student;
import com.triveous.librarymgnt.services.StudentServices;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentServices studentservices;
	
	@PostMapping("/save")
	public Student saveStuddent(@RequestBody Student student) {
		LOG.info("Student controller - saving student data");
		LOG.info(student.toString());
		Student res = studentservices.saveStudent(student);
		LOG.info(res.toString());
		LOG.info("Student controller - returned saved student data");
		return res;
	}
	
	@GetMapping("/list")
	public List<Student> stdudentList(){
		LOG.info("Student controller - requested student list");
		List<Student> list = studentservices.listOfStudents();
		LOG.info("Student controller - returned studentn list");
		return list;
	}
	
	@GetMapping("/books/{studentId}")
	private List<Book> listOfBooksOfStudent(@PathVariable long studentId){
		LOG.info("Student Controller - reuqested student books");
		List<Book> list = studentservices.booksByStudent(studentId);
		LOG.info("Student Controller - returned student book list");
		return list;
	}
}
