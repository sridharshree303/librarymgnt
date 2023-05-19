package com.triveous.librarymgnt.services;

import java.util.List;

import com.triveous.librarymgnt.modal.Book;
import com.triveous.librarymgnt.modal.Student;

public interface StudentServices {
	
	public Student saveStudent(Student student);
	
	
	//list of students
	public List<Student> listOfStudents();
	
	//Books taken by student
	public List<Book> booksByStudent(Long studentId);
}
