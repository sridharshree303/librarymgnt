package com.triveous.librarymgnt.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<Student> saveStuddent(@RequestBody Student student) {
		LOG.info("Student controller - saving student data");
		Student res = studentservices.saveStudent(student);
		LOG.info("Student controller - returned saved student data");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message","Student data saved");
		return new ResponseEntity<Student>(res,headers,HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Student>> studentList(){
		LOG.info("Student controller - requested student list");
		List<Student> list = studentservices.listOfStudents();
		LOG.info("Student controller - returned studentn list");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message","list of students");
		return new ResponseEntity<List<Student>>(list,headers,HttpStatus.OK);
	}
	
	@GetMapping("/books/{studentId}")
	private ResponseEntity<List<Book>> listOfBooksOfStudent(@PathVariable long studentId){
		LOG.info("Student Controller - reuqested student books");
		List<Book> list = studentservices.booksByStudent(studentId);
		LOG.info("Student Controller - returned student book list");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message","list of books taken by student");
		return new ResponseEntity<List<Book>>(list,headers,HttpStatus.OK);
	}
}
