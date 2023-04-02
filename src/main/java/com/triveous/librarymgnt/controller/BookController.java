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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.triveous.librarymgnt.exception.AuthorNotFoundException;
import com.triveous.librarymgnt.exception.BookInputMismatchException;
import com.triveous.librarymgnt.exception.BookNotFoundException;
import com.triveous.librarymgnt.modal.Book;
import com.triveous.librarymgnt.services.BookServices;

@RestController
@RequestMapping("/book")
public class BookController {
	
	private static final Logger LOG = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookServices bookServices;
	
	@PostMapping("/save")
	public ResponseEntity<Book> saveBook(@RequestBody Book book) throws BookInputMismatchException {
		LOG.info("Book controller - saving book");
		Book data = bookServices.saveBook(book);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Book saved successfully");
		LOG.info("Book controller - returning book");
		ResponseEntity<Book> response = new ResponseEntity<Book>(data,headers,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/list")
	public List<Book> getAllBooks(){
		LOG.info("Book controller - requesting List");
		List<Book> list = bookServices.listAllBooks();
		LOG.info("Book controller - returning List");
		return list;
	}
	
	@GetMapping("/list/{title}")
	public ResponseEntity<Book> viewBook(@PathVariable String title) throws BookNotFoundException {
		LOG.info("Book controller - requesting book object");
		Book book = bookServices.viewBook(title);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message","Book data returned");
		headers.add("file-format","JSON");
		LOG.info("Book controller - returned book object");
		ResponseEntity<Book> response = new ResponseEntity<Book>(book,headers,HttpStatus.OK);
		return response;
	}
}
